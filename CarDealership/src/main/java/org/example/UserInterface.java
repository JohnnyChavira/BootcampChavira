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
    private void processGetByPriceRequest() {}
    private void processGetByMakeModelRequest() {}
    private void processGetByYearRequest() {}
    private void processGetByColorRequest() {}
    private void processGetByMileageRequest() {}
    private void processGetByVehicleTypeRequest() {}
    private void processAddVehicleRequest() {}
    private void processRemoveVehicleRequest() {}
}

