package com.litmus7.retailmart.exceptions;

public class ProductServiceException extends Exception{
	/**
     * Constructs a new ProductServiceException with a specified error message.
     *
     * @param errorMessage The detail message explaining the exception.
     */
    public ProductServiceException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructs a new ProductServiceException with a specified error message and a cause.
     *
     * @param errorMessage The detail message explaining the exception.
     * @param cause        The cause of the exception.
     */
    public ProductServiceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
