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
	// Input details
	public void inputDetails() {
		System.out.println("Enter Brand Name: ");
		brand = sc.nextLine();
		System.out.println("Enter Model Name: ");
		model = sc.nextLine();
		System.out.println("Enter Rental Price Per Day: ");
		rentalPricePerDay = sc.nextDouble();
	}

	// Display details
	public void displayDetails() {
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Rental Price Per Day: " + rentalPricePerDay);
		System.out.println("Available for Rent: " + (isAvailable ? "Yes" : "No"));
		
	}
}
