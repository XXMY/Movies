package cfw.test.mapper;

import java.sql.SQLException; 
import java.util.List;

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
import cfw.movies.mapper.TypesMapper;
import cfw.movies.mapper.UsersMapper;
import cfw.movies.model.Types;
import cfw.movies.model.Users;
import cfw.test.utils.MybatisUtil;
import cfw.test.utils.SpringUtil;


/**
 * @author Fangwei_Cai
 * @time since 2016年3月14日 下午2:32:13s
 */
public class TypesMapperTest {
	protected SqlSessionFactory sqlSessionFactory;
	protected SqlSession sqlSession;
	private TypesMapper typesMapper;
	
	@Before
	public void before(){
		//sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		
		sqlSessionFactory = (SqlSessionFactory) SpringUtil.getBean("sqlSessionFactory");
		
		sqlSession = sqlSessionFactory.openSession();
		
		typesMapper =  sqlSession.getMapper(TypesMapper.class);
		
	}
	
	@After
	public void after(){
		sqlSession.close();
	}
	
	
	@Test
	public void testSelectAll() throws SQLException{
		List<Types> result = typesMapper.selectAll();
		System.out.println(result);
		//assertThat(result, not(null));
		
	}
	
}
