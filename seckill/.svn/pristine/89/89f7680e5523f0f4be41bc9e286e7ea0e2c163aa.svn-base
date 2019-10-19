package com.zero.seckill.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * 
 * redis 工具类
 * @author Zero-me
 *
 */
public class JedisUtil {
	private static String ADDR = "140.143.1.18";
    private static int PORT = 6379;
    private static String AUTH = "qq475811868";
    
    private static int MAX_ACTIVE = 1024;
    
    private static int MAX_IDLE = 200;
    
    private static int MAX_WAIT = 10000;
    
    private static int TIMEOUT = 1000;
    
    private static boolean TEST_ON_BORROW = true;
    
    private static JedisPool jedisPool = null;
    
    static {
        try{
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config,ADDR,PORT,TIMEOUT,AUTH);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     	* 获取jedis对象
     * @return
     */
    public synchronized static Jedis getJedis(){
    	Jedis jedis = null;
    	try{
            if(jedisPool != null){
                jedis = jedisPool.getResource();
                return jedis;
            }else{
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
            jedis.close();
            return null;
        }finally {
        	if(jedis != null ) {
       		 jedis.close();
       		 jedis = null;
       	 }
        }
    }
    
    /**
     * 回收jedis对象资源
     * @param jedis
     */
	public synchronized static void returnResource(final Jedis jedis){
        if(jedis != null){
        	jedis.close();;
        }
    }
    
    /**
	 * Jedis对象出异常的时候，回收Jedis对象资源
	 * 
	 * @param jedis
	 */
	public synchronized static void returnBrokenResource(Jedis jedis) {
		if (jedis != null) {
			jedis.close();;
		}
 
	}
    
    
    
    
    
    
    
    
}
