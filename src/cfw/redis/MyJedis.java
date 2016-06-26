package cfw.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Customize jedis bean, encapsulate methods to simplify redis operation.<br>
 * This bean can be injected into another bean as property.
 * @author Fangwei_Cai
 * @time since 2016年6月23日 下午6:15:39
 */
public class MyJedis {
	
	public Jedis jedis;
	
	public MyJedis(JedisPool jedisPool){
		super();
		if(jedisPool != null){
			this.jedis = jedisPool.getResource();
		}
	}
	

	public String get(String key){
		String value = this.jedis.get(key);
		
		return value;
	}
	
}
