package cfw.test.utils.test;

import cfw.test.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月14日 下午2:45:47
 */
public class TestMybatisUtil {
	
	@Test
	public void testGetSqlSessionFactory(){
		SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
		
		//assertNotEquals(null, sqlSessionFactory);
		
		sqlSessionFactory.openSession();
		
		//assertNotEquals(null,sqlSession);
	}
}
