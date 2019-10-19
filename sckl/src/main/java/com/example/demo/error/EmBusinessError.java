package com.example.demo.error;

public enum EmBusinessError  implements CommonError{
	/* 通用错误类型*/
	PARAMETER_VALIDTION_ERROR(10001,"参数不合法"),
	UNKNOWN_ERROR(10002,"未知错误"),
	
	/*邮箱验证失败*/
	USER_MAIL_ERROR(10003,"邮箱验证失败"),
	USER_MAIL_EXIST(1004,"该邮箱已经注册，请重新输入"),
	
	/*用户相关错误定义*/
	USER_NOT_EXIST(20001,"用户不存在"),
	USER_LOGIN_FAIL(20002,"用户名或密码不正确"),
	
	/*秒杀商品相关*/
	SCKL_IS_REPEAT(3001,"秒杀商品ID重复"),
	SCKL_NOT_EXIST(3002,"秒杀商品不存在"),
	SCKL_REMOVE_ERROR(3003,"秒杀商品删除出错")
	;

	private int errCode;
	private String errMsg;
	
	private EmBusinessError(int errCode,String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}
	
	@Override
	public int getErrCode() {
		return errCode;
	}

	@Override
	public String getErrMsg() {
		return errMsg;
	}

	@Override
	public CommonError setErrMsg(String errMsg) {
		this.errMsg = errMsg;
		return this;
	}


}
