package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Creates instance of ContractFileManager to do contract saving
        ContractFileManager manager = new ContractFileManager();

        //Creates instance of InventoryFileManager to load & manage inventory
        Dealership dealership = DealershipFileManager.getDealership();
        List<Vehicle> inventory = dealership.getAllVehicles();

        //starts loop to display main menu to user
        while (true) {
            //Menu options for user to choose
            System.out.println(" Vehicle Contract Menu ");
            System.out.println("------------------------");
            System.out.println("1. Create Sales Contract");
            System.out.println("2. Create Lease Contract");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            //Reads user's choice from input
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                // SALES CONTRACT
                System.out.println("Available vehicles:");

                //Displays available vehicles in inventory
                for (int i = 0; i < inventory.size(); i++) {
                    Vehicle v = inventory.get(i);
                    System.out.println((i + 1) + ". " + v.getYear() + " " + v.getMake() + " " +
                            v.getModel() + " ($" + v.getPrice() + ")");
                }

                //Asks user to choose vehicle from list
                System.out.print("Choose a vehicle by number: ");
                int vehicleIndex = Integer.parseInt(scanner.nextLine()) - 1;

                //Validates vehicle selection within the range
                if (vehicleIndex < 0 || vehicleIndex >= inventory.size()) {
                    System.out.println("Invalid selection.\n");
                    continue;//If selection is not there, restarts loop
                }

                //Retrieves selected vehicle from inventory
                Vehicle vehicle = inventory.get(vehicleIndex);

                //Detailed info for contract
                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Enter customer name: ");
                String name = scanner.nextLine();
                System.out.print("Enter customer email: ");
                String email = scanner.nextLine();
                System.out.print("Will this be financed? (yes/no): ");
                boolean finance = scanner.nextLine().equalsIgnoreCase("yes");

                //Creates SalesContract using input from user
                SalesContract contract = new SalesContract(date, name, email, vehicle, finance);
                manager.saveContract(contract);//saves contract
                System.out.println("Sales contract saved.\n");
                inventory.remove(vehicle);
                DealershipFileManager.saveDealership(dealership);

            } else if (choice.equals("2")) {
                // LEASE CONTRACT
                System.out.println("Available vehicles:");
                for (int i = 0; i < inventory.size(); i++) {
                    Vehicle v = inventory.get(i);
                    System.out.println((i + 1) + ". " + v.getYear() + " " + v.getMake() + " " + v.getModel() + " ($" + v.getPrice() + ")");
                }

                System.out.print("Choose a vehicle by number: ");
                int vehicleIndex = Integer.parseInt(scanner.nextLine()) - 1;

                //Validates vehicle selection within range
                if (vehicleIndex < 0 || vehicleIndex >= inventory.size()) {
                    System.out.println("Invalid selection.\n");
                    continue;
                }

                Vehicle vehicle = inventory.get(vehicleIndex);
                System.out.print("Enter date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                System.out.print("Enter customer name: ");
                String name = scanner.nextLine();
                System.out.print("Enter customer email: ");
                String email = scanner.nextLine();

                LeaseContract contract = new LeaseContract(date, name, email, vehicle);
                manager.saveContract(contract);
                System.out.println("Lease contract saved.\n");
                inventory.remove(vehicle);
                DealershipFileManager.saveDealership(dealership);

            } else if (choice.equals("3")) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.\n");
            }
        }

        scanner.close();
    }
}

