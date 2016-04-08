package cfw.test.service;

import org.junit.Before;
import org.junit.Test;

import cfw.movies.service.MovieService;
import cfw.test.utils.SpringUtils;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月2日 下午9:07:33
 */
public class MovieServiceImplTest {
	
	@Before
	public void before(){
		
	}
	
	@Test
	public void testConsturct(){
		MovieService movieServiceImpl = (MovieService)SpringUtils.getBean("movieServiceImpl");
		
		assertThat(movieServiceImpl, notNullValue());
	}

}
