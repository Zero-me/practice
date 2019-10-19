package com.zero.seckill.dto;
/**
 * 	暴露秒杀地址的DTO 
 * @author liuyingying
 *
 */
public class Exposer {
	
	/* 是否开启秒杀 */
	private boolean exposed;
	
	/*  加密措施 */
	private String md5;
	
	private long seckillId;
	
	private long start;
	
	public boolean isExposerd() {
		return exposed;
	}
	
	@Override
	public String toString() {
		return "Exposer [exposed=" + exposed + ", md5=" + md5 + ", seckillId=" + seckillId + ", start=" + start
				+ ", end=" + end + ", now=" + now + "]";
	}

	private long end;

	/* 当前系统时间 (毫秒)*/
	private long now;
	
	public Exposer(boolean exposed, long seckillId,long now, long start, long end) {
		super();
		this.exposed = exposed;
		this.now = now;
		this.seckillId = seckillId;
		this.start = start;
		this.end = end;
	}

	public boolean isExposed() {
		return exposed;
	}

	public void setExposed(boolean exposed) {
		this.exposed = exposed;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public long getNow() {
		return now;
	}

	public void setNow(long now) {
		this.now = now;
	}

	public Exposer(boolean exposed, String md5, long seckillId) {
		super();
		this.exposed = exposed;
		this.md5 = md5;
		this.seckillId = seckillId;
	}

	public Exposer(boolean exposed, long seckillId) {
		super();
		this.exposed = exposed;
		this.seckillId = seckillId;
	}
	

}
