package com.zero.controller ;

import java.io.IOException ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.web.bind.annotation.RequestBody ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestMethod ;
import org.springframework.web.bind.annotation.RestController ;
import org.springframework.web.multipart.MultipartFile ;
import org.springframework.web.servlet.ModelAndView ;
import com.alibaba.fastjson.JSONObject ;
import com.zero.entity.ResultBean ;
import com.zero.service.BaseService ;

@RestController
@RequestMapping("")
public class BaseController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass()) ;

	
	@Autowired
	private BaseService baseService ;
	
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ResultBean test( @RequestBody JSONObject json) {
		return baseService.service(json) ;
	}
	
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public ModelAndView websocket() {
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("websocket") ;
		return mv ;
	}
	
	@RequestMapping(value = "/up", method = RequestMethod.GET)
	public ModelAndView up() {
		ModelAndView mv = new ModelAndView() ;
		mv.setViewName("upload") ;
		return mv ;
	}
	
	@RequestMapping("/upload")
    public ResultBean upload(MultipartFile upload,String username) throws IOException {
		return baseService.upload(upload, username);
    }
}
