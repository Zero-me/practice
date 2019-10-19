package com.zero.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.common.MethodResult;
import com.zero.common.TCResult;
import com.zero.common.util.ParamCheck;
import com.zero.model.Person;
import com.zero.service.IPersonService;
/**
 * 
 * @author Zero-me
 *
 */
@Controller
@RequestMapping("/person")
public class PersonController {
	
	private Logger log = Logger.getLogger(PersonController.class);
	
    private IPersonService personService;
    
    public IPersonService getPersonService() {
        return personService;
    }

    @Autowired
    public void setPersonService(IPersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/showPerson")
    public String showPersons(Model model){
    	this.log.info("========= PersonController [showPerson] =========");
        List<Person> persons = personService.loadPersons();
        model.addAttribute("persons", persons);
        return "showperson";
    }
    
    @RequestMapping(value="/showPersons")
    public @ResponseBody TCResult showPersonss(){
    	this.log.info("========= PersonController [showPersons] =========");
    	TCResult tcresult = new TCResult();
    	try {
    		List<Person> persons = personService.loadPersons();
    		tcresult.setDealcode("0000");
    		tcresult.setDealmsg("处理成功");
    		tcresult.setDealcount(persons.size()+"");
    		tcresult.setResult(persons);
		} catch (Exception e) {
			tcresult.setDealcode("CRL_EXC_01:"+e.getMessage());
    		tcresult.setDealmsg("处理失败");
    		tcresult.setDealcount(0+"");
		}
        return tcresult;
    }
    
    
    
    
    @RequestMapping(value="/addperson",method = RequestMethod.POST,produces = "text/json")
    public @ResponseBody TCResult insertPersons(@RequestBody Object obj
    			){
    	@SuppressWarnings("unchecked")
    	Map<String, Object> req = (Map<String, Object>)obj;
    	this.log.info("========== PersonController [addperson] ==========");
    	this.log.info("请求参数："+req);

    	TCResult tcresult = new TCResult();
    	try {
    		
//    		请求参数预处理：自动封装为Javabean
    		MethodResult result = ParamCheck.getAutoBean("Person", req, null);
    		if(result.getRetcode().equals("SUCCESS")) {
    			boolean res= personService.insertPerson(result.getResult());
    			
    			if(res) {
        			tcresult.setDealcode("000");
            		tcresult.setDealmsg("处理成功");
            		tcresult.setDealcount(1+"");
        		}else {
        			tcresult.setDealcode("DB_EXC_01");
            		tcresult.setDealmsg("数据库插入异常");
            		tcresult.setDealcount(0+"");
        		}
    		}else {
    			tcresult.setDealcode(result.getRetcode());
    			tcresult.setDealmsg(result.getRetmsg());
    			return tcresult;
    		}
    		
		} catch (Exception e) {
			tcresult.setDealcode("210");
	    		tcresult.setDealmsg("处理失败："+e.getMessage());
	    		tcresult.setDealcount(0+"");
		}
        return tcresult;
    }
    
    
    @RequestMapping(value="/deletePersonByWhere",method = RequestMethod.POST,produces = "text/json")
    public @ResponseBody TCResult deletePerson(@RequestBody Object obj
    			){
    	@SuppressWarnings("unchecked")
		Map<String, Object> req = (Map<String, Object>)obj;
    	this.log.info("========= PersonController [deletePersonByWhere] =========");
    	this.log.info("请求参数："+ req);
    		TCResult tcresult = new TCResult();
    		try {
	    		MethodResult result = ParamCheck.getAutoBean("Person", req, null);
	    		if(result.getRetcode().equals("SUCCESS")) {
	    			int count = personService.queryCount(result.getResult());
		    		if(count > 0) {
		    			personService.deleteByWhere(result.getResult());
		    			tcresult.setDealcode("0000");
		        		tcresult.setDealmsg("处理成功");
		        		tcresult.setDealcount(count+"");
		        		tcresult.setResult(result.getResult());
		    		}else {
		    			tcresult.setDealcode("0001");
		        		tcresult.setDealmsg("需要删除的数据不存在");
		        		tcresult.setDealcount(0+"");
		    		}
	    		}
	    		
		} catch (Exception e) {
		tcresult.setDealcode("DB_EXC_03");
    		tcresult.setDealmsg("处理失败："+e.getMessage());
    		tcresult.setDealcount(0+"");
		}
        return tcresult;
    }
    
    @RequestMapping(value="/queryPersonByWhere",method = RequestMethod.POST,produces = "text/json")
    public @ResponseBody TCResult queryPersonByWhere(@RequestBody Object obj
    			){
    	@SuppressWarnings("unchecked")
		Map<String, Object> req = (Map<String, Object>)obj;
    	this.log.info("========== PersonController [queryPersonByWhere] ========");
    	this.log.info("请求参数："+ req);
    	TCResult tcresult = new TCResult();
    		try {
    			
    			int currPage = req.get("currpage")==null?0:Integer.parseInt(req.get("currpage").toString());
    			int pageSize = req.get("pagesize")==null?10:Integer.parseInt(req.get("pagesize").toString());
    			
    			MethodResult result = ParamCheck.getAutoBean("Person", req, null);
    			if(result.getRetcode().equals("SUCCESS")) {
    				
    				Object person = result.getResult();
    				String totalcount = ""+personService.queryCount(person);
    	    		List<Person> persons = personService.queryByWherePage(person,currPage,pageSize);
    	    		tcresult.setDealcode("0000");
    	    		tcresult.setDealmsg("处理成功");
    	    		tcresult.setDealcount(persons.size()+"");
    	    		tcresult.setResult(persons);
    	    		tcresult.setTotalcount(totalcount);
    	    		tcresult.setCurrpage(currPage+"");
    	    		tcresult.setPagesize(pageSize+"");
    			}else {
    				tcresult.setDealcode("ERR_BEAN_01");
    	    		tcresult.setDealmsg("处理失败："+result.getRetmsg());

    			}
		} catch (Exception e) {
			tcresult.setDealcode("CRL_EXC_02");
	    		tcresult.setDealmsg("处理失败："+e.getMessage());
	    		tcresult.setDealcount(0+"");
		}
        return tcresult;
    }
    
    
    @RequestMapping(value="/queryPersonDatail",method = RequestMethod.POST,produces = "text/json")
    public @ResponseBody TCResult queryPersonDatail(@RequestBody Object obj
    			){
    	@SuppressWarnings("unchecked")
		Map<String, Object> req = (Map<String, Object>)obj;
    	this.log.info("========== PersonController [queryPersonDatail] ========");
    	this.log.info("请求参数："+ req);
    	TCResult tcresult = new TCResult();
    		try {
    			
    			int currPage = req.get("currpage")==null?0:Integer.parseInt(req.get("currpage").toString());
    			int pageSize = req.get("pagesize")==null?10:Integer.parseInt(req.get("pagesize").toString());
    			
    			MethodResult result = ParamCheck.getAutoBean("Person", req, null);
    			if(result.getRetcode().equals("SUCCESS")) {
    				
    				Object person = result.getResult();
    				String totalcount = ""+personService.queryCount(person);
    	    		List<Person> persons = personService.getPersonDatail(person, currPage, pageSize);
    	    		tcresult.setDealcode("0000");
    	    		tcresult.setDealmsg("处理成功");
    	    		tcresult.setDealcount(persons.size()+"");
    	    		tcresult.setResult(persons);
    	    		tcresult.setTotalcount(totalcount);
    	    		tcresult.setCurrpage(currPage+"");
    	    		tcresult.setPagesize(pageSize+"");
    			}else {
    				tcresult.setDealcode("ERR_BEAN_01");
    	    		tcresult.setDealmsg("处理失败："+result.getRetmsg());

    			}
		} catch (Exception e) {
			tcresult.setDealcode("CRL_EXC_02");
	    		tcresult.setDealmsg("处理失败："+e.getMessage());
	    		tcresult.setDealcount(0+"");
		}
        return tcresult;
    }
    
    
}