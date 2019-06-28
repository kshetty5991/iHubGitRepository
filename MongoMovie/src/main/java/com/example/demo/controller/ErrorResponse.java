package com.example.demo.controller;

public class ErrorResponse {

	private int reasonCode;
	private String Errmessage;
	public int getReasonCode() {
		return reasonCode;
	}
	public void setReasonCode(int reasonCode) {
		this.reasonCode = reasonCode;
	}
	public String getErrmessage() {
		return Errmessage;
	}
	public void setErrmessage(String errmessage) {
		Errmessage = errmessage;
	}
	
}
