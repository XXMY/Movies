package cfw.test.service;

import org.junit.BeforeClass;
import org.junit.Test;

import cfw.movies.dto.MovieComment;
import cfw.movies.dto.Page;
import cfw.movies.model.Descriptions;
import cfw.movies.model.Movies;
import cfw.movies.model.Types;
import cfw.movies.service.MovieService;
import cfw.test.AbstractTest;
import cfw.test.utils.SpringUtils;
import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午9:07:33
 */
public class MovieServiceImplTest extends AbstractTest {
	
	private static MovieService movieServiceImpl;
	
	@BeforeClass
	public static void before(){
		movieServiceImpl = (MovieService)SpringUtils.getBean("movieServiceImpl");
	}
	
	/**
	 * Testing this function should disable the functions that are marked by @BeforeClass.
	 * @author Fangwei_Cai
	 * @time since 2016年4月8日 下午5:20:23
	 */
	//@Test
	public void testConsturct(){
		movieServiceImpl = (MovieService)SpringUtils.getBean("movieServiceImpl");
		assertThat(movieServiceImpl, notNullValue());
	}

	//@Test
	public void testAddMovie(){
		Descriptions abstracts = new Descriptions();
		abstracts.setDescription("<p>123</p>");
		
		Movies movies = new Movies();
		movies.setDescription(abstracts);
		movies.setName("叶问2");
		movies.setPic("http://www.baidu.com");
		movies.setType("1_2");
		movies.setScore(1.2f);
		
		boolean result = movieServiceImpl.addMovie(movies);
		
	}
	
	//@Test
	public void testGetMovies(){
		Page page = new Page();
		page.setStart(10L);
		page.setLength(10);
		
		List<Movies> movies = movieServiceImpl.getMovies(page,1);
		System.out.println(movies);
	}
	
	@Test
	public void testAddComment(){
		MovieComment mComment = new MovieComment();
		mComment.setMid(456L);
		mComment.setScore(5.6f);
		mComment.setUsername("cfw");
		mComment.setComment("lallademaxiya");
		
		boolean result = movieServiceImpl.addComment(mComment);
		
		System.out.println(result);
		
	}
}
