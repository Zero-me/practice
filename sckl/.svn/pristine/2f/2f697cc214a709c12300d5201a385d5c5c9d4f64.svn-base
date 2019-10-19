package com.example.demo.servie.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import com.example.demo.dao.UserDOMapper;
import com.example.demo.dao.UserPwdDOMapper;
import com.example.demo.dataobject.UserDO;
import com.example.demo.dataobject.UserPwdDO;
import com.example.demo.error.BusinessException;
import com.example.demo.error.EmBusinessError;
import com.example.demo.service.UserService;
import com.example.demo.service.model.UserModel;

/**
 * 
 * 
 * @author liuyingying
 *
 */
@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserDOMapper userDOMapper;
	
	@Autowired
	private UserPwdDOMapper  userPwdDOMapper;
	
	/**
	 * @category 根据用户ID查询记录
	 */
	@Override
	public UserModel getUserById(Integer id) {
		UserDO userDO = userDOMapper.selectByPrimaryKey(id);
		if(userDO == null) {
			return null;
		}
		UserPwdDO userPwdDO = userPwdDOMapper.selectByUserId(id);
		return convertFromDataObajct(userDO, userPwdDO);
	}

	
	/**
	 * @category DO转model
	 * @param userDO
	 * @param userPwdDO
	 * @return
	 */
	private UserModel convertFromDataObajct(UserDO userDO,UserPwdDO userPwdDO) {
		if(userDO == null) {
			return null;
		}
		UserModel userModel = new UserModel();
		BeanUtils.copyProperties(userDO, userModel);
		if(userPwdDO != null) {
			userModel.setEncrptPwd(userPwdDO.getEncrptPwd());
		}
		return userModel;
	}


	/**
	 * @category 用户注册
	 */
	@Override
	@Transactional
	public void register(UserModel userModel) throws BusinessException {
		if(userModel == null) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR);
		}
		if(StringUtils.isEmpty(userModel.getName()) || StringUtils.isEmpty(userModel.getTelephone()) ||
				StringUtils.isEmpty(String.valueOf(userModel.getAge())) || StringUtils.isEmpty(String.valueOf(userModel.getGender())) ||
				StringUtils.isEmpty(userModel.getRegisterMode()) ) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDTION_ERROR);
		}
		/*实现model-DO的方法*/
		UserDO userDO = convertFromModel(userModel);
		userDOMapper.insert(userDO);
		Integer userid = userDOMapper.selectByPhone(userDO.getTelephone()).getId();
		userModel.setId(userid);
		UserPwdDO userPwdDO = convertPwdFromModel(userModel);
		userPwdDOMapper.insert(userPwdDO);
		
	}
	
	/**
	 * @category model转DO
	 * @param userModel
	 * @return
	 */
	private UserDO convertFromModel(UserModel userModel) {
		if(userModel == null) {
			return null;
		}
		UserDO userDO = new UserDO();
		BeanUtils.copyProperties(userModel, userDO);
		return userDO;
	}
	
	/**
	 * @category model转PwdDO
	 * @param userModel
	 * @return
	 */
	private UserPwdDO convertPwdFromModel(UserModel userModel) {
		if(userModel == null) {
			return null;
		}
		UserPwdDO userPwdDO = new UserPwdDO();
		userPwdDO.setEncrptPwd(userModel.getEncrptPwd());
		userPwdDO.setUserId(userModel.getId());
		return userPwdDO;
	}


	/**
	 * @category 验证用户登录
	 */
	@Override
	public UserModel validateLogin(String phone, String encrptPwd) throws BusinessException {
		
		
		UserDO userDO = userDOMapper.selectByPhone(phone);
		if(userDO == null) {
			throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
		}
		UserPwdDO userPwdDO = userPwdDOMapper.selectByUserId(userDO.getId());
		UserModel userModel = convertFromDataObajct(userDO,userPwdDO);
		//通过用户信息内加密的密码是否和传输进来的密码作对比
		encrptPwd = Base64Utils.encodeToString(encrptPwd.getBytes());
		if(!StringUtils.equals(encrptPwd, userModel.getEncrptPwd())) {
			 throw new BusinessException(EmBusinessError.USER_LOGIN_FAIL);
		}
		return userModel;
		
	}


	@Override
	public boolean checkPhoneIsExist(String phone) {
		if(userDOMapper.selectByPhone(phone) == null) {
			return false;
		}else {
			return true;
		}
	}


	@Override
	public List<UserDO> getAll() {
		return userDOMapper.selectAll();
	}
	
	
	
}
