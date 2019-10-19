package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dataobject.ScklDO;
import com.example.demo.error.BusinessException;
import com.example.demo.error.EmBusinessError;
import com.example.demo.service.ScklService;
import com.example.demo.utils.DateUtils;

import response.CommonReturnType;

/**
 * 
 * @author Zero-me
 *
 */

@RestController
@RequestMapping("/sckl")
public class ScklController extends BaseController{
	
	private static Logger logger = LoggerFactory.getLogger(ScklController.class);
	
	@Autowired
	private ScklService scklService;
	
	/**
	 * @category 获取秒杀列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getsckl",method= {RequestMethod.POST,RequestMethod.GET},consumes= {CONTENT_TYPE_FORMED})
	public CommonReturnType getScklList() {
		logger.info("==============ScklController <getsckl>===============");
		logger.info("<请求参数>---");
		List<ScklDO> list = scklService.list();
		return CommonReturnType.create(list);
	}
	
	/**
	 * 	@category 获取详情页面
	 * @param seckillId
	 * @return
	 * @throws BusinessException 
	 */
	@ResponseBody
	@RequestMapping(value="/{seckillId}/detail",method=RequestMethod.GET)
	public CommonReturnType detail(@PathVariable("seckillId")Long seckillId) throws BusinessException{
		logger.info("==============ScklController <detail>===============");
		logger.info("<请求参数>---" + "seckillId="+seckillId);
		/**/
		if(seckillId == null) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"参数不合法");
		}
		ScklDO seckill = scklService.getOne(seckillId);
		return CommonReturnType.create(seckill);
	}
	
	/**
	 * @category 新增秒杀商品
	 * @param seckillId
	 * @param name
	 * @param number
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes= {CONTENT_TYPE_FORMED})
	public CommonReturnType add(@RequestParam(name="seckillId")String seckillId,
			@RequestParam(name="name")String name,@RequestParam(name="number")Integer number,
			@RequestParam(name="startTime")String startTime,@RequestParam(name="endTime")String endTime
			) throws BusinessException {
		logger.info("==============ScklController <add>===============");
		logger.info("<请求参数>---" + "seckillId="+seckillId);
		if(StringUtils.isEmpty(String.valueOf(seckillId))) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"seckillId不能为空");
		}
		if(scklService.getOne(Long.valueOf(seckillId)) != null) {
			throw new BusinessException(EmBusinessError.SCKL_IS_REPEAT);
		}
		if(StringUtils.isEmpty(name)) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"name不能为空");
		}
		if(StringUtils.isEmpty(String.valueOf(number))) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"number不能为空");
		}
		if(StringUtils.isEmpty(startTime)) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"startTime不能为空");
		}
		if(StringUtils.isEmpty(endTime)) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"endTime不能为空");
		}
		
		ScklDO scklDO = new ScklDO();
		scklDO.setSeckillId(Long.parseLong(seckillId));
		scklDO.setName(name);
		scklDO.setNumber(number);
		scklDO.setStartTime(DateUtils.parseDate(startTime, null));
		scklDO.setEndTime(DateUtils.parseDate(endTime, null));
		scklDO.setCreateTime(new Date());
		scklService.addSckl(scklDO);
		return CommonReturnType.create(null);
	}
	
	/**
	 * @category 删除秒杀商品
	 * @param seckillId
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@RequestMapping(value="/del",method=RequestMethod.POST,consumes= {CONTENT_TYPE_FORMED})
	public CommonReturnType del(@RequestParam(name="seckillId")String seckillId
			) throws BusinessException {
		
		logger.info("==============ScklController <del>===============");
		logger.info("<请求参数>---" + "seckillId="+seckillId);
		if(StringUtils.isEmpty(String.valueOf(seckillId))) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"seckillId不能为空");
		}
		if(scklService.getOne(Long.valueOf(seckillId)) == null) {
			throw new BusinessException(EmBusinessError.SCKL_NOT_EXIST);
		}
		int res = scklService.delSckl(Long.valueOf(seckillId));
		if(res != 1) {
			throw new BusinessException(EmBusinessError.SCKL_REMOVE_ERROR);
		}
		return CommonReturnType.create(null);
	}
	/**
	 * @category 维护秒杀商品
	 * @param seckillId
	 * @param name
	 * @param number
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws BusinessException
	 */
	@ResponseBody
	@RequestMapping(value="/mod",method=RequestMethod.POST,consumes= {CONTENT_TYPE_FORMED})
	public CommonReturnType mod(@RequestParam(name="seckillId")String seckillId,
			@RequestParam(name="name")String name,@RequestParam(name="number")Integer number,
			@RequestParam(name="startTime")String startTime,@RequestParam(name="endTime")String endTime
			) throws BusinessException {
		logger.info("==============ScklController <mod>===============");
		logger.info("<请求参数>---" + "seckillId="+seckillId);
		if(StringUtils.isEmpty(String.valueOf(seckillId))) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"seckillId不能为空");
		}
		if(scklService.getOne(Long.valueOf(seckillId)) == null) {
			throw new BusinessException(EmBusinessError.SCKL_NOT_EXIST);
		}
		if(StringUtils.isEmpty(name)) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"秒杀商品名称不能为空");
		}
		if(StringUtils.isEmpty(String.valueOf(number))) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"库存不能为空");
		}
		if(StringUtils.isEmpty(startTime)) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"秒杀开始时间不能为空");
		}
		if(StringUtils.isEmpty(endTime)) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"秒杀结束时间不能为空");
		}
		
		ScklDO scklDO = new ScklDO();
		scklDO.setSeckillId(Long.parseLong(seckillId));
		scklDO.setName(name);
		scklDO.setNumber(number);
		scklDO.setStartTime(DateUtils.parseDate(startTime, null));
		scklDO.setEndTime(DateUtils.parseDate(endTime, null));
		scklDO.setCreateTime(scklService.getOne(Long.valueOf(seckillId)).getCreateTime());
		scklService.modSckl(scklDO);
		return CommonReturnType.create(null);
	}
	
	
	
}
