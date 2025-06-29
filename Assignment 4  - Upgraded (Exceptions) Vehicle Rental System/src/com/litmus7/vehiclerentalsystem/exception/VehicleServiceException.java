package com.litmus7.vehiclerentalsystem.exception;

public class VehicleServiceException extends Exception {

	public VehicleServiceException(String errorMessage) {
		super(errorMessage);
	}
	
	public VehicleServiceException(String errorMessage, Throwable cause) {
		super(errorMessage,cause);
	}
}
