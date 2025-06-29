package com.litmus7.vehiclerentalsystem.dto;

/**
 * Represents a Car in the vehicle rental system.
 * Inherits basic vehicle details from the Vehicle class and adds specific fields:
 * number of doors and whether it is automatic.
 */
public class Car extends Vehicle {

	private int numberOfDoors;
	private boolean isAutomatic;

	@Override
	public String toString() {
		return "Car "+super.toString()+",  numberOfDoors=" + numberOfDoors + ", isAutomatic=" + isAutomatic + "]"+"\n";
	}

	/**
	 * Default constructor.
	 * Initializes a Car with default values: 4 doors and not automatic.
	 * Also calls the default constructor of Vehicle.
	 */
	public Car() {
		super();
		this.numberOfDoors = 4;
		this.isAutomatic = false;
	}

	/**
	 * Parameterized constructor.
	 * Initializes a Car with given brand, model, rental price, number of doors, and transmission type.
	 *
	 * @param brand              The brand of the car.
	 * @param model              The model name of the car.
	 * @param rentalPricePerDay  Daily rental price.
	 * @param numberOfDoors      Number of doors in the car.
	 * @param isAutomatic        True if the car has automatic transmission; false otherwise.
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Displays details of the car, including general vehicle details and car-specific ones.
	 */
	public void displayDetails() {
		System.out.println("--- Car Details ---");
		System.out.println("Number of Doors: " + numberOfDoors);
		System.out.println("Is Automatic: " + isAutomatic + "\n");
	}
}
