package com.litmus7.vehiclerentalsystem.service;

import com.litmus7.vehiclerentalsystem.dto.*;
import java.util.*;
import java.io.*;

public class VehicleService {

	public List<Vehicle> vehicles = new ArrayList<Vehicle>();

	public void loadVehiclesFromFile(String filename) {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				String type = data[0];

				if (type.equals("Car") == true) {
					String brand = data[1];
					String model = data[2];
					double rentalPrice = Double.parseDouble(data[3]);
					int numberOfDoors = Integer.parseInt(data[4]);
					boolean isAutomatic = Boolean.parseBoolean(data[5]);

					Car car = new Car(brand, model, rentalPrice, numberOfDoors, isAutomatic);
					vehicles.add(car);

				} else if (type.equals("Bike") == true) {
					String brand = data[1];
					String model = data[2];
					double rentalPrice = Double.parseDouble(data[3]);
					int engineCapacity = Integer.parseInt(data[5]);
					boolean hasGear = Boolean.parseBoolean(data[4]);

					Bike bike = new Bike(brand, model, rentalPrice, engineCapacity, hasGear);
					vehicles.add(bike);
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading file" + e.getMessage());
		}

	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
		// System.out.println("Vehicle Added");
	}

	public void displayAllVehicles() {
		for (Vehicle v : vehicles) {
			v.displayDetails();
			System.out.println("\n");
		}
	}

	public void searchVehicles(String keyword) {
		for (Vehicle v : vehicles) {
			if (v.getBrand().equalsIgnoreCase(keyword) || v.getModel().equalsIgnoreCase(keyword)) {
				v.displayDetails();
				System.out.println("\n");
			}
		}
	}

	public double calculateRental() {
		double total = 0.0;
		for (Vehicle v : vehicles) {
			total += v.getRentalPricePerDay();
		}
		return total;
	}

	public void rentVehicle(String model, String brand) {
		int flag = 0;
		for (Vehicle v : vehicles) {
			if (v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand) == true) {
				if (v.getIsAvailable() == true) {
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

	public void returnVehicle(String model, String brand) {
		int flag = 0;
		for (Vehicle v : vehicles) {
			if (v.getModel().equalsIgnoreCase(model) && v.getBrand().equalsIgnoreCase(brand)) {
				if (v.getIsAvailable() == false) {
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
