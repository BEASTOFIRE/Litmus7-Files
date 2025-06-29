package com.litmus7.vehiclerentalsystem.dto;

import java.util.Scanner;

/**
 * Represents a general vehicle in the rental system.
 * Provides common properties like brand, model, rental price, and availability.
 */
public class Vehicle {

	private String brand;
	private String model;
	private double rentalPricePerDay;
	private boolean isAvailable = true;

	@Override
	public String toString() {
		return "[brand=" + brand + ", model=" + model + ", rentalPricePerDay=" + rentalPricePerDay
				+ ", isAvailable=" + isAvailable;
	}

	/** 
	 * Shared Scanner instance for reading input.
	 */
	public static Scanner sc = new Scanner(System.in);

	/**
	 * Default constructor.
	 * Initializes the vehicle with placeholder values.
	 */
	public Vehicle() {
		brand = "something";
		model = "something";
		rentalPricePerDay = 1000;
	}

	/**
	 * Parameterized constructor.
	 * Initializes the vehicle with specified brand, model, and rental price.
	 *
	 * @param brand             The brand of the vehicle.
	 * @param model             The model name of the vehicle.
	 * @param rentalPricePerDay The daily rental price of the vehicle.
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Gets the brand of the vehicle.
	 * @return The brand name.
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Gets the availability status of the vehicle.
	 * @return true if available, false if rented.
	 */
	public boolean getIsAvailable() {
		return isAvailable;
	}

	/**
	 * Sets the availability of the vehicle.
	 * @param value true to mark as available, false to mark as rented.
	 */
	public void setAvailable(boolean value) {
		isAvailable = value;
	}

	/**
	 * Gets the model of the vehicle.
	 * @return The model name.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Gets the rental price per day of the vehicle.
	 * @return The rental price.
	 */
	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}
}
