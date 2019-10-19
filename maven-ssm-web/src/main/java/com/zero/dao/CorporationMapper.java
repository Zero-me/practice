package com.zero.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zero.model.Corporation;

/**
 * 
 * @author liuyingying
 *
 */
public interface CorporationMapper {

	/**
     * 插入一条记录
     * @param corporation
     */
    void insert(Object corporation);
    
    /**
     * 查询总记录数
     * @param corporation
     * @return
     */
    int queryCount(@Param("contentSize")Object corporation);
    
    /**
     * 查询所有
     * @return
     */
    List<Corporation> queryAll();
    
    /**
     * 按条件查询
     * @param corporation
     * @return
     */
    List<Corporation> queryByWhere(@Param("contentSize")Object corporation);
    
    
    /**
     * 按条件删除
     * @param corporation
     * @return
     */
    void deleteByWhere(@Param("contentSize")Object corporation);
    
    /**
     * 按条件分页查询
     * @param corporation
     * @param currPage
     * @param pageSize
     * @return
     */
	List<Corporation> queryByWherePage(@Param("contentSize")Object corporation, @Param("currPage")int currPage, @Param("pageSize")int pageSize);
	
}
