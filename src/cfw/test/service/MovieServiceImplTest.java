package cfw.test.service;

import org.junit.BeforeClass;
import org.junit.Test;

import cfw.movies.model.Descriptions;
import cfw.movies.model.Movies;
import cfw.movies.model.Types;
import cfw.movies.service.MovieService;
import cfw.test.AbstractTest;
import cfw.test.utils.SpringUtils;
import static org.junit.Assert.*;
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

	@Test
	public void testAddMovie(){
		Descriptions abstracts = new Descriptions();
		abstracts.setDescription("<p>123</p>");
		
		Movies movies = new Movies();
		movies.setDescription(abstracts);
		movies.setName("叶问2");
		movies.setPic("http://www.baidu.com");
		
		boolean result = movieServiceImpl.addMovie(movies);
		
	}
}
