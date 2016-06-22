package cfw.test.service;

import org.junit.BeforeClass;
import org.junit.Test;

import cfw.movies.service.MovieService;
import cfw.movies.service.RecommendService;
import cfw.test.AbstractTest;
import cfw.test.utils.SpringUtil;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月29日 下午6:37:59
 */
public class RecommendServiceTest extends AbstractTest{
	
	private static RecommendService recommendService;
	
	@BeforeClass
	public static void before(){
		recommendService = (RecommendService)SpringUtil.getBean("recommendService");
	}
	
	@Test
	public void testProcessRecommendData(){
		boolean result = recommendService.processRecommendData();
		
		System.out.println(result);
	}
}
