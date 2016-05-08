package cfw.movies.controller.moviecatch;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cfw.movies.model.Descriptions;
import cfw.movies.model.Movies;
import cfw.movies.service.MovieService;
import static cfw.movies.controller.moviecatch.HttpRequest.*;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月21日 上午10:58:35
 */
@Controller
@RequestMapping("/catch")
public class CatchController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/movies",method=RequestMethod.GET)
	@ResponseBody
	public String movieCatch() throws Exception{
		
		String urlHead = "http://cfw.movies.com/dy2018/i/";
		int number = 93001;
		int times = 1;
		for(int i=number;i<=96854;i++){
			System.out.println("~~~~~~~~~ " + i +" ~~~~~~~~~~");
			String url = urlHead + i + ".html";
			String html = sendGet(url, "");
			Movies movie = packMovie(html);
			if(movie == null) continue;
			System.err.println("********* times： "+ ++times +" ************");
			movieService.addMovie(movie);
		}
		
		return "Finished";
	}
	
	/**	
	 * Process the html page string, get the information
	 * which is in need.
	 * @param html {String}
	 * @author Fangwei_Cai
	 * @time since 2016年4月21日 下午2:11:23
	 */
	public Movies packMovie(String html){
		
		Movies movie = new Movies();
		
		getName(html,movie);
		
		boolean picResult = getPicture(html, movie);
		
		boolean scoreResult = getScore(html,movie);
		
		boolean typeResult = getType(html, movie);
		
		boolean descriptResult = getDescript(html,movie);
		
		if(!picResult || !scoreResult || !typeResult || !descriptResult)
			return null;
		
		
		return movie;
	}

	private boolean getDescript(String html, Movies movie) {
		boolean result = false;
		
		//String descriptRegex = "<td colspan=\"2\" align=\"center\" valign=\"top\">.*</tr><SCRIPT";
		String descriptRegex = "<p>◎.*</table></td>";
		Pattern descriptPattern = Pattern.compile(descriptRegex);
		//System.out.println(html);
		Matcher descriptMatcher = descriptPattern.matcher(html);
		String descriptHtml;
		if(descriptMatcher.find()){
			descriptHtml = descriptMatcher.group();
			System.out.println(descriptHtml);
			String description = descriptHtml.substring(0,descriptHtml.length()-5);
			Descriptions descript = new Descriptions(description);
			movie.setDescription(descript);
			result = getAbstract(descriptHtml,movie);
		}
		
		return result;
	}
	
	private boolean getAbstract(String html, Movies movie) {
		boolean result = false;
		
		String abstractRegex = "<p>◎简　　介</p><p>&nbsp;</p><p>.*</p><p>&nbsp;</p>";
		Pattern abstractPattern = Pattern.compile(abstractRegex);
		Matcher abstractMatcher = abstractPattern.matcher(html);
		String abstractHtml = "";
		while(abstractMatcher.find()){
			String temp = abstractMatcher.group();
			abstractHtml = temp.substring(0, temp.length()-17);
			abstractMatcher = abstractPattern.matcher(abstractHtml);	
		}
		
		if(abstractHtml != ""){
			abstractHtml = abstractHtml.substring(28, abstractHtml.length());
			//System.out.println(abstractHtml);
			movie.getDescription().setAbstract_(abstractHtml);
			result = true;
		}
		
		return result;
	}

	private boolean getType(String html, Movies movie) {
		boolean result = false;
		// Get type.
		String typeRegex = "<span>类型：.*</a></span>";
		Pattern typePattern = Pattern.compile(typeRegex);
		Matcher typeMatcher = typePattern.matcher(html);
		if(typeMatcher.find()){
			String typeHtml = typeMatcher.group();
			typeRegex = "/[0-9]{1,2}/";
			typePattern = Pattern.compile(typeRegex);
			typeMatcher = typePattern.matcher(typeHtml);
			String typeString = "";
			while(typeMatcher.find()){
				String temp = typeMatcher.group();
				typeString += temp.substring(1, temp.length()-1) + "_";
			}
			movie.setType(typeString.substring(0, typeString.length()-1));
			result = true;
		}
		
		return result;
	}

	private boolean getScore(String html, Movies movie) {
		boolean result = false;
		// Get score.
		String scoreRegex = "<strong class=\"rank\">[0-9](|\\.[0-9])</strong>";
		Pattern scorePattern = Pattern.compile(scoreRegex);
		Matcher scoreMatcher = scorePattern.matcher(html);
		if(scoreMatcher.find()){
			String scoreString = scoreMatcher.group();
			scoreRegex = "(([0-9]\\.[0-9])|[0-9])";
			scorePattern = Pattern.compile(scoreRegex);
			scoreMatcher = scorePattern.matcher(scoreString);
			float score;
			if(scoreMatcher.find()){
				scoreString = scoreMatcher.group();
				score = Float.valueOf(scoreString);
				movie.setScore(score);
				result = true;
			}
		}
		
		return result;
	}

	private boolean getPicture(String html, Movies movie) {
		// Get main picture.
		String picRegex = "src=\"http:.*\\.((jpg)|(png))\" (style|borde|targe|alt=\"|heigh)";
		Pattern picPattern = Pattern.compile(picRegex);
		Matcher picMatcher = picPattern.matcher(html);
		boolean result = false;
		if(picMatcher.find()){
			String picPathHtml = picMatcher.group();
			picMatcher = picPattern.matcher(picPathHtml);
			while(picMatcher.find()){
				picPathHtml = picMatcher.group();
				picMatcher = picPattern.matcher(picPathHtml.substring(0,picPathHtml.length()-7));
			}
			
			String picPath = picPathHtml.substring(5, picPathHtml.length()-7);
			result = checkUrlAccess(picPath);
			movie.setPic(picPath);
		}
		
		return result;
	}

	private void getName(String html, Movies movie) {
		// Get name.
		String nameRegex = "<title>.*</title>";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(html);
		if(nameMatcher.find()){
			String name = "";
			String nameHtml = nameMatcher.group();
			nameRegex = "《.*》";
			namePattern = Pattern.compile(nameRegex);
			nameMatcher = namePattern.matcher(nameHtml);
			if(nameMatcher.find()){
				nameHtml = nameMatcher.group();
				name = nameHtml.substring(1,nameHtml.length()-1);
			}
			
			movie.setName(name);
		}
	}
}
