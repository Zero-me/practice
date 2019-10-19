package com.zero.seckill.dto;
/**
 * 
 * 
 * 用于封装json结果
 * 
 * 所有的ajax请求返回信息
 * @author liuyingying
 *
 */

public class SeckillResult<T> {
	
	private boolean success;
	private T data;
	private String error;
	
	
	public boolean isSuccess() {
		return success;
	}
	public SeckillResult(T data) {
		super();
		this.data = data;
	}
	@Override
	public String toString() {
		return "SeckillResult [success=" + success + ", data=" + data + ", error=" + error + "]";
	}
	public SeckillResult(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}
	public SeckillResult(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
	
}
