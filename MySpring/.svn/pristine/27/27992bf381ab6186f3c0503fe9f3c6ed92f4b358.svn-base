package com.zero.redis;

import javax.annotation.PostConstruct ;
import org.springframework.beans.factory.annotation.Value ;
import org.springframework.context.annotation.Bean ;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration ;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration ;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPoolConfig ;
 
@Component
public class RedisCacheTransfer {
	
	@Value("${spring.redis.host}")
	private String host;
	
	@Value("${spring.redis.port}")
	private int port;
	
	@Value("${spring.redis.password}")
	private String  password;
	
	@Value("${spring.redis.jedis.pool.maxIdle}")
	private int maxIdle;
	
	@Value("${spring.redis.jedis.pool.minIdle}")
	private int minIdle;
	
	private JedisPoolConfig getJedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMinIdle(minIdle);
		return jedisPoolConfig;
	}
	
	private JedisConnectionFactory getJedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		//设置redis服务器的host或者ip地址
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setPassword(password);
      //获得默认的连接池构造
        //这里需要注意的是，edisConnectionFactoryJ对于Standalone模式的没有（RedisStandaloneConfiguration，JedisPoolConfig）的构造函数，对此
        //我们用JedisClientConfiguration接口的builder方法实例化一个构造器，还得类型转换
        JedisClientConfiguration.JedisPoolingClientConfigurationBuilder jpcf =
        		(JedisClientConfiguration.JedisPoolingClientConfigurationBuilder) JedisClientConfiguration.builder();
        //修改我们的连接池配置
        
        jpcf.poolConfig(jedisPoolConfig);
        //通过构造器来构造jedis客户端配置
        JedisClientConfiguration jedisClientConfiguration = jpcf.build();
		return new JedisConnectionFactory(redisStandaloneConfiguration, jedisClientConfiguration);
	}
	
	@PostConstruct
	public void initJedisConnectionFactory() {
		JedisPoolConfig jedisPoolConfig = getJedisPoolConfig();
		JedisConnectionFactory jedisConnectionFactory = getJedisConnectionFactory(jedisPoolConfig);
		RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
	}
}