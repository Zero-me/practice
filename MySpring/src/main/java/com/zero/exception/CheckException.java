package com.zero.exception;


public class CheckException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 构造器。
     *
     * @param message 消息
     */
    public CheckException(String message) {
        super(message);
    }

}
