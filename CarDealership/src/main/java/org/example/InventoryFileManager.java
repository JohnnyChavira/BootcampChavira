package org.example;
import java.io.*;
import java.util.*;

public class InventoryFileManager {
    //Method loader of vehicle inventory from CSV file
    public List<Vehicle> loadInventory() {
        List<Vehicle> vehicles = new ArrayList<>();//List storing vehicles
        String fileName = "inventory.csv";//Defines file

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            //reads each line in CSV file
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");//splits lines by parts

                //Takes each for the vehicle
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                vehicles.add(vehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();//If an exception occurs
        }

        return vehicles;
    }

    public void saveInventory(List<Vehicle> vehicles) {
        String fileName = "inventory.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Vehicle v : vehicles) {
                writer.write(vehicleToCSV(v));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //converts vehicle to CSV
    private String vehicleToCSV(Vehicle v) {
       //returns all vehicle properties into CSV strings
        return v.getVin() + "," +
                v.getYear() + "," +
                v.getMake() + "," +
                v.getModel() + "," +
                v.getVehicleType() + "," +
                v.getColor() + "," +
                v.getOdometer() + "," +
                v.getPrice();
    }
}
