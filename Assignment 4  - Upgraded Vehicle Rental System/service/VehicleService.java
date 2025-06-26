package com.litmus7.vehiclerentalsystem.service;

import com.litmus7.vehiclerentalsystem.dto.*;
import java.util.*;
import java.io.*;

/**
 * Service class to manage a list of vehicles.
 * Provides functionalities to load, add, display, search, rent, and return vehicles.
 */
public class VehicleService {

	// List to store all vehicles
	public List<Vehicle> vehicles = new ArrayList<Vehicle>();

	/**
	 * Loads vehicles from a file into the vehicles list.
	 * Each line in the file should represent a vehicle with comma-separated values.
	 */
	public void loadVehiclesFromFile(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;

			// Read each line from the file
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				String type = data[0];

				// If the vehicle is a Car
				if (type.equals("Car")) {
					String brand = data[1];
					String model = data[2];
					double rentalPrice = Double.parseDouble(data[3]);
					int numberOfDoors = Integer.parseInt(data[4]);
					boolean isAutomatic = Boolean.parseBoolean(data[5]);

					Car car = new Car(brand, model, rentalPrice, numberOfDoors, isAutomatic);
					vehicles.add(car);

				// If the vehicle is a Bike
				} else if (type.equals("Bike")) {
					String brand = data[1];
					String model = data[2];
					double rentalPrice = Double.parseDouble(data[3]);
					boolean hasGear = Boolean.parseBoolean(data[4]);
					int engineCapacity = Integer.parseInt(data[5]);

					Bike bike = new Bike(brand, model, rentalPrice, engineCapacity, hasGear);
					vehicles.add(bike);
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading file" + e.getMessage());
		}
	}

	/**
	 * Adds a new vehicle to the list.
	 * @param vehicle Vehicle object to be added.
	 */
	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	/**
	 * Displays details of all vehicles in the list.
	 */
	public void displayAllVehicles() {
		for (Vehicle v : vehicles) {
			v.displayDetails();
			System.out.println("\n");
		}
	}

	/**
	 * Searches for vehicles that match the given brand or model.
	 * @param keyword Brand or model name to search.
	 */
	public void searchVehicles(String keyword) {
		for (Vehicle v : vehicles) {
			if (v.getBrand().equalsIgnoreCase(keyword) || v.getModel().equalsIgnoreCase(keyword)) {
				v.displayDetails();
				System.out.println("\n");
			}
		}
	}

	/**
	 * Calculates and returns the total rental price of all vehicles.
	 * @return Total rental price per day.
	 */
	public double calculateRental() {
		double total = 0.0;
		for (Vehicle v : vehicles) {
			total += v.getRentalPricePerDay();
		}
		return total;
	}

	/**
	 * Rents a vehicle by setting its availability to false if found and available.
	 * @param model Model name of the vehicle.
	 * @param brand Brand name of the vehicle.
	 */
	public void rentVehicle(String model, String brand) {
		int flag = 0;

		for (Vehicle v : vehicles) {
			if (v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand)) {
				if (v.getIsAvailable()) {
					v.setAvailable(false);
					flag = 1;
					System.out.println("Vehicle Rented Successfully");
				} else {
					flag = 1;
					System.out.println("Vehicle already Rented");
				}
			}
		}

		if (flag == 0) {
			System.out.println("Vehicle not found.");
		}
	}

	/**
	 * Returns a rented vehicle by setting its availability to true if found and not already available.
	 * @param model Model name of the vehicle.
	 * @param brand Brand name of the vehicle.
	 */
	public void returnVehicle(String model, String brand) {
		int flag = 0;

		for (Vehicle v : vehicles) {
			if (v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand)) {
				if (!v.getIsAvailable()) {
					flag = 1;
					v.setAvailable(true);
					System.out.println("Vehicle returned Successfully");
				} else {
					flag = 1;
					System.out.println("Vehicle already Returned or Vehicle not Rented.");
				}
			}
		}

		if (flag == 0) {
			System.out.println("Vehicle not found.");
		}
	}
}
