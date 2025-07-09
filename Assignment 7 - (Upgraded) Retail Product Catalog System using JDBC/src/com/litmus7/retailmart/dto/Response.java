package com.litmus7.retailmart.dto;

/**
 * A standard generic response wrapper used to send status, messages, and data
 * from controller methods.
 *
 * @param <T> The type of the data field (e.g., User, String, etc.)
 */
public class Response<T> {

    /** Descriptive message about the response. */
    private String message;

    /** Status code (e.g., 200 for success, 400 for error). */
    private int statusCode;

    /** Indicates whether the operation was successful. */
    private boolean success;

    /** Optional data payload returned from the controller (generic type T). */
    private T data;

    /**
     * Default constructor.
     * Initializes an empty Response object.
     */
    public Response() {
    }

    /**
     * Constructor to initialize a full Response with message, status, success, and data.
     *
     * @param message    A descriptive message about the response.
     * @param statusCode The HTTP-like status code (e.g., 200 for success, 400 for error).
     * @param success    Boolean indicating the success status of the response.
     * @param data       The data to be returned (can be any type T).
     */
    public Response(String message, int statusCode, boolean success, T data) {
        this.message = message;
        this.statusCode = statusCode;
        this.success = success;
        this.data = data;
    }

    /**
     * Constructor to initialize a Response with message, status code, and success flag,
     * without any data.
     *
     * @param message    A descriptive message about the response.
     * @param statusCode The HTTP-like status code (e.g., 200 for success, 400 for error).
     * @param success    Boolean indicating the success status of the response.
     */
    public Response(String message, int statusCode, boolean success) {
        this.message = message;
        this.statusCode = statusCode;
        this.success = success;
    }

    // Getters

    /**
     * Returns the message.
     * @return message as a String
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns the status code.
     * @return status code as an int
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Returns the success status.
     * @return true if successful, false otherwise
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Returns the data payload.
     * @return data of type T
     */
    public T getData() {
        return data;
    }

    // Setters

    /**
     * Sets the message.
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Sets the status code.
     * @param statusCode the code to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Sets the success flag.
     * @param success true if successful, false otherwise
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Sets the data.
     * @param data the data to set of type T
     */
    public void setData(T data) {
        this.data = data;
    }
}
