package com.zero.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.controller.PersonController;
import com.zero.dao.PersonMapper;
import com.zero.model.Person;
import com.zero.service.IPersonService;

/**
 * 
 * @author Zero-me
 *
 */
@Service("personService")
public class PersonServiceImpl implements IPersonService {
	private Logger log = Logger.getLogger(PersonServiceImpl.class);
    private PersonMapper personMapper;

    public PersonMapper getPersonMapper() {
        return personMapper;
    }
    
    @Autowired
    public void setPersonMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    public List<Person> loadPersons() {
        return personMapper.queryAll();
    }
    
	public boolean insertPerson(Object person) {
		try {
			personMapper.insert(person);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public List<Person> queryByWhere(Object person) {
		List<Person> res = null;
		try {
			res = personMapper.queryByWhere(person);
		} catch (Exception e) {
			this.log.error(e.getMessage());
		}
		return res;
	}
	
	public List<Person> queryByWherePage(Object person, int currPage, int pageSize) {
		List<Person> res = null;
		try {
			res = personMapper.queryByWherePage(person, currPage, pageSize);
		} catch (Exception e) {
			this.log.error(e.getMessage());
		}
		return res;

	}
	
	public int queryCount(Object person) {
		return personMapper.queryCount(person);
	}
	
	
	public void deleteByWhere(Object person) {
		personMapper.deleteByWhere(person);
	}


	public List<Person> getPersonDatail(Object person, int currPage, int pageSize) {
		
		return personMapper.getDatailPerson(person, currPage, pageSize);
	}
    
}