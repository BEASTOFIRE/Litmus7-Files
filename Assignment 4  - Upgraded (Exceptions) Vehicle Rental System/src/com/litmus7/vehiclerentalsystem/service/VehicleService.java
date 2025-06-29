package com.litmus7.vehiclerentalsystem.service;

import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.dao.*;
import com.litmus7.vehiclerentalsystem.exception.*;
import java.util.*;

/**
 * Service class to manage a list of vehicles. Provides functionalities to load,
 * add, display, search, rent, and return vehicles.
 */
public class VehicleService {
	private List<Vehicle> vehiclelist = new ArrayList<Vehicle>();
	VehicleDaoFile dao = new VehicleDaoFile();

	public List<Vehicle> getVehicle(String filename) throws VehicleServiceException {
		try {
			vehiclelist = dao.loadVehiclesFromFile(filename);
		} catch (VehicleDataAccessException e) {
			throw new VehicleServiceException(e.getLocalizedMessage(), e);
		}
		return vehiclelist;
	}

	public void addVehicle(Vehicle vehicle) throws VehicleServiceException {
		if (vehicle == null) {
			throw new VehicleServiceException("No Vehicle to be Added.");
		}
		vehiclelist.add(vehicle);
	}
	
	public void removeVehicle(String brand, String model) throws VehicleServiceException{
		boolean found=false;
		Iterator<Vehicle> iterator = vehiclelist.iterator();
		while (iterator.hasNext()) {
		    Vehicle v = iterator.next();
		    if (v.getBrand().equalsIgnoreCase(brand) && v.getModel().equalsIgnoreCase(model)) {
		        iterator.remove(); // ✅ Safe and intended way to remove during iteration
		        found = true;
		        break; // remove only the first match
		    }
		}
		if(found==false) {
			throw new VehicleServiceException("No Vehicle as such Found");
		}
	}
	/**
	 * Calculates and returns the total rental price of all vehicles.
	 * 
	 * @return Total rental price per day.
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
	 * Rents a vehicle by setting its availability to false if found and available.
	 * 
	 * @param model Model name of the vehicle.
	 * @param brand Brand name of the vehicle.
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
	 * Returns a rented vehicle by setting its availability to true if found and not
	 * already available.
	 * 
	 * @param model Model name of the vehicle.
	 * @param brand Brand name of the vehicle.
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