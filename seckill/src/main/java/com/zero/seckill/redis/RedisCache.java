package com.zero.seckill.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @author Zero-me
 *
 */
public class RedisCache implements Cache {
	
	
	private Logger log = LoggerFactory.getLogger(RedisCache.class);
	
	
	//读写锁
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private String id;

    public RedisCache(final String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;

    }

    public String getId() {
        return this.id;
    }

    /**
     * @category 给缓存中放值
     */
    public void putObject(Object key, Object value) {
    	
    	this.log.info("============= Redis:<put> =============" );
        JedisUtil.getJedis().set(SerializeUtil.serialize(key.toString()),
                SerializeUtil.serialize(value));

    }

    
    /**
     * @category 从缓存中获取值
     */
    public Object getObject(Object key) {
    	this.log.info("============= Redis:<get> =============" );
        Object value = SerializeUtil.unserialize(JedisUtil.getJedis().get(
                SerializeUtil.serialize(key.toString())));
        return value;

    }

    public Object removeObject(Object key) {
        return JedisUtil.getJedis().expire(
                SerializeUtil.serialize(key.toString()), 0);

    }

    public void clear() {
        JedisUtil.getJedis().flushDB();
    }

    public int getSize() {
        return Integer.valueOf(JedisUtil.getJedis().dbSize().toString());
    }

    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

	
	
}
