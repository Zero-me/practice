package com.zero.seckill.dto;

import com.zero.seckill.entity.SuccessKilled;

/**
 * 封装秒杀成功后的结果
 * @author liuyingying
 *
 */
public class SeckillExecution {
	
	
	private long seckillId;
	private int status;
	private String statusInfo;
	public String getStatusInfo() {
		return statusInfo;
	}
	public SeckillExecution(long seckillId, int status, String statusInfo) {
		super();
		this.seckillId = seckillId;
		this.status = status;
		this.statusInfo = statusInfo;
	}
	public SeckillExecution(long seckillId, int status, String statusInfo, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.status = status;
		this.statusInfo = statusInfo;
		this.successKilled = successKilled;
	}
	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", status=" + status + ", statusInfo=" + statusInfo
				+ ", successKilled=" + successKilled + "]";
	}
	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}
	private SuccessKilled successKilled;
	
	
	
	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}
	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}
}
