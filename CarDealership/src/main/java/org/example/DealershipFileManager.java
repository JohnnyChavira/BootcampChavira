package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    public static Dealership getDealership() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"))) {
            String dealershipLine = bufferedReader.readLine();
            String[] dealershipData = dealershipLine.split("\\|");

            String name = dealershipData[0];
            String address = dealershipData[1];
            String phone = dealershipData[2];
            Dealership dealership = new Dealership(name, address, phone);

            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] row = input.split("\\|");

                int vin = Integer.parseInt(row[0]);
                int year = Integer.parseInt(row[1]);
                String make = row[2];
                String model = row[3];
                String type = row[4];
                String color = row[5];
                int odometer = Integer.parseInt(row[6]);
                double price = Double.parseDouble(row[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);

            }

            return dealership;



        } catch (
                IOException ex) {
            System.out.println("Failed to load csv file.");
            ex.printStackTrace();
            return null;

        }
    }
}