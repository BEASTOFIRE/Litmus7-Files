package com.litmus7.vehiclerentalsystem.exception;

/**
 * Custom exception for errors that occur in the service layer of the vehicle rental system.
 * This includes logic-related issues like invalid input, operations on unavailable vehicles, etc.
 */
public class VehicleServiceException extends Exception {

    /**
     * Constructs a new VehicleServiceException with a specified error message.
     *
     * @param errorMessage The detail message explaining the exception.
     */
    public VehicleServiceException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * Constructs a new VehicleServiceException with a specified error message and a cause.
     *
     * @param errorMessage The detail message explaining the exception.
     * @param cause        The cause of the exception.
     */
    public VehicleServiceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
