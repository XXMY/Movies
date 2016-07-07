package cfw.test.redis;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cfw.redis.MyJedis;
import cfw.test.utils.SpringUtil;

/**
 * @author Fangwei_Cai
 * @time since 2016年6月23日 下午4:05:58
 */
public class RedisTest {

	private static MyJedis myJedis;
	
	@BeforeClass
	public static void beforeClass(){
		myJedis = (MyJedis)SpringUtil.getBean("myJedis");
	}
	
	@AfterClass
	public static void afterClass(){
		
	}
	
	@Test
	public void testRedisOperation(){
		System.out.println(myJedis.get("name"));
	}
}
