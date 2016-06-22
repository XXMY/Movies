package cfw.test.moviecatch;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import cfw.movies.thread.MovieCatchThread;
import static cfw.movies.controller.moviecatch.HttpRequest.*;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月21日 上午11:12:03
 */
public class MoveCatchTest {

	@Test
	public void testSendGet() throws UnsupportedEncodingException{

		String urlHead = "http://cfw.test.com:83/dy2018/i/";
		int number = 94001; 
		for(int i=number;i<94005;i++){
			String url = urlHead + i + ".html";
			boolean result = checkUrlAccess("http://ww4.sinaimg.cn/large/7156d016jw1f32i5otmpjj20xc1c1wsz.jpg");
			System.out.println(result);
			
		}
		
	}
}
