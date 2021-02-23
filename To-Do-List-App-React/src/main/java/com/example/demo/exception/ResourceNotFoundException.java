package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException{
	private String msg;

	public ResourceNotFoundException(String msg) {
		 
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
