package com.litmus7.userregistrationsys.exception;

public class InvalidEmailException extends Exception{
	/**
     * Constructs a new InvalidEmailException with a specified error message.
     *
     * @param errorMessage The detail message explaining the exception.
     */
	public InvalidEmailException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructs a new InvalidEmailException with a specified error message and a cause.
     *
     * @param errorMessage The detail message explaining the exception.
     * @param cause        The cause of the exception.
     */
    public InvalidEmailException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
