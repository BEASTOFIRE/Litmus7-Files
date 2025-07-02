package com.litmus7.vehiclerentalsystem.dto;

/**
 * 
 * A standard generic response wrapper used to send status, messages, and data
 * from controller methods.
 * 
 * @param <T> The type of the data field.
 */
public class Response<T> {

	private String message;
	private int statusCode;
	private boolean success;
	private T data;

	/**
	 * 
	 * Default constructor.
	 * 
	 * Initializes an empty Response object.
	 */
	public Response() {
	}

	/**
	 * 
	 * Parameterized constructor to initialize a Response with provided details.
	 * 
	 * @param message    A descriptive message about the response.
	 * 
	 * @param statusCode The HTTP-like status code (e.g., 200 for success, 400 for
	 *                   error).
	 * 
	 * @param success    Boolean indicating the success status of the response.
	 * 
	 * @param data       The actual data to be returned (of type T).
	 */
	public Response(String message, int statusCode, boolean success, T data) {
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

	public T getData() {
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

	public void setData(T data) {
		this.data = data;
	}
}