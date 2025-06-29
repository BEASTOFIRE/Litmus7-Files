package com.litmus7.vehiclerentalsystem.exception;

public class VehicleDataAccessException extends Exception{
	public VehicleDataAccessException(String error) {
		super(error);
	}
	public VehicleDataAccessException(String error,Throwable cause) {
		super(error,cause);
	}
}
