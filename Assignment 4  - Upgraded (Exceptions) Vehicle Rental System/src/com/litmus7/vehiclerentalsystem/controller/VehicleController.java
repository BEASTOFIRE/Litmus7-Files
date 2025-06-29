package com.litmus7.vehiclerentalsystem.controller;

import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.dao.*;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class VehicleController {
	public static final int SUCCESS_STATUS_CODE = 200;
	public static final int ERROR_STATUS_CODE = 400;
	public List<Vehicle> vehicles = new ArrayList<Vehicle>();
	public static Scanner sc=new Scanner(System.in);
	VehicleDaoFile vehicleFile = new VehicleDaoFile();
	VehicleService service = new VehicleService();

	public VehicleController(VehicleDaoFile vehicleFile, VehicleService service) {
		this.vehicleFile = vehicleFile;
		this.service = service;
	}

	public Response validateLoader(String filename) {
		try {
			vehicles= service.getVehicle(filename);
			return new Response("File loaded successfully", SUCCESS_STATUS_CODE, true, vehicles);
		} catch (Exception e) {
			return new Response("Failed to load file: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}
	public Response inputDetails(String vehicle){
		try	{
			System.out.println("Enter Brand Name: ");
			String brand = sc.nextLine();
			System.out.println("Enter Model Name: ");
			String model = sc.nextLine();
			System.out.println("Enter Rental Price Per Day: ");
			double rentalPricePerDay = sc.nextDouble();
	
			if (vehicle.equalsIgnoreCase("car") == true) {
				System.out.println("Enter Number of Doors: ");
				int numberOfDoors = sc.nextInt();
				System.out.println("Is it Automatic (true/false)? ");
				boolean isAutomatic = sc.nextBoolean();
				sc.nextLine(); // Clear buffer
				System.out.println("\n");
				Car car = new Car(brand, model, rentalPricePerDay, numberOfDoors, isAutomatic);
				addVehicle(car);
			} else if (vehicle.equalsIgnoreCase("bike") == true) {
				System.out.println("Enter Engine Capacity: ");
				int engineCapacity = sc.nextInt();
				System.out.println("Does it have gears (true/false)? ");
				boolean hasGear = sc.nextBoolean();
				sc.nextLine();
				System.out.println("\n");
				Bike bike = new Bike(brand, model, rentalPricePerDay, engineCapacity, hasGear);
				addVehicle(bike);
			}
		}
		catch(Exception e) {
			return new Response("Error inputting Details due to incorrect Value type",ERROR_STATUS_CODE,false,vehicles);
		}
		return new Response("Vehicle added Successfully",SUCCESS_STATUS_CODE,true,vehicles);
	}

	public Response addVehicle(Vehicle vehicle) {
		try {
			service.addVehicle(vehicle);
			return new Response("Vehicle added successfully", SUCCESS_STATUS_CODE, true, vehicles);
		} catch (Exception e) {
			return new Response("Failed to add vehicle: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}
	
	public Response removeVehicle(String brand,String model) {
		try {
			service.removeVehicle(brand,model);
			return new Response("Vehicle removed successfully", SUCCESS_STATUS_CODE, true, vehicles);
		} catch (Exception e) {
			return new Response("Failed to remove vehicle: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	public Response calculateTotalRental() {
		try {
			double total = service.calculateRental();
			return new Response("Total rental calculated", SUCCESS_STATUS_CODE, true, total);
		} catch (Exception e) {
			return new Response("Failed to calculate rental: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	public Response rentVehicle(String model, String brand) {
		try {
			String result = service.rentVehicle(model, brand);
			return new Response(result, SUCCESS_STATUS_CODE, true, vehicles);
		} catch (Exception e) {
			return new Response("Renting failed: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

	public Response returnVehicle(String model, String brand) {
		try {
			String result = service.returnVehicle(model, brand);
			return new Response(result, SUCCESS_STATUS_CODE, true, vehicles);
		} catch (Exception e) {
			return new Response("Return failed: " + e.getMessage(), ERROR_STATUS_CODE, false, null);
		}
	}

}