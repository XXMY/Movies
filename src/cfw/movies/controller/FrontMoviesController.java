package cfw.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cfw.movies.controller.BaseController;
import cfw.movies.dto.AjaxRequestResult;
import cfw.movies.dto.MovieComment;
import cfw.movies.dto.MovieDetails;
import cfw.movies.dto.Page;
import cfw.movies.model.Comments;
import cfw.movies.model.Movies;
import cfw.movies.service.MovieService;
import cfw.util.CodeHelper;

/**
 * The controller contains movies' operations.
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午3:04:14
 */
@Controller
@RequestMapping("/Movie")
public class FrontMoviesController extends BaseController{

	@Autowired
	private MovieService movieService;
	
	/**
	 * Get the movies as list.
	 * @author Fangwei_Cai
	 * @time since 2016年4月24日 下午4:39:10
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/movies",method=RequestMethod.GET)
	@ResponseBody
	public List<Movies> movieGet(Page page,@RequestParam(defaultValue="1")int flag){
		List<Movies> movies = null;
		
		movies = movieService.getMovies(page,flag);
		
		return movies;
	}
	
	@RequestMapping(value="/movies_count",method=RequestMethod.GET)
	@ResponseBody
	public Long movieCount(){
		Long count = null;
		
		count = movieService.countMovies();
		
		return count;
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月1日 下午2:46:09
	 * @param movieComment
	 * @return
	 */
	@RequestMapping(value="/comment",method=RequestMethod.POST)
	@ResponseBody
	public AjaxRequestResult movieComment(MovieComment movieComment){
		System.err.println(movieComment);
		AjaxRequestResult ajaxResult = buildAjaxResult(0, "评论失败");
		if(CodeHelper.isNullOrEmpty(movieComment.getComment()) || CodeHelper.isNull(movieComment.getMid()) || CodeHelper.isNullOrEmpty(movieComment.getUsername())){
			return ajaxResult;
		}
		
		boolean addCommentResult = movieService.addComment(movieComment);
		
		//boolean addCommentResult = false;
		
		if(addCommentResult)
			return buildAjaxResult(1,"评论成功");
		
		return ajaxResult;
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年5月7日 上午12:37:39
	 * @param id
	 * @return
	 */
	@RequestMapping("/one")
	@ResponseBody
	public AjaxRequestResult getOneMovie(Long id){
		AjaxRequestResult ajaxResult = null;
		
		if(id <= 0){
			ajaxResult = buildAjaxResult(0,"参数不正确");
			return ajaxResult;
		}
		
		Movies movie = this.movieService.getOneMovie(id);
		if(movie == null){
			ajaxResult = buildAjaxResult(0, "查询失败");
			return ajaxResult;
		}
		
		List<Comments> comments = this.movieService.getCommentsOfMovie(id);
	
		MovieDetails movieDetails = new MovieDetails(movie, comments);
		
		ajaxResult = buildAjaxResult(1,"查询成功");
		ajaxResult.setObject(movieDetails);
		
		return ajaxResult;
	}
	
}
