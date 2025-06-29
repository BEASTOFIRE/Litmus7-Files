package com.litmus7.vehiclerentalsystem.dao;

import com.litmus7.vehiclerentalsystem.exception.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.litmus7.vehiclerentalsystem.dto.Bike;
import com.litmus7.vehiclerentalsystem.dto.Car;
import com.litmus7.vehiclerentalsystem.dto.Vehicle;

public class VehicleDaoFile {

	static Scanner sc = new Scanner(System.in);

	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	/**
	 * Loads vehicles from a file into the vehicles list. Each line in the file
	 * should represent a vehicle with comma-separated values.
	 */
	public List<Vehicle> loadVehiclesFromFile(String filename) throws VehicleDataAccessException {
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
		} catch (FileNotFoundException e) {
			throw new VehicleDataAccessException("Error reading file: " + e.getLocalizedMessage(), e);
		} catch (IOException e) {
			throw new VehicleDataAccessException("Error reading file: " + e.getLocalizedMessage(), e);
		}
		return vehicles;
	}

}
