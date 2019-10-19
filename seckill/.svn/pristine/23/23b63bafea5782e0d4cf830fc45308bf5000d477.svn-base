package com.zero.seckill.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zero.seckill.dto.Exposer;
import com.zero.seckill.dto.SeckillExecution;
import com.zero.seckill.entity.Seckill;
import com.zero.seckill.exception.RepeatKillException;
import com.zero.seckill.exception.SeckillCloseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-dao.xml","classpath:spring-service.xml"})
public class SeckillServiceTest {

	private Logger log = LoggerFactory.getLogger(SeckillServiceTest.class);
	
	
	
	@Autowired
	private SeckillService seckillService;
	
	
	@Test
	public void testGetSeckillList() {
		List<Seckill> list = seckillService.getSeckillList();
//		log.info("list="+list);
		System.out.println("list="+list);
	}

	@Test
	public void testGetById() {
		long id = 1000;
		Seckill seckill = seckillService.getById(id);
		
		log.info("seckill="+seckill);
	}

	@Test
	public void testESeckillLogic() {
		long id = 1002;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		if(exposer.isExposerd()) {
			log.info("exposer={}",exposer);
			long phone = 18829290521L;
			String md5 = exposer.getMd5();
			SeckillExecution execution;
			try {
				execution= seckillService.executeSeckill(id, phone, md5);
				log.info("execution={}",execution);
			} catch (RepeatKillException e1) {
				log.error(e1.getMessage());
			}catch (SeckillCloseException e2) {
				log.error(e2.getMessage());
			}
		}else {
			/*  秒杀未开启 */
			log.warn("exposer={}",exposer);
		}
	}


}
