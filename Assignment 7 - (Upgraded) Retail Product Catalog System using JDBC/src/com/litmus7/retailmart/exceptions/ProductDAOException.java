package com.litmus7.retailmart.exceptions;

public class ProductDAOException extends Exception{
	/**
     * Constructs a new ProductDAOException with a specified error message.
     *
     * @param errorMessage The detail message explaining the exception.
     */
    public ProductDAOException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructs a new ProductDAOException with a specified error message and a cause.
     *
     * @param errorMessage The detail message explaining the exception.
     * @param cause        The cause of the exception.
     */
    public ProductDAOException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
