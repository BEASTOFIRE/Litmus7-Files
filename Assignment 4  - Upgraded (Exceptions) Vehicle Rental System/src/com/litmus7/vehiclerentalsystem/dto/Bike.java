package com.litmus7.vehiclerentalsystem.dto;

/**
 * 
 */
public class Bike extends Vehicle {
	private int engineCapacity;
	private boolean hasGear;

	@Override
	public String toString() {
		return "Bike "+super.toString()+", engineCapacity=" + engineCapacity + ", hasGear=" + hasGear + "]"+"\n";
	}

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
	public void displayDetails() {
		System.out.println("--- Bike Details ---");
		System.out.println("Engine Capacity: " + engineCapacity);
		System.out.println("Has Gear: " + hasGear + "\n");
	}
}
