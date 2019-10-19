package com.zero.service;

import java.util.List;

import com.zero.model.Person;
/**
 * 
 * @author Zero-me
 *
 */
public interface IPersonService {

    /**
 	   * 加载全部的person
     * @return
     */
    List<Person> loadPersons();
    
    /**
     * 新增记录
     * @param person
     * @return
     */
    boolean insertPerson(Object person);
    
    /**
     * 根据条件获取数据
     * @param person
     * @return
     */
    List<Person> queryByWhere(Object person);
    
    
    /**
     * 根据条件删除数据
     * @param person
     * @return
     */
    void deleteByWhere(Object person);
    
    /**
     * 分页查询
     * @param person
     * @param currPage
     * @param pageSize
     * @return
     */
	List<Person> queryByWherePage(Object person, int currPage, int pageSize);
	/**
	 * 总记录数
	 * @param person
	 * @return
	 */
	int queryCount(Object person);
	
	
	List<Person> getPersonDatail(Object person, int currPage, int pageSize);
}