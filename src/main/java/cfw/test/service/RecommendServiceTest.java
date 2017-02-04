package cfw.test.service;

import cfw.movies.service.RecommendService;
import cfw.test.AbstractTest;
import cfw.test.utils.SpringUtil;
import org.junit.BeforeClass;
import org.junit.Test;

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
