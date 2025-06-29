package com.litmus7.vehiclerentalsystem.service;

import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.dao.*;
import com.litmus7.vehiclerentalsystem.exception.*;
import java.util.*;

/**
 * Service class to manage a list of vehicles. 
 * Provides functionalities to load, add, remove, calculate rental, rent, and return vehicles.
 */
public class VehicleService {
	private List<Vehicle> vehiclelist = new ArrayList<Vehicle>();
	VehicleDaoFile dao = new VehicleDaoFile();

	/**
	 * Loads vehicles from the specified file and stores them in the vehicle list.
	 *
	 * @param filename The name of the file containing vehicle data.
	 * @return A list of vehicles loaded from the file.
	 * @throws VehicleServiceException If there's an issue accessing vehicle data.
	 */
	public List<Vehicle> getVehicle(String filename) throws VehicleServiceException {
		try {
			vehiclelist = dao.loadVehiclesFromFile(filename);
		} catch (VehicleDataAccessException e) {
			throw new VehicleServiceException(e.getLocalizedMessage(), e);
		}
		return vehiclelist;
	}

	/**
	 * Adds a vehicle to the list.
	 *
	 * @param vehicle The vehicle to be added.
	 * @throws VehicleServiceException If the vehicle is null.
	 */
	public void addVehicle(Vehicle vehicle) throws VehicleServiceException {
		if (vehicle == null) {
			throw new VehicleServiceException("No Vehicle to be Added.");
		}
		vehiclelist.add(vehicle);
	}

	/**
	 * Removes a vehicle from the list that matches the given brand and model.
	 *
	 * @param brand The brand of the vehicle to remove.
	 * @param model The model of the vehicle to remove.
	 * @throws VehicleServiceException If the vehicle is not found.
	 */
	public void removeVehicle(String brand, String model) throws VehicleServiceException {
		boolean found = false;
		Iterator<Vehicle> iterator = vehiclelist.iterator();
		while (iterator.hasNext()) {
			Vehicle v = iterator.next();
			if (v.getBrand().equalsIgnoreCase(brand) && v.getModel().equalsIgnoreCase(model)) {
				iterator.remove();
				found = true;
				break;
			}
		}
		if (!found) {
			throw new VehicleServiceException("No Vehicle as such Found");
		}
	}

	/**
	 * Calculates and returns the total rental price of all vehicles.
	 *
	 * @return Total rental price per day.
	 * @throws VehicleServiceException If there are no vehicles in the list.
	 */
	public double calculateRental() throws VehicleServiceException {
		if (vehiclelist == null || vehiclelist.isEmpty()) {
			throw new VehicleServiceException("No vehicles available to calculate rental.");
		}
		double total = 0.0;
		for (Vehicle vehicle : vehiclelist) {
			total += vehicle.getRentalPricePerDay();
		}
		return total;
	}

	/**
	 * Rents a vehicle by setting its availability to false if it's available.
	 *
	 * @param model Model name of the vehicle.
	 * @param brand Brand name of the vehicle.
	 * @return A message indicating the result of the rent attempt.
	 * @throws VehicleServiceException If the vehicle is not found or already rented.
	 */
	public String rentVehicle(String model, String brand) throws VehicleServiceException {
		if (model == null || brand == null) {
			throw new VehicleServiceException("Model and Brand cannot be empty or null.");
		}
		if (vehiclelist == null || vehiclelist.isEmpty()) {
			throw new VehicleServiceException("No vehicles available for rent.");
		}
		for (Vehicle vehicle : vehiclelist) {
			if (vehicle.getModel().equalsIgnoreCase(model) && vehicle.getBrand().equalsIgnoreCase(brand)) {
				if (vehicle.getIsAvailable()) {
					vehicle.setAvailable(false);
					return "Vehicle Rented Successfully";
				} else {
					return "Vehicle already Rented.";
				}
			}
		}
		throw new VehicleServiceException("Vehicle not found for renting.");
	}

	/**
	 * Returns a rented vehicle by setting its availability to true.
	 *
	 * @param model Model name of the vehicle.
	 * @param brand Brand name of the vehicle.
	 * @return A message indicating the result of the return attempt.
	 * @throws VehicleServiceException If the vehicle is not found or not rented.
	 */
	public String returnVehicle(String model, String brand) throws VehicleServiceException {
		if (model == null || brand == null) {
			throw new VehicleServiceException("Model and Brand cannot be empty or null.");
		}
		if (vehiclelist == null || vehiclelist.isEmpty()) {
			throw new VehicleServiceException("No vehicles in system to return.");
		}
		for (Vehicle vehicle : vehiclelist) {
			if (vehicle.getModel().equalsIgnoreCase(model) && vehicle.getBrand().equalsIgnoreCase(brand)) {
				if (!vehicle.getIsAvailable()) {
					vehicle.setAvailable(true);
					return "Vehicle Returned Successfully";
				} else {
					return "Vehicle already Returned or not Rented";
				}
			}
		}
		throw new VehicleServiceException("Vehicle not found for return.");
	}
}
