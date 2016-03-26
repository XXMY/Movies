package cfw.test.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author Fangwei_Cai
 * @time since 2016年3月14日 下午2:39:28
 */
public class MybatisUtil {
	private final static SqlSessionFactory sqlSessionFactory;
	private final static String resource = "mybatis/Mybatis-config.xml";
	
	static {
		Reader reader = null;
		
		try{
			reader = Resources.getResourceAsReader(resource);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
	
}
