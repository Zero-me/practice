package com.example.demo.service;

import java.util.List;

import com.example.demo.dataobject.UserDO;
import com.example.demo.error.BusinessException;
import com.example.demo.service.model.UserModel;

/**
 * 
 * @author liuyingying
 *	
 */


public interface UserService {
	
	
	/**
	 * 	@category 获取指定的用户对象
	 * @param id
	 */
	UserModel  getUserById(Integer id);

	
	/**
	 * 	@category 用户注册
	 * @param userModel
	 * @throws BusinessException 
	 */
	void register(UserModel userModel) throws BusinessException;	
	
	/**
	 * 	@category 校验用户
	 * @param phone
	 * @param pwd
	 * @throws BusinessException 
	 */
	UserModel validateLogin(String phone,String pwd) throws BusinessException;
	
	
	/**
	 * @category 验证手机号是否已经注册
	 * @param phone
	 * @return
	 */
	boolean checkPhoneIsExist(String phone);
	
	
	/**
	 * @category 获取用户列表
	 * @return
	 */
	List<UserDO> getAll();
}
