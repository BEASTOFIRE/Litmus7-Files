package com.litmus7.vehiclerentalsystem.dto;

/**
 * 
 */
public class Bike extends Vehicle {
	private int engineCapacity;
	private boolean hasGear;

	// Default constructor with Bike specific values
	/**
	 * 
	 */
	public Bike() {
		super();
		this.engineCapacity = 125;
		this.hasGear = false;
	}

	// Parameterized constructor
	/**
	 * @param brand
	 * @param model
	 * @param rentalPricePerDay
	 * @param engineCapacity
	 * @param hasGear
	 */
	public Bike(String brand, String model, double rentalPricePerDay, int engineCapacity, boolean hasGear) {
		super(brand,model,rentalPricePerDay);
		this.engineCapacity = engineCapacity;
		this.hasGear = hasGear;
	}

	/**
	 *
	 */
	public void inputDetails() {
		System.out.println("--- Enter Bike Details ---");
		super.inputDetails();
		System.out.println("Enter Engine Capacity: ");
		engineCapacity = sc.nextInt();
		System.out.println("Does it have gears (true/false)? ");
		hasGear = sc.nextBoolean();
		sc.nextLine();
		System.out.println("\n");
	}

	/**
	 *
	 */
	public void displayDetails() {
		System.out.println("--- Bike Details ---");
		super.displayDetails();
		System.out.println("Engine Capacity: " + engineCapacity);
		System.out.println("Has Gear: " + hasGear + "\n");
	}
}
