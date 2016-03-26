package cfw.movies.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cfw.movies.mapper.ProblemsMapper;
import cfw.movies.model.Problems;

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
	//@ResponseBody
	public String test(HttpServletResponse response,HttpServletRequest request) throws IOException{
		System.out.println("get in");
		//response.setHeader("Access-Control-Allow-Origin", "*");
		//response.setHeader("Access-Control-Allow-Headers", "Msg,V,uuid,Content-Type");
	//	response.addHeader("Access-Control-Allow-Credentials", "true");
		//response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		//response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		
		/*String name = request.getParameter("name");
		
		System.out.println("name:"+name);*/
		
		StringBuilder stb = new StringBuilder();
		BufferedReader bufferedReader = request.getReader();
		char [] buff = new char[1024];
		int len;
		while((len = bufferedReader.read(buff)) != -1){
			stb.append(buff, 0 ,len);
		System.out.println(stb.toString());
		}
		
		String name1 = request.getParameter("name");
		
		System.out.println("name1:"+name1);
		return name1;
	}
}
