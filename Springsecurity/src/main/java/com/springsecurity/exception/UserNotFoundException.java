package com.springsecurity.exception;

public class UserNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public UserNotFoundException(String msg) {
		super();
		this.msg = msg;
	}
	

}
