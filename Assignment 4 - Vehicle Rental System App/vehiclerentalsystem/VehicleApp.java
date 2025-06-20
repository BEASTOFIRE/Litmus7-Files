package com.litmus7.vehiclerentalsystem;
import com.litmus7.vehiclerentalsystem.dto.*;



/**
 * 
 */
public class VehicleApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Creating Car objects
		Car car1 = new Car();
		Car car2 = new Car("Tata", "Punch", 1000, 4, true);
		Car car3 = new Car();

		// Creating Bike objects
		Bike bike1 = new Bike();
		Bike bike2 = new Bike("Royal Enfield", "Himalayan", 700, 411, true);
		Bike bike3 = new Bike();

		// Input details for car3 and bike3
		car3.inputDetails();
		bike3.inputDetails();

		// Display all car details
		car1.displayDetails();
		car2.displayDetails();
		car3.displayDetails();

		// Display all bike details
		bike1.displayDetails();
		bike2.displayDetails();
		bike3.displayDetails();
	}
}
