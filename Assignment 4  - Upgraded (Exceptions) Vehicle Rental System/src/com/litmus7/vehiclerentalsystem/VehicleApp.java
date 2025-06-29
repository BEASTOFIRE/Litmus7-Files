package com.litmus7.vehiclerentalsystem;

import com.litmus7.vehiclerentalsystem.controller.VehicleController;
import com.litmus7.vehiclerentalsystem.dao.VehicleDaoFile;
import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.service.VehicleService;


/**
 * Entry point of the Vehicle Rental System application. Handles user
 * interaction and calls service methods accordingly.
 */
public class VehicleApp {

	public static void main(String[] args) {

		VehicleService service = new VehicleService();
		VehicleDaoFile dao = new VehicleDaoFile();
		VehicleController control = new VehicleController(dao, service);

		System.out.println("Loading Data into File");
		Response response = control.validateLoader("sample_vehicles.txt");
		System.out.println(response.getMessage());
		System.out.println(response.getData());

		System.out.println("\nAdd a Vehicle \n\n" + "Enter Vehicle Type:");
		String type = control.sc.nextLine();
		response = control.inputDetails(type);
		System.out.println(response.getMessage());
		System.out.println(response.getData());

		System.out.println("Remove a Vehicle: \n" + "Enter Vehicle brand:");
		String brand = "Toyota";
		System.out.println("Enter Vehicle model:");
		String model = "Corolla";
		response = control.removeVehicle(brand, model);
		System.out.println(response.getMessage());
		System.out.println(response.getData());

		System.out.println("\n Rent a Vehicle:" + "Enter Vehicle brand:");
		brand = control.sc.nextLine();
		System.out.println("Enter Vehicle model:");
		model = control.sc.nextLine();
		response = control.rentVehicle(brand, model);
		System.out.println(response.getMessage());
		System.out.println(response.getData());

		System.out.println("\n Calculate total rent:");
		response = control.calculateTotalRental();
		System.out.println(response.getMessage());
		System.out.println(response.getData());

		System.out.println("\n Return a Vehicle:" + "Enter Vehicle brand:");
		brand = control.sc.nextLine();
		System.out.println("Enter Vehicle model:");
		model = control.sc.nextLine();
		response = control.returnVehicle(brand, model);
		System.out.println(response.getMessage());
		System.out.println(response.getData());

	}
}
