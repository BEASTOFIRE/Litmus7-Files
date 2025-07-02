package com.litmus7.vehiclerentalsystem.dto;

/**
 * Represents a Bike in the vehicle rental system.
 * Inherits basic vehicle details from the Vehicle class and adds bike-specific details:
 * engine capacity and whether it has gear.
 */
public class Bike extends Vehicle {
	private int engineCapacity;
	private boolean hasGear;

	@Override
	public String toString() {
		return "Bike " + super.toString() + ", engineCapacity=" + engineCapacity + ", hasGear=" + hasGear + "]\n";
	}

	/**
	 * Default constructor.
	 * Initializes a Bike with default values: 125cc engine and no gear.
	 * Also calls the default constructor of Vehicle.
	 */
	public Bike() {
		super();
		this.engineCapacity = 125;
		this.hasGear = false;
	}

	/**
	 * Parameterized constructor.
	 * Initializes a Bike with the given brand, model, rental price, engine capacity, and gear presence.
	 *
	 * @param brand              The brand of the bike.
	 * @param model              The model name of the bike.
	 * @param rentalPricePerDay  Daily rental price.
	 * @param engineCapacity     Engine capacity in cc.
	 * @param hasGear            True if the bike has gears; false otherwise.
	 */
	public Bike(String brand, String model, double rentalPricePerDay, int engineCapacity, boolean hasGear) {
		super(brand, model, rentalPricePerDay);
		this.engineCapacity = engineCapacity;
		this.hasGear = hasGear;
	}
}
