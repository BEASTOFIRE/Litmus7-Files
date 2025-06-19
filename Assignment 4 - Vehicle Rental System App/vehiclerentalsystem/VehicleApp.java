package com.litmus7.vehiclerentalsystem;

import java.util.Scanner;

/**
 * 
 */
class Vehicle {

    private String brand;
    private String model;
    private double rentalPricePerDay;
    static Scanner sc = new Scanner(System.in);  
    // Parameterized constructor
    /**
     * @param brand
     * @param model
     * @param rentalPricePerDay
     */
    public Vehicle(String brand, String model, double rentalPricePerDay) {
        this.brand = brand;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    // Input details
    public void inputDetails() {
        System.out.println("Enter Brand Name: ");
        brand = sc.nextLine();
        System.out.println("Enter Model Name: ");
        model = sc.nextLine();
        System.out.println("Enter Rental Price Per Day: ");
        rentalPricePerDay = sc.nextDouble();
    }

    // Display details
    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Rental Price Per Day: " + rentalPricePerDay);
    }
}

/**
 * 
 */
class Car extends Vehicle {

    private int numberOfDoors;
    private boolean isAutomatic;

    // Default constructor with Car specific values
    /**
     * 
     */
    public Car() {
        super("Honda", "Civic", 1400);
        this.numberOfDoors = 4;
        this.isAutomatic = false;
    }

    // Parameterized constructor
    /**
     * @param brand
     * @param model
     * @param rentalPricePerDay
     * @param numberOfDoors
     * @param isAutomatic
     */
    public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
        super(brand, model, rentalPricePerDay);
        this.numberOfDoors = numberOfDoors;
        this.isAutomatic = isAutomatic;
    }

    
    /**
     *
     */
    public void inputDetails() {
        System.out.println("--- Enter Car Details ---");
        super.inputDetails();
        System.out.println("Enter Number of Doors: ");
        numberOfDoors = sc.nextInt();
        System.out.println("Is it Automatic (true/false)? ");
        isAutomatic = sc.nextBoolean();
        sc.nextLine();
        System.out.println("\n");
    }

    /**
     *
     */
    public void displayDetails() {
        System.out.println("--- Car Details ---");
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Is Automatic: " + isAutomatic+"\n");
    }
}

class Bike extends Vehicle {

    private int engineCapacity;
    private boolean hasGear;

    // Default constructor with Bike specific values
    /**
     * 
     */
    public Bike() {
        super("Suzuki", "Gixxer", 600);
        this.engineCapacity = 125;
        this.hasGear = false;
    }

    // Parameterized constructor
    /**
     * @param brand
     * @param model
     * @param rentalPricePerDay
     * @param engineCapacity
     * @param hasGear
     */
    public Bike(String brand, String model, double rentalPricePerDay, int engineCapacity, boolean hasGear) {
        super(brand, model, rentalPricePerDay);
        this.engineCapacity = engineCapacity;
        this.hasGear = hasGear;
    }

    /**
     *
     */
    public void inputDetails() {
        System.out.println("--- Enter Bike Details ---");
        super.inputDetails();
        System.out.println("Enter Engine Capacity: ");
        engineCapacity = sc.nextInt();
        System.out.println("Does it have gears (true/false)? ");
        hasGear = sc.nextBoolean();
        sc.nextLine();
        System.out.println("\n");
    }

    /**
     *
     */
    public void displayDetails() {
        System.out.println("--- Bike Details ---");
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity);
        System.out.println("Has Gear: " + hasGear+"\n");
    }
}

/**
 * 
 */
public class VehicleApp {

    /**
     * @param args
     */
    public static void main(String[] args) {

        // Creating Car objects
        Car car1 = new Car();
        Car car2 = new Car("Tata", "Punch", 1000, 4, true);
        Car car3 = new Car();

        // Creating Bike objects
        Bike bike1 = new Bike();
        Bike bike2 = new Bike("Royal Enfield", "Himalayan", 700, 411, true);
        Bike bike3 = new Bike();

        // Input details for car3 and bike3
        car3.inputDetails();
        bike3.inputDetails();

        // Display all car details
        car1.displayDetails();
        car2.displayDetails();
        car3.displayDetails();

        // Display all bike details
        bike1.displayDetails();
        bike2.displayDetails();
        bike3.displayDetails();
    }
}
