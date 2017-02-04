package cfw.test;

import cfw.test.utils.SpringUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * @author Fangwei_Cai
 * @time since 2016年4月8日 下午5:15:44
 */
public class AbstractTest {
	protected static SqlSessionFactory sqlSessionFactory;
	protected static SqlSession sqlSession;

	@BeforeClass
	public static void beforeClass(){
		
		sqlSessionFactory = (SqlSessionFactory) SpringUtil.getBean("sqlSessionFactory");
		
		sqlSession = sqlSessionFactory.openSession();
		
	}
	
	@AfterClass
	public static void afterClass(){
		sqlSession.close();
	}
}
