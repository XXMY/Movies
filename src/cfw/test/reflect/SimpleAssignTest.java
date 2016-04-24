package cfw.test.reflect;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cfw.common.reflect.SimpleAssign;
import cfw.movies.model.Movies;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月24日 下午4:23:03
 */
public class SimpleAssignTest {

	
	//@Test
	public void testAssignValue(){
		Movies oldM = new Movies();
		Movies newM = new Movies();
		
		newM.setName("lalla");
		newM.setType("1_2_3");
		
		SimpleAssign.assignValue(null,newM, oldM);
		
		System.out.println(oldM);
		
	}
	
	@Test
	public void testAssignVlaueTOMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		
		Movies movie = new Movies();
		movie.setName("lalaldeee");
		movie.setType("1_2_4");
		
		SimpleAssign.assignValueToMap(map, movie);
		
		System.out.println(map.toString());
	}
}
