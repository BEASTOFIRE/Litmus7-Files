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

/**
 * Data Access Object (DAO) class for vehicle data management. Handles
 * file-based operations such as loading vehicles from a file.
 */
public class VehicleDaoFile {

	/**
	 * Scanner object for future input handling (not currently used in this class).
	 */
	static Scanner sc = new Scanner(System.in);

	/** Internal list to store vehicle objects loaded from file. */
	private List<Vehicle> vehicles = new ArrayList<Vehicle>();

	/**
	 * Loads vehicle data from a given file. Each line in the file is expected to be
	 * in CSV format representing either a Car or a Bike.
	 * 
	 * Car format: Car,brand,model,pricePerDay,numberOfDoors,isAutomatic Bike
	 * format: Bike,brand,model,pricePerDay,hasGear,engineCapacity
	 *
	 * @param filename The name of the file containing vehicle data.
	 * @return List of Vehicle objects (Car and Bike) parsed from the file.
	 * @throws VehicleDataAccessException if file reading fails or data is
	 *                                    malformed.
	 */
	public List<Vehicle> loadVehiclesFromFile(String filename) throws VehicleDataAccessException {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");

				if (data.length < 6) {
					throw new VehicleDataAccessException("Invalid data format: " + line);
				}

				String type = data[0].trim();

				if (type.equalsIgnoreCase("Car")) {
					try {
						String brand = data[1].trim();
						String model = data[2].trim();
						double rentalPrice = Double.parseDouble(data[3].trim());
						int numberOfDoors = Integer.parseInt(data[4].trim());
						boolean isAutomatic = Boolean.parseBoolean(data[5].trim());

						Car car = new Car(brand, model, rentalPrice, numberOfDoors, isAutomatic);
						vehicles.add(car);
					} catch (NumberFormatException e) {
						throw new VehicleDataAccessException("Error parsing Car data: " + line, e);
					}

				} else if (type.equalsIgnoreCase("Bike")) {
					try {
						String brand = data[1].trim();
						String model = data[2].trim();
						double rentalPrice = Double.parseDouble(data[3].trim());
						boolean hasGear = Boolean.parseBoolean(data[4].trim());
						int engineCapacity = Integer.parseInt(data[5].trim());

						Bike bike = new Bike(brand, model, rentalPrice, engineCapacity, hasGear);
						vehicles.add(bike);
					} catch (NumberFormatException e) {
						throw new VehicleDataAccessException("Error parsing Bike data: " + line, e);
					}

				} else {
					throw new VehicleDataAccessException("Unknown vehicle type: " + type);
				}
			}

		} catch (FileNotFoundException e) {
			throw new VehicleDataAccessException("File not found: " + filename, e);
		} catch (IOException e) {
			throw new VehicleDataAccessException("I/O error while reading file: " + e.getMessage(), e);
		}

		return vehicles;
	}

}
