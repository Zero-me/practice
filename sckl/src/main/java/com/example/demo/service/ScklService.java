package com.example.demo.service;
/**
 * 
 * @author Zero-me
 *
 */

import java.util.List;

import com.example.demo.dataobject.ScklDO;

public interface ScklService {
	
	/**
	 * @category 获取秒杀列表
	 * @return
	 */
	List<ScklDO> list();
	
	/**
	 * 
	 * @category 获取详情页
	 * @param seckillId
	 * @return
	 */
	ScklDO getOne(Long seckillId);
	
	/**
	 * @category 新增秒杀商品
	 * @param scklDO
	 */
	void addSckl(ScklDO scklDO);
	
	/**
	 * @category 删除秒杀商品
	 * @param seckillId
	 * @return
	 */
	int delSckl(Long seckillId);
	
	
	/**
	 * @category 维护秒杀页面
	 * @param scklDO
	 */
	void modSckl(ScklDO scklDO);
	
}
