package com.example.demo.controller;


import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.controller.ViewObject.UserVO;
import com.example.demo.dataobject.UserDO;
import com.example.demo.error.BusinessException;
import com.example.demo.error.EmBusinessError;
import com.example.demo.mail.MailUtil;
import com.example.demo.service.UserService;
import com.example.demo.service.model.UserModel;

import response.CommonReturnType;

/**
 * 
 * @author liuyingying
 *
 */
@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController{
	
	
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	/**
	 * @category userSercvice
	 */
	@Autowired
	private UserService userSercvice;
	
	/**
	 * @category httpServletRequest
	 */
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	
	/**
	 * 	@category 用户登录
	 * @param phone
	 * @param pwd
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value="/login",method= {RequestMethod.POST},consumes= {CONTENT_TYPE_FORMED})
	@ResponseBody
	public CommonReturnType login(@RequestParam("phone")String phone,@RequestParam("pwd")String pwd) throws BusinessException {
		logger.info("==============UserController <login>===============");
		/* 入参校验*/
		if(StringUtils.isEmpty(phone) || StringUtils.isEmpty(pwd)) {
			throw  new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR);
		}
		
		/*用户登录服务，检验用户登录是否合法*/
		UserModel userModel = userSercvice.validateLogin(phone, pwd);
		//加入用户登录成功的session
		this.httpServletRequest.getSession().setAttribute("IS_LOGIN", true);
		this.httpServletRequest.getSession().setAttribute("LOGIN_USER", userModel);
		String type = userModel.getId()==1?"1":"2";
		return CommonReturnType.create(type);
	}
	
	
	
	/**
	 * 	@category 用户注册接口
	 * @param phone
	 * @param optCode
	 * @param name
	 * @param gender
	 * @param age
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value="/reg",method= {RequestMethod.POST},consumes= {CONTENT_TYPE_FORMED})
	@ResponseBody
	public CommonReturnType register(@RequestParam("phone")String phone,@RequestParam("optCode")String optCode,
																	@RequestParam("name")String name,@RequestParam("gender")Integer gender,
																	@RequestParam("age")Integer age,@RequestParam("pwd")String pwd) throws BusinessException {
		
		logger.info("==============UserController <reg>===============");

		/*验证手机号和对应的optCode相符合*/
		String oriOptCode = (String) this.httpServletRequest.getSession().getAttribute(phone);
		if(!StringUtils.equals(oriOptCode, optCode)) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR,"短信验证码不符合");
		}
		/*用户注册的流程*/
		UserModel  userModel = new UserModel();
		userModel.setTelephone(phone);
		userModel.setName(name);
		userModel.setAge(age);
		userModel.setGender(gender);
		userModel.setRegisterMode("1");
		userModel.setEncrptPwd(Base64Utils.encodeToString(pwd.getBytes()));
		userSercvice.register(userModel);
		
		
		return CommonReturnType.create(null);
	}
	
	/**
	 * 	@category 获取短信验证码
	 * @param phone
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value="/getopt",method= {RequestMethod.POST},consumes= {CONTENT_TYPE_FORMED})
	@ResponseBody
	public CommonReturnType getOpt(@RequestParam(name="phone")String phone) throws BusinessException {
		logger.info("==============UserController <getopt>===============");
		
		if(userSercvice.checkPhoneIsExist(phone)) {
			throw new BusinessException(EmBusinessError.USER_MAIL_EXIST);
		}
		
		/* 按照一定的规则生成OPT验证码*/
		Random random = new Random();
		int randomInt = random.nextInt(99999);
		randomInt += 10000;
		String optCode = String.valueOf(randomInt);
		
		/*将OPT验证码同 对应用户的手机号码相关联  使用HttpSession进行关联*/
		this.httpServletRequest.getSession().setAttribute(phone, optCode);
		/*将OPT验证码通过短信通道发送给用户，省略*/
		//TODO 使用邮箱验证
		logger.info("phone :" + phone + " & optCode:" + optCode);
		boolean res = MailUtil.sendMail(phone, "【SCKL】您的账号验证码为："+ optCode + " (请勿向任何人泄露)");
		if(res) {
			logger.info("验证码已发送至邮箱");
			return CommonReturnType.create(null);
		}else {
			throw new BusinessException(EmBusinessError.USER_MAIL_ERROR);
		}
		
	}
	
	
	
	/**
	 *	@category 获取指定ID的用户对象
	 * @param id
	 * @throws BusinessException 
	 */
	@RequestMapping("get")
	@ResponseBody
	public CommonReturnType getUser(@RequestParam(name="id")Integer id) throws BusinessException {
		logger.info("==============UserController <get>===============");

		UserModel userModel = userSercvice.getUserById(id);
		
		if(userModel == null) {
			 throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
		}
		return CommonReturnType.create(convertFromModel(userModel));	
	}
	
	/**
	 * @category model转VO
	 * @param userModel
	 * @return
	 */
	private UserVO convertFromModel(UserModel userModel ) {
		if(userModel == null) {
			return null;
		}
		UserVO userVO = new UserVO();
		BeanUtils.copyProperties(userModel, userVO);
		return userVO;
	}
	
	
	/**
	 *	@category 获取用户列表
	 * @throws BusinessException 
	 */
	@RequestMapping("getall")
	@ResponseBody
	public CommonReturnType getUserList() throws BusinessException {
		logger.info("==============UserController <get>===============");
		List<UserDO> list = userSercvice.getAll();
		logger.info(list.toString());
		return CommonReturnType.create(list);
	}
	
	
}
