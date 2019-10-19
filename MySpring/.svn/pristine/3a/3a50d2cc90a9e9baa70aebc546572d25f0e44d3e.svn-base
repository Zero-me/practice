package com.zero.service.impl;

import java.util.List ;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Service ;
import com.zero.dao.UserOpertionMapper ;
import com.zero.entity.ResultBean ;
import com.zero.entity.UserOpertion ;
import com.zero.service.LogService ;

@Service
public class LogServiceImpl implements LogService{

	@Autowired
	private UserOpertionMapper userOpertionMapper;
	
	
	@Override
	public ResultBean add(UserOpertion userOpertion) {
		int res = userOpertionMapper.insert(userOpertion);
		return ResultBean.newSuccessResult(res);
	}

	@Override
	public ResultBean getAll() {
		List<UserOpertion> res =  userOpertionMapper.selectAll();
		return ResultBean.newSuccessResult(res) ;
	}

}
