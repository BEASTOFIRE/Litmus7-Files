package com.litmus7.vehiclerentalsystem.dto;

/**
 * 
 */
public class Car extends Vehicle{
	
	private int numberOfDoors;
	private boolean isAutomatic;

	// Default constructor with Car specific values
	/**
	 * 
	 */
	public Car() {
		super("Honda", "Civic", 1400.00);
		this.numberOfDoors = 4;
		this.isAutomatic = false;
	}

	// Parameterized constructor
	/**
	 * @param brand
	 * @param model
	 * @param rentalPricePerDay
	 * @param numberOfDoors
	 * @param isAutomatic
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 *
	 */
	public void inputDetails() {
		System.out.println("--- Enter Car Details ---");
		super.inputDetails();
		System.out.println("Enter Number of Doors: ");
		numberOfDoors = sc.nextInt();
		System.out.println("Is it Automatic (true/false)? ");
		isAutomatic = sc.nextBoolean();
		sc.nextLine();
		System.out.println("\n");
	}

	/**
	 *
	 */
	public void displayDetails() {
		System.out.println("--- Car Details ---");
		super.displayDetails();
		System.out.println("Number of Doors: " + numberOfDoors);
		System.out.println("Is Automatic: " + isAutomatic + "\n");
	}
}
