package com.zero.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.dao.CorporationMapper;
import com.zero.model.Corporation;
import com.zero.service.ICorporationService;

/**
 * 
 * @author liuyingying
 *
 */

@Service("corporationService")
public class ICorporationServiceImpl implements ICorporationService{
	private CorporationMapper corporationMapper;

    public CorporationMapper getCorporationMapper() {
        return corporationMapper;
    }
    
    @Autowired
    public void setCorporationMapper(CorporationMapper corporationMapper) {
        this.corporationMapper = corporationMapper;
    }

    public List<Corporation> loadCorporations() {
        return corporationMapper.queryAll();
    }
    
	public boolean insertCorporation(Object corporation) {
		try {
			corporationMapper.insert(corporation);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public List<Corporation> queryByWhere(Object corporation) {
		List<Corporation> res = null;
		try {
			res = corporationMapper.queryByWhere(corporation);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}
	
	public List<Corporation> queryByWherePage(Object corporation, int currPage, int pageSize) {
		List<Corporation> res = null;
		try {
			res = corporationMapper.queryByWherePage(corporation, currPage, pageSize);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;

	}
	
	public int queryCount(Object corporation) {
		return corporationMapper.queryCount(corporation);
	}
	
	
	public void deleteByWhere(Object corporation) {
		corporationMapper.deleteByWhere(corporation);
	}

	public List<Corporation> loadCorporation() {
		// TODO Auto-generated method stub
		return null;
	}
}
