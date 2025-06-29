package com.litmus7.vehiclerentalsystem.dto;

public class Response {
	
	
	private String message;
	private int statusCode;
	private boolean success;
	private Object data;

	public Response() {
	}

	public Response(String message, int statusCode, boolean success, Object data) {
		this.message = message;
		this.statusCode = statusCode;
		this.success = success;
		this.data = data;
	}

	// Getters
	public String getMessage() {
		return message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public Object getData() {
		return data;
	}

	// Setters
	public void setMessage(String message) {
		this.message = message;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
