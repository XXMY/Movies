package cfw.movies.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cfw.movies.mapper.ProblemsMapper;
import cfw.movies.model.Descriptions;
import cfw.movies.model.Movies;
import cfw.movies.model.Problems;
import cfw.movies.model.Types;
import cfw.movies.service.MovieService;

/**
 * @author Fangwei_Cai
 * @time since 2016年2月28日 下午7:56:03
 */
@Controller
@RequestMapping("/Index")
public class IndexController {

	@Autowired
	private ProblemsMapper problemsMapper;
	
	
	@RequestMapping("/index")
	@ResponseBody
	public String index(){
		Problems problems = new Problems("蔡方伟");
		//this.problemsMapper.updateOne(problems);
		
		System.err.println(problems.toString());
		
		return "Hello Movies";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	public String test(HttpServletResponse response,HttpServletRequest request) throws Exception {
		/*StringBuilder stb = new StringBuilder();
		BufferedReader bufferedReader = request.getReader();
		char [] buff = new char[1024];
		int len;
		while((len = bufferedReader.read(buff)) != -1){
			stb.append(buff, 0 ,len);
			System.out.println(stb.toString());
		}*/
		InputStream inputStream = request.getInputStream();
		DataInputStream dataInputStream = new DataInputStream(inputStream);
		byte [] bytes = new byte[1024 * 1024];
		
		int nRead = 1;  
        int nTotalRead = 0;  
        while (nRead > 0) {  
            nRead = inputStream.read(bytes, nTotalRead, bytes.length - nTotalRead);  
            if (nRead > 0)  
                nTotalRead = nTotalRead + nRead;  
        }
        String str = new String(bytes, 0, nTotalRead, "utf-8");  
        System.out.println("Str:" + str);  
		return null;
	}
	
	@RequestMapping("/")
	@ResponseBody
	public String test2(){
		
		return "works";
	}
}
