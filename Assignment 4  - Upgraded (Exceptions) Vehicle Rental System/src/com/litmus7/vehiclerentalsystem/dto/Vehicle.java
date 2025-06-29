package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

/**
 * 
 */
public class Vehicle {
	
	private String brand;
	private String model;
	private double rentalPricePerDay;
	private boolean isAvailable=true; 
	
	@Override
	public String toString() {
		return "[brand=" + brand + ", model=" + model + ", rentalPricePerDay=" + rentalPricePerDay
				+ ", isAvailable=" + isAvailable;
	}
	public static Scanner sc = new Scanner(System.in);

	/**
	 * 
	 */
	public Vehicle() {
		brand = "something";
		model = "something";
		rentalPricePerDay = 1000;
	}

	/**
	 * @param brand
	 * @param model
	 * @param rentalPricePerDay
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}
	
	public void setAvailable(boolean value) {
		isAvailable=value;
	}
	
	
	public String getModel() {
		return model;
	}
	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}	
	
}
