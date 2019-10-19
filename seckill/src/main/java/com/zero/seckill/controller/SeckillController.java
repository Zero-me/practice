package com.zero.seckill.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.seckill.dto.Exposer;
import com.zero.seckill.dto.SeckillExecution;
import com.zero.seckill.dto.SeckillResult;
import com.zero.seckill.entity.Seckill;
import com.zero.seckill.exception.RepeatKillException;
import com.zero.seckill.exception.SeckillCloseException;
import com.zero.seckill.service.SeckillService;

/**
 * 
 * @author liuyingying
 *
 */
@Controller
@RequestMapping("")
public class SeckillController {

	
	private Logger log = LoggerFactory.getLogger(SeckillController.class);
	
	@Autowired
	private SeckillService seckillService;
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model) {
		/* 获取列表页 */
		
		List<Seckill> list = seckillService.getSeckillList();
		model.addAttribute("list",list);
		return "list";
	}
	
	
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
	public String detail(@PathVariable("seckillId")Long seckillId,Model model){
		log.info("Controller: <detail>");
		/**/
		if(seckillId == null) {
			return "redirect:/seckill/list";
		}
		Seckill seckill = seckillService.getById(seckillId);
		if(seckill == null) {
			return "forword:/seckill/list";
		}
		model.addAttribute("seckill",seckill);
		log.info("seckill:"+seckill);
		return "detial";
	}
	
	@RequestMapping(value="{seckillId}/exposer",method=RequestMethod.POST,produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<Exposer> exposer(@PathVariable("seckillId")Long seckillId) {
		
		SeckillResult<Exposer> result;
		try {
			Exposer exposer = seckillService.exportSeckillUrl(seckillId);
			
			result = new SeckillResult<Exposer>(true,exposer);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			result = new SeckillResult<Exposer>(false,e.getMessage());
		}
		return result;
	}
	
	@RequestMapping(value="/{seckillId}/{md5}/execute",method=RequestMethod.POST,produces= {"application/json;charset=UTF-8"})
	@ResponseBody
	public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId")Long seckillId,
												@PathVariable("md5")String md5,@CookieValue(value="killPhone",required=false ) Long phone){
		
		/* springmvc valid */
		if(phone == null) {
			return new SeckillResult<SeckillExecution>(false,"用户未登录");
		}
		try {
			 
//			SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, phone, md5);
			
			//使用存储过程来执行秒杀过程
			SeckillExecution seckillExecution = seckillService.executeSeckillProcedure(seckillId, phone, md5);
			return new SeckillResult<SeckillExecution>(true,seckillExecution);
		} catch (RepeatKillException e1) {
			SeckillExecution seckillExecution = new SeckillExecution(seckillId,1,"重复秒杀");
			return new SeckillResult<SeckillExecution>(true,seckillExecution );
		}
		catch (SeckillCloseException e2) { 
			SeckillExecution seckillExecution = new SeckillExecution(seckillId,2,"秒杀关闭");
			return new SeckillResult<SeckillExecution>(true,seckillExecution );
		}catch (Exception e) {
			SeckillExecution seckillExecution = new SeckillExecution(seckillId,3,"内部错误");
			return new SeckillResult<SeckillExecution>(true,seckillExecution );
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/time/now",method=RequestMethod.GET)
	@ResponseBody
	public SeckillResult<Long> time(){
		Date now = new Date();
		return new SeckillResult(true,now.getTime());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
