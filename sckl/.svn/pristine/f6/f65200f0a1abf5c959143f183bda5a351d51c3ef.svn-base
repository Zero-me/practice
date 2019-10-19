package com.example.demo.servie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ScklDOMapper;
import com.example.demo.dataobject.ScklDO;
import com.example.demo.service.ScklService;

/**
 * 
 * @author Zero-me
 *
 */

@Service
public class ScklServiceImpl implements ScklService{

	@Autowired
	private ScklDOMapper scklDOMapper;
	
	@Override
	public List<ScklDO> list() {
		return scklDOMapper.selectAll();
	}

	@Override
	public ScklDO getOne(Long seckillId) {
		
		return scklDOMapper.selectByPrimaryKey(seckillId);
	}

	@Override
	public void addSckl(ScklDO scklDO) {
		scklDOMapper.insert(scklDO);
	}

	@Override
	public int delSckl(Long seckillId) {
		return scklDOMapper.deleteByPrimaryKey(seckillId);
	}

	@Override
	public void modSckl(ScklDO scklDO) {
		scklDOMapper.updateByPrimaryKey(scklDO);
	}

}
