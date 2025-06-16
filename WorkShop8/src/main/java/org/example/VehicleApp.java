package org.example;

import java.util.List;
import java.util.Scanner;

public class VehicleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleDao dao = new VehicleDao("jdbc:mysql://localhost:3306/cardealership", "root", "YU_oppdivide!2020");

        boolean running = true;

        while (running) {
            System.out.println("\n--- Vehicle Inventory Menu ---");
            System.out.println("1. View all vehicles");
            System.out.println("2. Add a vehicle");
            System.out.println("3. Remove a vehicle");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    List<Vehicle> vehicles = dao.getAll();
                    if (vehicles.isEmpty()) {
                        System.out.println("No vehicles found.");
                    } else {
                        for (Vehicle v : vehicles) {
                            System.out.println(v);
                        }
                    }
                    break;

                case "2":
                    System.out.print("Enter VIN: ");
                    int vin = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter Odometer: ");
                    int odometer = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Price: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Vehicle newVehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                    dao.create(newVehicle);
                    System.out.println("Vehicle added.");
                    break;

                case "3":
                    System.out.print("Enter VIN to remove: ");
                    int vinToRemove = Integer.parseInt(scanner.nextLine());
                    dao.delete(vinToRemove);
                    System.out.println("Vehicle removed.");
                    break;

                case "4":
                    running = false;
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }
}
