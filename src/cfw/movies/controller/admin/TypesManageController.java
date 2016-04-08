package cfw.movies.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cfw.movies.model.Types;
import cfw.movies.service.MovieService;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月29日 上午9:48:37
 */
@Controller
@RequestMapping("/admin")
public class TypesManageController {
	
	@Autowired
	private MovieService movieService;

	
	@RequestMapping(value="/movieTypes",method=RequestMethod.GET)
	@ResponseBody
	public List<Types> movieTypes(){
		List<Types> movieTypes = movieService.getAllTypes();
		
		return movieTypes;
	}
	
	/*
	 * Setters and Getters
	 */
	public void setMovieService(MovieService movieService) {
		this.movieService = movieService;
	}
	
}
