package com.litmus7.vehiclerentalsystem.dto;

/**
 * A standard response wrapper used to send status, messages, and data from controller methods.
 */
public class Response {

	private String message;
	private int statusCode;
	private boolean success;
	private Object data;

	/**
	 * Default constructor.
	 * Initializes an empty Response object.
	 */
	public Response() {
	}

	/**
	 * Parameterized constructor to initialize a Response with provided details.
	 *
	 * @param message     A descriptive message about the response.
	 * @param statusCode  The HTTP-like status code (e.g., 200 for success, 400 for error).
	 * @param success     Boolean indicating the success status of the response.
	 * @param data        The actual data to be returned (could be any object).
	 */
	public Response(String message, int statusCode, boolean success, Object data) {
		this.message = message;
		this.statusCode = statusCode;
		this.success = success;
		this.data = data;
	}

	// Getters

	/**
	 * Gets the message of the response.
	 * @return Response message.
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Gets the status code of the response.
	 * @return HTTP-like status code.
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Checks whether the response indicates success.
	 * @return true if successful, false otherwise.
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Gets the data associated with the response.
	 * @return Response data.
	 */
	public Object getData() {
		return data;
	}

	// Setters

	/**
	 * Sets the message of the response.
	 * @param message The message to set.
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Sets the status code of the response.
	 * @param statusCode The status code to set.
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Sets the success flag of the response.
	 * @param success The success flag to set.
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Sets the data of the response.
	 * @param data The data to set.
	 */
	public void setData(Object data) {
		this.data = data;
	}
}
