package com.zero.common;

import java.io.Serializable;

/**
 * 
 * @author Zero-me
 *
 */
public class TCResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dealcode;
	private String dealmsg;
	private String dealcount;
	private String currpage;
	private String pagesize;
	private String totalcount;
	
	public String getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(String totalcount) {
		this.totalcount = totalcount;
	}
	public String getCurrpage() {
		return currpage;
	}
	public void setCurrpage(String currpage) {
		this.currpage = currpage;
	}
	public String getPagesize() {
		return pagesize;
	}
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}
	private Object result;
	
	
	
	public TCResult() {
		super();
	}
	public TCResult(String dealcode, String dealmsg, String dealcount, Object result) {
		super();
		this.dealcode = dealcode;
		this.dealmsg = dealmsg;
		this.dealcount = dealcount;
		this.result = result;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "TCResult [dealcode=" + dealcode + ", dealmsg=" + dealmsg + ", dealcount=" + dealcount + ", currpage="
				+ currpage + ", pagesize=" + pagesize + ", totalcount=" + totalcount + ", result=" + result + "]";
	}
	public TCResult(String dealcode, String dealmsg, String dealcount) {
		super();
		this.dealcode = dealcode;
		this.dealmsg = dealmsg;
		this.dealcount = dealcount;
	}
	public String getDealcode() {
		return dealcode;
	}
	public void setDealcode(String dealcode) {
		this.dealcode = dealcode;
	}
	public String getDealmsg() {
		return dealmsg;
	}
	public void setDealmsg(String dealmsg) {
		this.dealmsg = dealmsg;
	}
	public String getDealcount() {
		return dealcount;
	}
	public void setDealcount(String dealcount) {
		this.dealcount = dealcount;
	}
	
	
}
