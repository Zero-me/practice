package com.zero.service;

import java.util.List;

import com.zero.model.Corporation;


/**
 * 
 * @author liuyingying
 *
 */
public interface ICorporationService {

	 /**
	   * 加载全部的corporation
   * @return
   */
  List<Corporation> loadCorporation();
  
  /**
   * 新增记录
   * @param corporation
   * @return
   */
  boolean insertCorporation(Object corporation);
  
  /**
   * 根据条件获取数据
   * @param corporation
   * @return
   */
  List<Corporation> queryByWhere(Object corporation);
  
  
  /**
   * 根据条件删除数据
   * @param corporation
   * @return
   */
  void deleteByWhere(Object corporation);
  
  /**
   * 分页查询
   * @param corporation
   * @param currPage
   * @param pageSize
   * @return
   */
	List<Corporation> queryByWherePage(Object corporation, int currPage, int pageSize);
	/**
	 * 总记录数
	 * @param corporation
	 * @return
	 */
	int queryCount(Object corporation);
	
}
