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
import org.aspectj.lang.annotation.Pointcut;
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
	@Around(value = cache)
	public Object process(ProceedingJoinPoint pjp) throws Throwable{
		
		Method method = ((MethodSignature) pjp.getSignature()).getMethod();
		Object [] args = pjp.getArgs();
		
		Map<String,Object> map = this.getAnnotationProperties(method, args);
		
		
		Object value = null;
		value = this.myJedis.getRedisValue(method, map);
		
		if(value == null){
			value = pjp.proceed();
			if(value != null){
				this.myJedis.saveRedisValue(map,value);
			}
		}
		
		return value;
	}
	
	/**
	 * Get property map that annotated on method and parameters.
	 * @author Fangwei_Cai
	 * @time since 2016年6月26日 下午3:12:39
	 * @param method
	 * @param args
	 * @return Map<br>
	 *     Keys: key, keyType, field, start ,end
	 */
	private Map<String,Object> getAnnotationProperties(Method method,Object[] args){
		StringBuffer buffer = new StringBuffer();
		Map<String,Object> map = new HashMap<String,Object>();
		
		RedisCacheable redisCacheable = method.getAnnotation(RedisCacheable.class);
		// Method is annotated by RedisCacheable annotation.
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

	
}
