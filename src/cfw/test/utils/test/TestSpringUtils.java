package cfw.test.utils.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;
import cfw.movies.mapper.UsersMapper;
import cfw.movies.model.Users;
import cfw.test.utils.SpringUtils;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月26日 下午12:05:17
 */
public class TestSpringUtils {
	
	@Test
	public void getBeanTest(){
		
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory)SpringUtils.getBean("sqlSessionFactory");
		
		//assertThat(sqlSessionFactory, not(null));
		System.out.println(sqlSessionFactory);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UsersMapper userMapper = sqlSession.getMapper(UsersMapper.class);
		
		Users user = new Users();
		user.setUsername("cfwasdfdsa");
		user.setPassword("123");
		
		int result = userMapper.insertOne(user);
		assertThat(result, not(0));
		sqlSession.commit();
		
	}
}
