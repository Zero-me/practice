package com.zero.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;


/**
 * 
 * @author Zero-me
 *
 */
public class RedisCache implements Cache {
	
	
	private Logger log = Logger.getLogger(RedisCache.class);
	
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

    public void putObject(Object key, Object value) {
    	
    	this.log.info("============= Redis:<put> =============" );
        JedisUtil.getJedis().set(SerializeUtil.serialize(key.toString()),
                SerializeUtil.serialize(value));

    }

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
