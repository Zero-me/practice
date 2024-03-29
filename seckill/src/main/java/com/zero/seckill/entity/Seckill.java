package com.zero.seckill.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Zero-me
 *
 */
public class Seckill implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long seckillId;
	private String name;
	private int number;
	private Date startTime;
	private Date endTime;
	private Date createTime;
	public long getSeckillId() {
		return seckillId;
	}
	@Override
	public String toString() {
		return "Seckill [seckillId=" + seckillId + ", name=" + name + ", number=" + number + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", createTime=" + createTime + "]";
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
