package cfw.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import cfw.redis.MyJedis;
import cfw.redis.annotation.RedisID;
import cfw.redis.annotation.RedisStart;
import cfw.redis.annotation.RedisCacheable;
import cfw.redis.annotation.RedisCacheable.KeyType;
import cfw.redis.annotation.RedisEnd;
import cfw.redis.annotation.RedisField;

/**
 * @author Fangwei_Cai
 * @time since 2016年6月24日 上午11:32:39
 */
@Aspect
@Component
public class RedisCacheAspect {
	
	private final String cache = "@annotation(cfw.redis.annotation.RedisCacheable)";
	
	@Resource(name="myJedis")
	private MyJedis myJedis;

	public MyJedis getMyJedis() {
		return myJedis;
	}

	public void setMyJedis(MyJedis myJedis) {
		this.myJedis = myJedis;
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年6月26日 下午3:12:34
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around(cache)
	public Object process(ProceedingJoinPoint pjp) throws Throwable{
		
		Method method = ((MethodSignature) pjp.getSignature()).getMethod();
		Object [] args = pjp.getArgs();
		
		Map<String,Object> map = this.getAnnotationProperties(method, args);
		
		
		Object value = null;
		value = this.getRedisValue(method, map);
		
		if(value == null){
			value = pjp.proceed();
			if(value != null){
				this.myJedis.jedis.set((String)map.get("key"), value.toString());
			}
		}
		
		return value;
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年6月26日 下午3:12:39
	 * @param method
	 * @param args
	 * @return
	 */
	private Map<String,Object> getAnnotationProperties(Method method,Object[] args){
		StringBuffer buffer = new StringBuffer();
		Map<String,Object> map = new HashMap<String,Object>();
		
		RedisCacheable redisCacheable = method.getAnnotation(RedisCacheable.class);
		if(redisCacheable != null){
			buffer.append(redisCacheable.key());
			
			Annotation [][] annotation = method.getParameterAnnotations();
			for(int i=0;i<args.length;i++){
				for(Annotation an : annotation[i]){
					if(an instanceof RedisID){
						buffer.append(":");
						buffer.append(args[i]);
					}else if(an instanceof RedisField){
						map.put("field", args[i]);
					}else if(an instanceof RedisStart){
						map.put("start", args[i]);
					}else if(an instanceof RedisEnd){
						map.put("end", args[i]);
					}
					
				}
			}
			map.put("key", buffer.toString());
			map.put("keyType", redisCacheable.keyType());
		}
		
		return map;
	}
	
	/**
	 * @author Fangwei_Cai
	 * @time since 2016年6月26日 下午3:09:53
	 * @param method
	 * @param redisPropertyMap
	 * @return
	 */
	private Object getRedisValue(Method method,Map<String,Object> redisPropertyMap){
				
		String key = (String)redisPropertyMap.get("key");
		
		Object result = null;
		
		if(StringUtils.isNotEmpty(key)){
			KeyType keyType = (KeyType)redisPropertyMap.get("keyType");  
			switch(keyType){
			case STRING:
				result = this.myJedis.jedis.get(key);
				break;
			case LIST:
				long start = (long) redisPropertyMap.get("start");
				long end = (long) redisPropertyMap.get("end");
				result = this.myJedis.jedis.lrange(key, start, end);
				break;
			case SET:
				
				break;
			case HASH:
				String field = (String) redisPropertyMap.get("field");
				result = this.myJedis.jedis.hget(key, field);
				break;
			default:
				break;
			}
		}
		
		String typeName = method.getGenericReturnType().toString();
		Object value = this.convertToRealType(typeName, result);
		
		return value;
	}
	
	/**
	 * Convert result from redis into annotated method's return type.<br>
	 * There have many imperfections.
	 * @author Fangwei_Cai
	 * @time since 2016年6月26日 下午3:11:29
	 * @param typeName
	 * @param result
	 * @return
	 */
	private Object convertToRealType(String typeName,Object result){
		
		String resultTypeName = result.getClass().getName();
		if(typeName.equalsIgnoreCase(resultTypeName))
			return result;
		
		String parentTypeName = "";
		String sonTypeName = "";
		if(typeName.matches(".*<.*>")){
			parentTypeName = typeName.substring(0, typeName.indexOf("<"));
			sonTypeName = typeName.substring(typeName.indexOf("<")+1, typeName.indexOf(">"));
		}else{
			parentTypeName = typeName;
			sonTypeName = null;
		}
		
		return null;
	}
	
}
