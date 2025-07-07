package com.litmus7.userregistrationsys.exception;

public class WeakPasswordException extends Exception{
	/**
     * Constructs a new WeakPasswordException with a specified error message.
     *
     * @param errorMessage The detail message explaining the exception.
     */
    public WeakPasswordException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructs a new WeakPasswordException with a specified error message and a cause.
     *
     * @param errorMessage The detail message explaining the exception.
     * @param cause        The cause of the exception.
     */
    public WeakPasswordException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
