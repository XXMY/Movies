package cfw.test.moviecatch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import cfw.util.Folder;

/**
 * Save the picture of movies to local from Internet.
 * @author Fangwei_Cai
 * @time since 2016年5月8日 上午10:02:15
 */
public class SaveMoviePic {

	@Test
	public void save() throws Exception{
		String picUrl = "http://i13.tietuku.cn/0f081d2aa206b3b5.jpg";
		URL url = new URL(picUrl);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		
		InputStream input = connection.getInputStream();
		//int length = connection.getContentLength();
		int length = input.available(); 
		
		//FileOutputStream fileOut = (FileOutputStream) connection.getOutputStream();
		System.out.println(length);
		byte [] fileByte = new byte[length];
		for(int i=0;i<length;i++){
			fileByte[i] = (byte)input.read();
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		
		String fileName = format.format(date)+2719;
		File file = new File("E:\\MyCode\\Java\\MovieSource\\images\\download\\"+fileName+".jpg");
		
		FileOutputStream fileOut = new FileOutputStream(file);
		
		fileOut.write(fileByte);
		
		fileOut.close();
	}
	
	
}
