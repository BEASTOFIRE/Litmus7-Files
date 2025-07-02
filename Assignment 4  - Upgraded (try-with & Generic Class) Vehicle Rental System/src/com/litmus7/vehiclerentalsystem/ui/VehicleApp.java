package com.litmus7.vehiclerentalsystem.ui;

import com.litmus7.vehiclerentalsystem.controller.VehicleController;
import com.litmus7.vehiclerentalsystem.dao.VehicleDaoFile;
import com.litmus7.vehiclerentalsystem.dto.*;
import com.litmus7.vehiclerentalsystem.service.VehicleService;

/**
 * Entry point of the Vehicle Rental System application.
 * Handles user interaction via console and delegates actions to the controller.
 */
public class VehicleApp {

    /**
     * Main method that drives the console-based vehicle rental system.
     * It performs the following actions in sequence:
     * 1. Loads vehicle data from file.
     * 2. Adds a new vehicle based on user input.
     * 3. Removes a vehicle.
     * 4. Rents a vehicle.
     * 5. Calculates the total rental price.
     * 6. Returns a rented vehicle.
     *
     * @param args Command-line arguments (not used here).
     */
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

        System.out.println("Remove a Vehicle: \n\n" + "Enter Vehicle brand:");
        String brand = control.sc.nextLine();
        System.out.println("Enter Vehicle model:");
        String model = control.sc.nextLine();
        response = control.removeVehicle(brand, model);
        System.out.println(response.getMessage());
        System.out.println(response.getData());

        System.out.println("\n Rent a Vehicle: \n\n" + "Enter Vehicle brand:");
        brand = control.sc.nextLine();
        System.out.println("Enter Vehicle model:");
        model = control.sc.nextLine();
        response = control.rentVehicle(model, brand);
        System.out.println(response.getMessage());
        System.out.println(response.getData());

        System.out.println("\n Calculate total rent: \n\n");
        response = control.calculateTotalRental();
        System.out.println(response.getMessage());
        System.out.println(response.getData());

        System.out.println("\n Return a Vehicle: \n\n" + "Enter Vehicle brand:");
        brand = control.sc.nextLine();
        System.out.println("Enter Vehicle model:");
        model = control.sc.nextLine();
        response = control.returnVehicle(model, brand);
        System.out.println(response.getMessage());
        System.out.println(response.getData());
    }
}
