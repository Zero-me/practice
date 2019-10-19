package com.zero.service ;

import java.io.IOException ;
import org.springframework.web.multipart.MultipartFile ;
import com.alibaba.fastjson.JSONObject ;
import com.zero.entity.ResultBean ;

public interface BaseService {
	
	public ResultBean service(JSONObject json) ;
	
	public ResultBean upload(MultipartFile upload,String username) throws IllegalStateException, IOException;
}
