package cfw.movies.controller;

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
	public String test(HttpServletResponse response,HttpServletRequest request) {
		
		
		return null;
	}
}
