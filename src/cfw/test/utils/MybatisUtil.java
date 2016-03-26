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
			// 读取配置文件的信息
			reader = Resources.getResourceAsReader(resource);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		// 通过使用配置文件的信息构造一个sqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
	
}
