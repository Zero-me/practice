package com.zero.entity ;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject ;
import lombok.Data ;

@Data
public class ResultBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String	resultCode ;
	
	private String	resultMsg ;
	
	private Object	data ;
	
	public static ResultBean newSuccessResult(Object data) {
		ResultBean result = new ResultBean() ;
		result.data = data ;
		result.resultCode = "0" ;
		result.resultMsg = "success" ;
		return result ;
	}
	
	public static ResultBean newFailedResult(Object data) {
		ResultBean result = new ResultBean() ;
		result.data = data ;
		result.resultCode = "-1" ;
		result.resultMsg = "failed" ;
		return result ;
	}
	
	@Override
	public String toString() {
		JSONObject result = new JSONObject() ;
		result.put("data", data) ;
		result.put("resultCode", resultCode) ;
		result.put("resultMsg", resultMsg) ;
		return result.toJSONString() ;
	}
	
}
