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
		String urlHead = "http://cfw.movies.com/dy2018/i/";
		int number = 92006;
		int times = 1;
		CatchController catchC = new CatchController();
		for(int i=number;i<=92006;i++){
			System.out.println("~~~~~~~~~ " + i +" ~~~~~~~~~~");
			String url = urlHead + i + ".html";
			String html = sendGet(url, "");
			Movies movie = catchC.packMovie(html);
			System.out.println(new Date().getTime() - start.getTime());
			System.out.println(movie);
		}
		/*
		CatchController catchC = new CatchController();
		
		Movies movie = catchC.packMovie(html);
		System.out.println(new Date().getTime() - start.getTime());
		System.out.println(movie);
		System.out.println(movie.getScore());*/
	}
}
