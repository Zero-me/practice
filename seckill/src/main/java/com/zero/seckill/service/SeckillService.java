package com.zero.seckill.service;
/**
 * 	业务接口：站在 ‘使用者’ 的角度设计接口
 * 	方法定义粒度，参数（简练直接），返回类型（类型，异常）	
 * 
 * 
 * @author liuyingying
 *
 */

import java.util.List;

import com.zero.seckill.dto.Exposer;
import com.zero.seckill.dto.SeckillExecution;
import com.zero.seckill.entity.Seckill;
import com.zero.seckill.exception.RepeatKillException;
import com.zero.seckill.exception.SeckillCloseException;
import com.zero.seckill.exception.SeckillException;

public interface SeckillService {
	/**
	 * 查询所有秒杀记录
	 * @return
	 */
	List<Seckill> getSeckillList();
	
	
	/**
	 *	查询单个秒杀记录
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	
	/**
	 * 输出秒杀接口的地址（秒杀开启时，）
	 * 否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	
	/**
	 * 	
	 * @category 执行秒杀操作（使用spring声明式事务）
	 * 	
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckill(long seckillId,long userPhone,String md5)
		throws SeckillException,RepeatKillException,SeckillCloseException;
	
	
	
	/**
	 * 	
	 * @category 执行秒杀操作（使用mysql的存储过程控制事务）
	 * 	
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	SeckillExecution executeSeckillProcedure(long seckillId,long userPhone,String md5)
		throws SeckillException,RepeatKillException,SeckillCloseException;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
