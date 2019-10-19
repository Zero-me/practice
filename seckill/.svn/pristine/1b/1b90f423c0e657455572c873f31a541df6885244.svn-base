package com.zero.seckill.dao;

import org.apache.ibatis.annotations.Param;

import com.zero.seckill.entity.SuccessKilled;

/**
 * 
 * @author Zero-me
 *
 */
public interface SuccessKilledDao {
	
	/**
	 * 	插入购买明细，可过滤重复
	 * @param seckillId
	 * @param userPhone
	 * @return
	 * 	插入的数据行数 0代表失败
	 */
	int insertSuccessKilled(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	/**
	 *	根据ID查询并携带秒杀商品对象实体
	 * @param seckilled
	 * @return
	 */
	SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId,@Param("userPhone")long userPhone);
	
	
	
	
}
