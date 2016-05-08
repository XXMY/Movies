package cfw.movies.controller.admin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cfw.movies.controller.BaseController;
import cfw.movies.dto.AjaxRequestResult;
import cfw.movies.dto.MovieComment;
import cfw.movies.dto.MovieSubmit;
import cfw.movies.dto.Page;
import cfw.movies.model.Descriptions;
import cfw.movies.model.Movies;
import cfw.movies.model.Types;
import cfw.movies.service.MovieService;
import cfw.util.CodeHelper;

/**
 * The controller contains movies' operations.
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午3:04:14
 */
@Controller("adminMovieController")
@RequestMapping("/admin")
public class AdminMoviesController extends BaseController{
	
	@Autowired
	private MovieService movieService;
	
	/**
	 * Finish the movie submit operation.
	 * @author Fangwei_Cai
	 * @time since 2016年4月11日 上午10:45:52
	 */
	@RequestMapping(value="/movie",method=RequestMethod.PUT)
	@ResponseBody
	public AjaxRequestResult movieSubmit(HttpServletRequest request,String type){
		MovieSubmit movieSubmit = (MovieSubmit) request.getAttribute("movieSubmit");
		
		Descriptions description = new Descriptions(movieSubmit.getDescription());
		
		Movies movie = new Movies(movieSubmit.getName(), type, description, movieSubmit.getMainPicture());
		
		boolean addMovieResult = this.movieService.addMovie(movie);
		
		if(addMovieResult){
			return buildAjaxResult(1, "添加成功");
		}
		
		return buildAjaxResult(0, "添加失败");
		
	}
	
	/**
	 * Delete movies.
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午9:40:49
	 * @param mid
	 * @return
	 */
	@RequestMapping(value="/movie",method=RequestMethod.GET)
	@ResponseBody
	public AjaxRequestResult movieDelete(Long mid){
		AjaxRequestResult ajaxResult = null;
		
		if(mid == null){
			ajaxResult = buildAjaxResult(0, "参数错误");
			return ajaxResult;
		}
		
		boolean deleteResult = false;
		//boolean deleteResult = this.movieService.deleteMovie(mid);
		
		if(deleteResult){
			ajaxResult = buildAjaxResult(1, "删除成功");
		}else{
			ajaxResult = buildAjaxResult(0, "删除失败");
		}
		
		return ajaxResult;
	}

	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月8日 下午9:00:40
	 * @return
	 * @throws IOException
	 */
	//@RequestMapping("/local")
	@ResponseBody
	public String localPicture() throws IOException {
		int num = 0;
		
		Map<String,Object> map = new HashMap<String,Object>();
		Long start = 0L;
		int length = 900;
		
		while(num==0){
			map.clear();
			map.put("start", start);
			map.put("length", length);
			
			List<Movies> movies = this.movieService.findPic(map);
			
			if(movies == null || movies.size()==0){
				return "Finished!";
			}
			
			InputStream input = null;
			FileOutputStream fileOut = null;
			try{
				for(Movies movie : movies){
					System.out.println("movie: "+movie.getId()+", "+movie.getName());
					String picUrl = movie.getPic();
					
					if(!picUrl.startsWith("http")) continue;
					
					URL url = new URL(picUrl);
					HttpURLConnection connection = (HttpURLConnection)url.openConnection();
					
					String contentType = connection.getContentType();
					if(contentType==null || !contentType.equalsIgnoreCase("image/jpeg") && !contentType.equalsIgnoreCase("image/png")){
						System.err.println(movie.getId());
						continue;
					}
					
					int cotentLength = connection.getContentLength();
					input = connection.getInputStream();
					int contentLength = input.available();
					
					if(cotentLength <= 0){
						System.err.println(movie.getId());
						continue;
					}
					byte [] fileByte = new byte[cotentLength];
					
					
					for(int i=0;i<cotentLength;i++){
						fileByte[i] = (byte)input.read();
					}
					
					Date date = new Date();
					SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
					
					
					String fileName = format.format(date)+movie.getId();
					
					if(contentType.equalsIgnoreCase("image/jpeg")) fileName += ".jpg";
					if(contentType.equalsIgnoreCase("image/png")) fileName += ".png";
					
					String persistPath = "E:\\MyCode\\Java\\MovieSource\\images\\download\\"+fileName;
					String picLink = "/images/download/"+fileName;
					
					File file = new File(persistPath);
					fileOut = new FileOutputStream(file);
					fileOut.write(fileByte);
					fileOut.close();
					
					map.clear();
					
					map.put("id", movie.getId());
					map.put("pic", picLink);
					boolean result = this.movieService.modifyPic(map);
					
					if(result){
						System.out.println(++num);
					}else{
						System.err.println(movie.getId());
					}
					
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(fileOut != null){
					fileOut.close();
				}
			}
			
		}
		return "";
		
	}
	
}
