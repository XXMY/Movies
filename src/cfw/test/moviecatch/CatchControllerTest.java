package cfw.test.moviecatch;

import static cfw.movies.controller.moviecatch.HttpRequest.sendGet;

import java.util.Date;

import org.junit.Test;

import cfw.movies.controller.moviecatch.CatchController;
import cfw.movies.model.Movies;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月21日 下午2:20:16
 */
public class CatchControllerTest {

	@Test
	public void testPackMovie(){
		
		float f = Float.valueOf("11.2");
		System.out.println(f);
		
		Date start = new Date();
		String urlHead = "http://cfw.movies.com/dy2018/i/96544.html";
		String html = sendGet(urlHead, "");
		
		CatchController catchC = new CatchController();
		
		Movies movie = catchC.packMovie(html);
		System.out.println(new Date().getTime() - start.getTime());
		System.out.println(movie);
		System.out.println(movie.getScore());
	}
}
