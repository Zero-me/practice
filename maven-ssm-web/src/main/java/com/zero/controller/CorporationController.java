package com.zero.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zero.common.MethodResult;
import com.zero.common.TCResult;
import com.zero.common.util.ParamCheck;
import com.zero.model.Corporation;
import com.zero.service.ICorporationService;
/**
 * 
 * @author Zero-me
 *
 */
@Controller
@RequestMapping("/corporation")
public class CorporationController {
	private Logger log = Logger.getLogger(CorporationController.class);
	private ICorporationService corporationService;
    
    public ICorporationService getCorporationService() {
        return corporationService;
    }

    @Autowired
    public void setCorporationService(ICorporationService corporationService) {
        this.corporationService = corporationService;
    }

    
    @RequestMapping(value="/showCorporations")
    public @ResponseBody TCResult showCorporationss(){
    	this.log.info("========== CorporationController [showCorporations] =========");
    	TCResult tcresult = new TCResult();
        
    	try {
    		List<Corporation> corporations = corporationService.loadCorporation();
    		tcresult.setDealcode("0000");
    		tcresult.setDealmsg("处理成功");
    		tcresult.setDealcount(corporations.size()+"");
    		tcresult.setResult(corporations);
		} catch (Exception e) {
			tcresult.setDealcode("CRL_EXC_01:"+e.getMessage());
    		tcresult.setDealmsg("处理失败");
    		tcresult.setDealcount(0+"");
		}
        return tcresult;
    }
    
    
    @RequestMapping(value="/addcorporation",method = RequestMethod.POST,produces = "text/json")
    public @ResponseBody TCResult insertCorporations(@RequestBody Object obj
    			){
    	this.log.info("=======> CorporationController [addcorporation]  <=======");
    	@SuppressWarnings("unchecked")
    	Map<String, Object> req = (Map<String, Object>)obj;
    	this.log.info("请求参数："+ req);
    	TCResult tcresult = new TCResult();
    	try {
    		MethodResult result = ParamCheck.getAutoBean("Corporation", req, null);
    		if(result.getRetcode().equals("SUCCESS")) {
    			
    			Object corporation = result.getResult();
    			boolean res= corporationService.insertCorporation(corporation);
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
    			tcresult.setDealcode("ERR_Bean_01");
        		tcresult.setDealmsg("处理失败："+ result.getRetmsg());
        		tcresult.setDealcount(0+"");
    		}
    		
		} catch (Exception e) {
			tcresult.setDealcode("210");
	    		tcresult.setDealmsg("处理失败："+e.getMessage());
	    		tcresult.setDealcount(0+"");
		}
        return tcresult;
    }
    
    
    @RequestMapping(value="/deleteCorporationByWhere",method = RequestMethod.POST,produces = "text/json")
    public @ResponseBody TCResult deleteCorporation(@RequestBody Object obj
    			){
    	this.log.info("=======> CorporationController [deleteCorporationByWhere] <=======");
    	@SuppressWarnings("unchecked")
		Map<String, Object> req = (Map<String, Object>)obj;
    	this.log.info("请求参数："+ req);
    		TCResult tcresult = new TCResult();
    		try {
    			MethodResult result = ParamCheck.getAutoBean("Corporation", req, null);
        		if(result.getRetcode().equals("SUCCESS")) {
        			Object corporation = result.getResult();
        			int count = 0;
    	    		if((count = corporationService.queryCount(corporation)) > 0) {
    	    			corporationService.deleteByWhere(corporation);
    	    			tcresult.setDealcode("0000");
    	        		tcresult.setDealmsg("处理成功");
    	        		tcresult.setDealcount(count+"");
    	        		tcresult.setResult(corporation);
    	    		}else {
    	    			tcresult.setDealcode("0000");
    	        		tcresult.setDealmsg("需要删除的数据不存在");
    	        		tcresult.setDealcount(0+"");
    	    		}
        		}else {
        			tcresult.setDealcode("ERR_Bean_01");
	        		tcresult.setDealmsg("处理失败："+ result.getRetmsg());
	        		tcresult.setDealcount(0+"");
        		}
	    		
		} catch (Exception e) {
		tcresult.setDealcode("DB_EXC_03");
    		tcresult.setDealmsg("处理失败："+e.getMessage());
    		tcresult.setDealcount(0+"");
		}
        return tcresult;
    }
    
    @RequestMapping(value="/queryCorporationByWhere",method = RequestMethod.POST,produces = "text/json")
    public @ResponseBody TCResult queryCorporationByWhere(@RequestBody Object obj
    			){
    	this.log.info("=======> CorporationController [queryCorporationByWhere] <=======");
    	@SuppressWarnings("unchecked")
		Map<String, Object> req = (Map<String, Object>)obj;
    	this.log.info("请求参数："+ req);
    	TCResult tcresult = new TCResult();
    		try {
    			
    			int currPage = req.get("currpage")==null?0:Integer.parseInt(req.get("currpage").toString());
    			int pageSize = req.get("pagesize")==null?10:Integer.parseInt(req.get("pagesize").toString());
    			
	    		MethodResult result = ParamCheck.getAutoBean("Corporation", req, null);
        		if(result.getRetcode().equals("SUCCESS")) {
        			Object corporation = result.getResult();
        			this.log.info(corporation);
        			String totalcount = ""+corporationService.queryCount(corporation);
    	    		List<Corporation> corporations = corporationService.queryByWherePage(corporation,currPage,pageSize);
    	    		tcresult.setDealcode("0000");
    	    		tcresult.setDealmsg("处理成功");
    	    		tcresult.setDealcount(corporations.size()+"");
    	    		tcresult.setResult(corporations);
    	    		tcresult.setTotalcount(totalcount);
    	    		tcresult.setCurrpage(currPage+"");
    	    		tcresult.setPagesize(pageSize+"");
        		}else {
        			tcresult.setDealcode("ERR_Bean_01");
	        		tcresult.setDealmsg("处理失败："+ result.getRetmsg());
	        		tcresult.setDealcount(0+"");
        		}
	    		
		} catch (Exception e) {
			tcresult.setDealcode("CRL_EXC_02");
	    		tcresult.setDealmsg("处理失败："+e.getMessage());
	    		tcresult.setDealcount(0+"");
		}
        return tcresult;
    }
}
