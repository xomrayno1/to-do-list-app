package com.example.demo.exception;

import java.util.Date;
public class ErrorDetails {
	private int code;
	private String messages;
	private Date date;
	private String description;
	
	
	public ErrorDetails() {
		 
	}
	public ErrorDetails(int code, String messages, Date date, String description) {
		 
		this.code = code;
		this.messages = messages;
		this.date = date;
		this.description = description;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
