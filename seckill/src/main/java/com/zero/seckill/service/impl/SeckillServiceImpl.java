package com.zero.seckill.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import com.zero.seckill.dao.SeckillDao;
import com.zero.seckill.dao.SuccessKilledDao;
import com.zero.seckill.dto.Exposer;
import com.zero.seckill.dto.SeckillExecution;
import com.zero.seckill.entity.Seckill;
import com.zero.seckill.entity.SuccessKilled;
import com.zero.seckill.exception.RepeatKillException;
import com.zero.seckill.exception.SeckillCloseException;
import com.zero.seckill.exception.SeckillException;
import com.zero.seckill.service.SeckillService;


@Service
public class SeckillServiceImpl implements SeckillService{
	
	private Logger log = LoggerFactory.getLogger(SeckillServiceImpl.class);
	
	
	@Autowired
	private SuccessKilledDao successKilledDao;
	
	@Autowired
	private SeckillDao seckillDao;
	
	private static String slat = "dskndlsdoaeqfkw[qwkdm;a3e9ipUbku7y7tc√∆∫˙∫∆∫˚∫√∆∆ƒ˙†¥";
	
	
	public List<Seckill> getSeckillList() {
		return seckillDao.queryAll(0, 4);
	}

	public Seckill getById(long seckillId) {
		return seckillDao.queryById(seckillId);
	}

	public Exposer exportSeckillUrl(long seckillId) {
		
		//缓存优化
		
		Seckill seckill = seckillDao.queryById(seckillId);
		if(seckill == null) {
			return new Exposer(false, seckillId);
		}
		Date startTime = seckill.getStartTime();
		Date endTime  = seckill.getEndTime();
		Date nowTime = new Date();
		if(nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
			return new Exposer(false, seckillId,nowTime.getTime(),startTime.getTime(),endTime.getTime());
		}
		/*  转发特定字符串的过程，不可拟*/
		String md5 = getMd5(seckillId);	
		return new Exposer(true, md5,seckillId);
	}

	/**
	 * @category 使用注解控制事务方法的优点
	 * 		1》 开发团队达成一致约定，明确标注事务方法的编程风格
	 * 		2》 保证事务方法的执行时间尽可能短，尽量不要穿插其他的网络操作，例如RPC／HTTP／ ，或者剥离到事务方法的外部
	 * 		3》 不是所有的方法都需要事务，如 只有一条修改操作或者是读操作 不需要进行事务控制
	 * 
	 */
	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillException, RepeatKillException, SeckillCloseException {
		log.info("md5={}",md5);
		
		if(md5 == null || !md5.equals(getMd5(seckillId))) {
			log.info("md5={}",md5);
			throw  new SeckillException("seckill data rewrite");
		}
		Date nowTime = new Date();
		try {
			/* 记录购买行为 */
			int insertCount = successKilledDao.insertSuccessKilled(seckillId, userPhone);
			log.info("insertCount:",insertCount+"");
			if(insertCount <= 0) {
				/* 重复秒杀*/
				throw new RepeatKillException("seckill is repeated");
			}else {
				/* 执行减库存 */
				//热点商品的竞争在减库存，不是在生成订单
				int updateCount = seckillDao.reduceNumber(seckillId, nowTime);
				if(updateCount <= 0) {
					/*无更新记录*/
					//rollback
					throw new SeckillCloseException("seckill is closed");
				}else{
					//commit
					/*秒杀成功*/
					SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(seckillId,userPhone);
					return new SeckillExecution(seckillId, 1, "秒杀成功",successKilled);
				}
			}
		}catch(SeckillCloseException e1) {
			throw e1;
		}catch(RepeatKillException e2) {
			throw e2;
		}catch (Exception e) {
			/* 将所有编译期间的异常 转化为运行期异常∂ß */
//			log.error(e.getMessage(),e);
			throw new SeckillException("seckill inner error :"+ e.getMessage());
		}
	}
	
	/**
	 * @category 获取MD5编码
	 * @param seckillId
	 * @return
	 */
	private static String getMd5(long seckillId) {
		String base = seckillId + "/" + slat;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
	
	

	
	/**
	 * @category 使用存储过程完成秒杀
	 */
	public SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5) {
		if(md5 == null || !md5.equals(getMd5(seckillId))) {
			return  new SeckillExecution(seckillId,1,"重复秒杀");
		}
		Date killTime = new Date();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("seckillId", seckillId);
		paramMap.put("phone", userPhone);
		paramMap.put("killTime", killTime);
		paramMap.put("result", null);
		
		try {
			/* 存储过程执行完之后，result会被赋值 */
			seckillDao.killByProcedure(paramMap);
			
			int result = MapUtils.getInteger(paramMap, "result",-2);
			if(result == 1) {
				SuccessKilled sk = successKilledDao.queryByIdWithSeckill(seckillId, userPhone);
				return new SeckillExecution(seckillId,1,"秒杀成功");
			}else if(result == -1) {
				return new SeckillExecution(seckillId,2,"重复秒杀");
			}else if(result == 0) {
				return new SeckillExecution(seckillId,2,"秒杀结束");
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			return new SeckillExecution(seckillId,3,"内部错误");
		}
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
