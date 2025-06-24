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

		VehicleService service = new VehicleService();

		// 1️⃣ Load vehicles from file
		service.loadVehiclesFromFile("sample_vehicles.txt");

		// 2️⃣ Display loaded vehicles
		System.out.println("\n--- Loaded Vehicles ---");
		service.displayAllVehicles();
		System.out.println("\n---------------------");

		System.out.println("Do you want to add a new Vehicle? yes/no");
		String choice = Vehicle.sc.nextLine();
		if (choice.equalsIgnoreCase("yes")) {
			System.out.println("Enter the type of vehicle to be added: car/bike");
			String type = Vehicle.sc.nextLine();

			if (type.equalsIgnoreCase("car") == true) {
				Car car = new Car();
				car.inputDetails();
				service.addVehicle(car);
			} else if (type.equalsIgnoreCase("bike") == true) {
				Bike bike = new Bike();
				bike.inputDetails();
				service.addVehicle(bike);
			} else {
				System.out.println("Invalid type.\n");
			}
		}
		System.out.println("\n---------------------");

		System.out.println("Updated Vehicle List\n");
		service.displayAllVehicles();
		System.out.println("\n---------------------");
		System.out.println("Do you want to rent or return a new Vehicle? rent/return");
		choice = Vehicle.sc.nextLine();
		if (choice.equalsIgnoreCase("rent")) {
			for (Vehicle v : service.vehicles) {
				if (v.getIsAvailable() == true) {
					v.displayDetails();
				}
			}
			System.out.println("Enter the brand:");
			String brand = Vehicle.sc.nextLine();
			System.out.println("Enter the model:");
			String model = Vehicle.sc.nextLine();
			service.rentVehicle(model, brand);
		} else if (choice.equalsIgnoreCase("return")) {
			for (Vehicle v : service.vehicles) {
				if (v.getIsAvailable() == false) {
					v.displayDetails();
				}
			}
			System.out.println("Enter the brand:");
			String brand = Vehicle.sc.nextLine();
			System.out.println("Enter the model:");
			String model = Vehicle.sc.nextLine();
			service.returnVehicle(model, brand);
		}
		System.out.println("\n---------------------");
		System.out.println("Updated Vehicle List of all Available Vehicles\n");
		for (Vehicle v : service.vehicles) {
			if (v.getIsAvailable() == true) {
				v.displayDetails();
			}
		}
	}
}
