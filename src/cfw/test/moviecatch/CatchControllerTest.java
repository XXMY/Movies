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
		
		Date start = new Date();
		String urlHead = "http://cfw.test.com:83/dy2018/i/94001.html";
		String html = sendGet(urlHead, "");
		
		CatchController catchC = new CatchController();
		
		Movies movie = catchC.packMovie(html);
		System.out.println(new Date().getTime() - start.getTime());
		System.out.println(movie);
	}
}
