package com.zero.service.impl ;

import java.io.File ;
import java.io.IOException ;
import org.springframework.beans.factory.annotation.Value ;
import org.springframework.stereotype.Service ;
import org.springframework.web.multipart.MultipartFile ;
import com.alibaba.fastjson.JSONObject ;
import com.zero.entity.ResultBean ;
import com.zero.service.BaseService ;

@Service
public class BaseServiceImpl implements BaseService {
	
	@Value("${file.upload.dir}")
	private String filePath;
	
	@Override
	public ResultBean service(JSONObject json) {
		int a = json.getIntValue("a") ;
		int b = json.getIntValue("b") ;
		int c = a/b;
		return ResultBean.newSuccessResult(c) ;
		
	}

	
	@Override
	public ResultBean upload(MultipartFile upload, String username) throws IllegalStateException, IOException {
		
		upload.transferTo(new File(filePath,upload.getOriginalFilename()));
		return ResultBean.newSuccessResult("upload success") ;
	}
	
}
