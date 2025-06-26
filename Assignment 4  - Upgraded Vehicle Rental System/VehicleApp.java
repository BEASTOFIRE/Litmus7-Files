package com.litmus7.vehiclerentalsystem;

import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.service.*;

/**
 * Entry point of the Vehicle Rental System application.
 * Handles user interaction and calls service methods accordingly.
 */
public class VehicleApp {

	/**
	 * Main method to run the application.
	 * @param args Command-line arguments (not used)
	 */
	public static void main(String[] args) {

		// Create an instance of the service class
		VehicleService service = new VehicleService();

		// Load vehicles from a file
		service.loadVehiclesFromFile("sample_vehicles.txt");

		// Display all vehicles loaded from the file
		System.out.println("\n--- Loaded Vehicles ---");
		service.displayAllVehicles();
		System.out.println("\n---------------------");

		// Ask the user if they want to add a new vehicle
		System.out.println("Do you want to add a new Vehicle? yes/no");
		String choice = Vehicle.sc.nextLine();

		if (choice.equalsIgnoreCase("yes")) {
			System.out.println("Enter the type of vehicle to be added: car/bike");
			String type = Vehicle.sc.nextLine();

			// Create a Car object and take input if user chooses "car"
			if (type.equalsIgnoreCase("car")) {
				Car car = new Car();
				car.inputDetails();
				service.addVehicle(car);

			// Create a Bike object and take input if user chooses "bike"
			} else if (type.equalsIgnoreCase("bike")) {
				Bike bike = new Bike();
				bike.inputDetails();
				service.addVehicle(bike);
			} else {
				System.out.println("Invalid type.\n");
			}
		}
		System.out.println("\n---------------------");

		// Display updated list of vehicles after addition
		System.out.println("Updated Vehicle List\n");
		service.displayAllVehicles();
		System.out.println("\n---------------------");

		// Ask if the user wants to rent or return a vehicle
		System.out.println("Do you want to rent or return a new Vehicle? rent/return");
		choice = Vehicle.sc.nextLine();

		if (choice.equalsIgnoreCase("rent")) {

			// Show all available vehicles
			for (Vehicle v : service.vehicles) {
				if (v.getIsAvailable()) {
					v.displayDetails();
				}
			}

			// Take input and rent the selected vehicle
			System.out.println("Enter the brand:");
			String brand = Vehicle.sc.nextLine();
			System.out.println("Enter the model:");
			String model = Vehicle.sc.nextLine();
			service.rentVehicle(model, brand);

		} else if (choice.equalsIgnoreCase("return")) {

			// Show all rented (unavailable) vehicles
			for (Vehicle v : service.vehicles) {
				if (!v.getIsAvailable()) {
					v.displayDetails();
				}
			}

			// Take input and return the selected vehicle
			System.out.println("Enter the brand:");
			String brand = Vehicle.sc.nextLine();
			System.out.println("Enter the model:");
			String model = Vehicle.sc.nextLine();
			service.returnVehicle(model, brand);
		}

		// Display final list of available vehicles
		System.out.println("\n---------------------");
		System.out.println("Updated Vehicle List of all Available Vehicles\n");
		for (Vehicle v : service.vehicles) {
			if (v.getIsAvailable()) {
				v.displayDetails();
			}
		}
	}
}
