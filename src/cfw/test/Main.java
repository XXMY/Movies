package cfw.test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args){
		String param = "tempFilePath=20160410-64b842a4-58fb-48ba-aa73-b95b8e2cd4d5.jpeg&name=&description=<p><img class='fr-dib fr-draggable' src='http://cfw.movies.com/temp/20160410/20160410-48bd95aa-92d3-40d6-9a91-773e0c701f78.jpg' style='width: 300px;' data-status='1' data-message='文件上传成功' data-tempfilename='20160410-48bd95aa-92d3-40d6-9a91-773e0c701f78.jpg'><img class='fr-dib fr-draggable' src='http://cfw.movies.com/temp/20160410/20160410-993f6a86-ddf1-48eb-ae3a-040c321897de.jpg' style='width: 300px;' data-status='1' data-message='文件上传成功' data-tempfilename='20160410-993f6a86-ddf1-48eb-ae3a-040c321897de.jpg'><img class='fr-dib fr-draggable' src='http://cfw.movies.com/temp/20160410/20160410-e8ee99c8-98d0-4b8e-a493-d9254ea2607e.jpg' style='width: 300px;' data-status='1' data-message='文件上传成功' data-tempfilename='20160410-e8ee99c8-98d0-4b8e-a493-d9254ea2607e.jpg'></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><br></p><p><img class='fr-dib fr-draggable' src='http://cfw.movies.com/temp/20160410/20160410-46347a08-35e2-4067-9415-fe3232388322.png' style='width: 300px;' data-status='1' data-message='文件上传成功' data-tempfilename='20160410-46347a08-35e2-4067-9415-fe3232388322.png'></p>";
		
		Pattern pattern = Pattern.compile("http://cfw.movies.com/temp/.{54}\\.((jpg)|(png))");
		
		Matcher matcher = pattern.matcher(param);
		
		String replacement = "cfw";
		if(matcher.find()){
			System.out.println(matcher.group().substring(36));
		}
	}
}
