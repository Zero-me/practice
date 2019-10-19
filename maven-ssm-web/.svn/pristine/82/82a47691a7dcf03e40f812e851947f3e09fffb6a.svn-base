package com.zero.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zero.model.Person;
/**
 * 
 * @author Zero-me
 *
 */
public interface PersonMapper {
    /**
     * 插入一条记录
     * @param person
     */
    void insert(Object person);
    
    /**
     * 查询总记录数
     * @param person
     * @return
     */
    int queryCount(@Param("contentSize")Object person);
    
    /**
     * 查询所有
     * @return
     */
    List<Person> queryAll();
    
    /**
     * 按条件查询
     * @param person
     * @return
     */
    List<Person> queryByWhere(@Param("contentSize")Object person);
    
    
    /**
     * 按条件删除
     * @param person
     * @return
     */
    void deleteByWhere(@Param("contentSize")Object person);
    
    /**
     * 获取用户详情
     * @param person
     * @param currPage
     * @param pageSize
     * @return
     */
    List<Person> getDatailPerson(@Param("contentSize")Object person, @Param("currPage")int currPage, @Param("pageSize")int pageSize);
    
    /**
     * 按条件分页查询
     * @param person
     * @param currPage
     * @param pageSize
     * @return
     */
	List<Person> queryByWherePage(@Param("contentSize")Object person, @Param("currPage")int currPage, @Param("pageSize")int pageSize);
}