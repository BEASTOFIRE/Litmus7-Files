package com.litmus7.vehiclerentalsystem.exception;

/**
 * Custom exception to handle errors related to data access operations
 * for vehicle records such as reading from a file.
 */
public class VehicleDataAccessException extends Exception {

    /**
     * Constructs a new VehicleDataAccessException with the specified error message.
     * 
     * @param error The detail message.
     */
    public VehicleDataAccessException(String error) {
        super(error);
    }

    /**
     * Constructs a new VehicleDataAccessException with the specified error message and cause.
     * 
     * @param error The detail message.
     * @param cause The cause of the exception.
     */
    public VehicleDataAccessException(String error, Throwable cause) {
        super(error, cause);
    }
}
