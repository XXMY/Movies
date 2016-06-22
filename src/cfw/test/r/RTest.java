package cfw.test.r;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cfw.movies.r.R;

/**
 * @author Fangwei_Cai
 * @time since 2016年5月15日 上午10:15:14
 */
public class RTest {
	
	private R r;
	
	@Before
	public void before(){
		this.r = new R();
	}

	@After
	public void after(){
		if(this.r != null){
			this.r.destroy();
		}
		System.out.println(this.r);
	}
	
	//@Test
	public void testInit(){
		R r = new R();
		if(r != null){
			r.destroy();
		}
	}
	
	//@Test
	public void testMysqlConnection(){
		boolean result = this.r.connectToMysql();
		if(result){
			System.out.println("Connect to mysql succeed.");
		}
	}
	
	@Test
	public void testR(){
		this.r.connectToMysql();
		boolean result = this.r.executeRecommendMR();
		if(result){
			System.out.println("******** Map-Reduce Succeed! *********");
			result =this.r.putRecommendDataToMysql();
		}
		
		if(result){
			System.out.println("******** Save Recommends to MySQL Succeed! ********");
		}
	}
}
