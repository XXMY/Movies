package cfw.movies.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cfw.movies.controller.BaseController;
import cfw.movies.dto.AjaxRequestResult;
import cfw.movies.dto.MovieComment;
import cfw.movies.dto.MovieSubmit;
import cfw.movies.dto.Page;
import cfw.movies.model.Descriptions;
import cfw.movies.model.Movies;
import cfw.movies.model.Types;
import cfw.movies.service.MovieService;
import cfw.util.CodeHelper;

/**
 * The controller contains movies' operations.
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午3:04:14
 */
@Controller("adminMovieController")
@RequestMapping("/admin")
public class AdminMoviesController extends BaseController{
	
	@Autowired
	private MovieService movieService;
	
	/**
	 * Finish the movie submit operation.
	 * @author Fangwei_Cai
	 * @time since 2016年4月11日 上午10:45:52
	 */
	@RequestMapping(value="/movie_submit",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRequestResult movieSubmit(HttpServletRequest request,String type){
		MovieSubmit movieSubmit = (MovieSubmit) request.getAttribute("movieSubmit");
		
		Descriptions description = new Descriptions(movieSubmit.getDescription());
		
		Movies movie = new Movies(movieSubmit.getName(), type, description, movieSubmit.getMainPicture());
		
		boolean addMovieResult = this.movieService.addMovie(movie);
		
		if(addMovieResult){
			return buildAjaxResult(1, "添加成功");
		}
		
		return buildAjaxResult(0, "添加失败");
		
	}
	
}
