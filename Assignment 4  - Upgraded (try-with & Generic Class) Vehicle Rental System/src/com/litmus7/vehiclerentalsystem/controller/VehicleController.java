package com.litmus7.vehiclerentalsystem.controller;

import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.dao.*;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class that handles user input and interacts with the service layer.
 * Responsible for processing business operations and returning responses.
 */
public class VehicleController {

	public static final int SUCCESS_STATUS_CODE = 200;
	public static final int ERROR_STATUS_CODE = 400;
	public List<Vehicle> vehicles = new ArrayList<Vehicle>();
	public static Scanner sc = new Scanner(System.in);
	VehicleDaoFile vehicleFile = new VehicleDaoFile();
	VehicleService service = new VehicleService();

	/**
	 * Constructor to initialize the controller with DAO and service objects.
	 *
	 * @param vehicleFile Data access object for file operations.
	 * @param service     Service layer to handle business logic.
	 */
	public VehicleController(VehicleDaoFile vehicleFile, VehicleService service) {
		this.vehicleFile = vehicleFile;
		this.service = service;
	}

	/**
	 * Loads vehicle data from a file and returns a response with the vehicle list.
	 *
	 * @param filename Name of the file to be loaded.
	 * @return Response object containing success or failure status.
	 */
	public Response<List<Vehicle>> validateLoader(String filename) {
		try {
			vehicles = service.getVehicle(filename);
			return new Response<List<Vehicle>>("File loaded successfully", SUCCESS_STATUS_CODE, true, vehicles);
		} catch (Exception e) {
			return new Response<List<Vehicle>>("Failed to load file: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	/**
	 * Accepts input from the user for vehicle details and adds it to the list.
	 *
	 * @param vehicle Type of vehicle ("car" or "bike").
	 * @return Response indicating success or failure.
	 */
	public Response<List<Vehicle>> inputDetails(String vehicle) {
		try {
			if (vehicle.equalsIgnoreCase("car") || vehicle.equalsIgnoreCase("bike")) {
				System.out.println("Enter Brand Name: ");
				String brand = sc.nextLine();
				System.out.println("Enter Model Name: ");
				String model = sc.nextLine();
				System.out.println("Enter Rental Price Per Day: ");
				double rentalPricePerDay = sc.nextDouble();

				if (vehicle.equalsIgnoreCase("car")) {
					System.out.println("Enter Number of Doors: ");
					int numberOfDoors = sc.nextInt();
					System.out.println("Is it Automatic (true/false)? ");
					boolean isAutomatic = sc.nextBoolean();
					sc.nextLine(); 
					System.out.println("\n");
					Car car = new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic);
					addVehicle(car);
				} else {
					System.out.println("Enter Engine Capacity: ");
					int engineCapacity = sc.nextInt();
					System.out.println("Does it have gears (true/false)? ");
					boolean hasGear = sc.nextBoolean();
					sc.nextLine();
					System.out.println("\n");
					Bike bike = new Bike(brand, model, rentalPricePerDay, engineCapacity, hasGear);
					addVehicle(bike);
				}
				return new Response<List<Vehicle>>("Vehicle added Successfully", SUCCESS_STATUS_CODE, true, vehicles);
			} else {
				return new Response<List<Vehicle>>("Invalid vehicle type entered", ERROR_STATUS_CODE, false, vehicles);
			}
		} catch (Exception e) {
			return new Response<List<Vehicle>>("Error inputting Details due to incorrect Value type", ERROR_STATUS_CODE, false, vehicles);
		}
	}

	/**
	 * Adds a vehicle to the system.
	 *
	 * @param vehicle Vehicle object to be added.
	 * @return Response indicating success or failure of the operation.
	 */
	public Response<List<Vehicle>> addVehicle(Vehicle vehicle) {
		try {
			service.addVehicle(vehicle);
			return new Response<List<Vehicle>>("Vehicle added successfully", SUCCESS_STATUS_CODE, true, vehicles);
		} catch (Exception e) {
			return new Response<List<Vehicle>>("Failed to add vehicle: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	/**
	 * Removes a vehicle from the system based on brand and model.
	 *
	 * @param brand Brand of the vehicle.
	 * @param model Model of the vehicle.
	 * @return Response indicating success or failure.
	 */
	public Response<List<Vehicle>> removeVehicle(String brand, String model) {
		try {
			service.removeVehicle(brand, model);
			return new Response<List<Vehicle>>("Vehicle removed successfully", SUCCESS_STATUS_CODE, true, vehicles);
		} catch (Exception e) {
			return new Response<List<Vehicle>>("Failed to remove vehicle: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	/**
	 * Calculates the total rental cost of all vehicles.
	 *
	 * @return Response with total rental cost.
	 */
	public Response <Double>calculateTotalRental() {
		try {
			double total = service.calculateRental();
			return new Response<Double>("Total rental calculated", SUCCESS_STATUS_CODE, true, total);
		} catch (Exception e) {
			return new Response<Double>("Failed to calculate rental: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	/**
	 * Rents a vehicle by marking it unavailable.
	 *
	 * @param model Model name of the vehicle.
	 * @param brand Brand name of the vehicle.
	 * @return Response indicating success or failure.
	 */
	public Response<List<Vehicle>> rentVehicle(String model, String brand) {
		try {
			String result = service.rentVehicle(model, brand);
			return new Response<List<Vehicle>>(result, SUCCESS_STATUS_CODE, true, vehicles);
		} catch (Exception e) {
			return new Response<List<Vehicle>>("Renting failed: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	/**
	 * Returns a rented vehicle by marking it available again.
	 *
	 * @param model Model name of the vehicle.
	 * @param brand Brand name of the vehicle.
	 * @return Response indicating success or failure.
	 */
	public Response<List<Vehicle>> returnVehicle(String model, String brand) {
		try {
			String result = service.returnVehicle(model, brand);
			return new Response<List<Vehicle>>(result, SUCCESS_STATUS_CODE, true, vehicles);
		} catch (Exception e) {
			return new Response<List<Vehicle>>("Return failed: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}
}
