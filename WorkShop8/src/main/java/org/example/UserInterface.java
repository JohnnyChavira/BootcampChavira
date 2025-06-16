package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {
        init();
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    public void display() {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            displayMenu();
            int option = getUserInput(scanner);

            switch (option) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 99 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }

        System.out.println("Exiting system.");
    }

    private void displayMenu() {
        System.out.println("\n==== Dealership Menu ====");
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make/model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("Enter your choice: ");
    }

    private int getUserInput(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void processAllVehiclesRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    // Empty stubs for now, to be implemented in Phase 5
    private void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum price: ");
        double minPrice = Double.parseDouble(scanner.nextLine());

        System.out.print("Enter maximum price: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());

        List<Vehicle> results = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(results);
    }

    private void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter make: ");
        String make = scanner.nextLine().trim();

        System.out.print("Enter model: ");
        String model = scanner.nextLine().trim();

        List<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(results);
    }

    private void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter minimum year: ");
        int minYear = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Enter maximum year: ");
        int maxYear = Integer.parseInt(scanner.nextLine().trim());

        List<Vehicle> results = dealership.getVehiclesByYear(minYear, maxYear);
        displayVehicles(results);
    }

    private void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine().trim();

        List<Vehicle> results = dealership.getVehiclesByColor(color);
        displayVehicles(results);
    }

    private void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter minimum mileage: ");
            int minMileage = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter maximum mileage: ");
            int maxMileage = Integer.parseInt(scanner.nextLine());

            List<Vehicle> results = dealership.getVehiclesByMileage(minMileage, maxMileage);
            displayVehicles(results);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }

    private void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter vehicle type (e.g., SUV, Sedan, Truck, etc.): ");
        String type = scanner.nextLine().trim();

        List<Vehicle> results = dealership.getVehiclesByType(type);
        displayVehicles(results);
    }

    private void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter VIN: ");
            int vin = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Year: ");
            int year = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Make: ");
            String make = scanner.nextLine();

            System.out.print("Enter Model: ");
            String model = scanner.nextLine();

            System.out.print("Enter Vehicle Type: ");
            String type = scanner.nextLine();

            System.out.print("Enter Color: ");
            String color = scanner.nextLine();

            System.out.print("Enter Odometer Reading: ");
            int odometer = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Price: ");
            double price = Double.parseDouble(scanner.nextLine());

            Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
            dealership.addVehicle(vehicle);

            // Save to inventory
            DealershipFileManager.saveDealership(dealership);

            System.out.println("Vehicle added successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values where required.");
        }
    }

    private void processRemoveVehicleRequest() {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the VIN of the vehicle to remove
        System.out.print("Enter the VIN of the vehicle to remove: ");
        int vinToRemove = Integer.parseInt(scanner.nextLine());

        // Find the vehicle with the specified VIN
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vinToRemove) {
                vehicleToRemove = vehicle;
                break;
            }
        }

        // If the vehicle exists, remove it from the dealership
        if (vehicleToRemove != null) {
            dealership.getAllVehicles().remove(vehicleToRemove);
            DealershipFileManager.saveDealership(dealership); // Save the updated dealership to the CSV
            System.out.println("Vehicle with VIN " + vinToRemove + " removed successfully.");
        } else {
            System.out.println("No vehicle found with VIN: " + vinToRemove);
        }
    }
}

