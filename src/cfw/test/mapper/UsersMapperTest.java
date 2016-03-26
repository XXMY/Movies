package cfw.test.mapper;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession; 
import org.apache.ibatis.session.SqlSessionFactory;  
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.matchers.JUnitMatchers.*;
import cfw.movies.mapper.UsersMapper;
import cfw.movies.model.Users;
import cfw.test.utils.MybatisUtil;
import cfw.test.utils.SpringUtils;


/**
 * @author Fangwei_Cai
 * @time since 2016年3月14日 下午2:32:13s
 */
public class UsersMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	
	
	@Before
	public void before(){
		//sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		
		sqlSessionFactory = (SqlSessionFactory) SpringUtils.getBean("sqlSessionFactory");
		
		sqlSession = sqlSessionFactory.openSession();
		
		
	}
	
	@After
	public void after(){
		sqlSession.close();
	}
	
	@Test
	public void testInsertOne() throws SQLException{
		
		UsersMapper userMapper = sqlSession.getMapper(UsersMapper.class);
		Users user = new Users();
		user.setUsername("CaiFagnwei44");
		user.setPassword("123");
		
		int result = userMapper.insertOne(user);
		assertThat(result, not(0));
		
	}
}
