package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class ContractFileManager {

    public void saveContract(Contract contract) {
        String fileName = "contract.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {

            String csvLine = contractToCSV(contract);
            writer.write(csvLine);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String contractToCSV(Contract contract) {
        // Get the vehicle object from the contract
        Vehicle vehicle = contract.getVehicle();

        // Convert Contract fields and Vehicle fields into CSV format
        return contract.getDate() + "," +
                contract.getCustomerName() + "," +
                contract.getCustomerEmail() + "," +
                vehicleToCSV(vehicle);
    }

    // Helper method to convert Vehicle object into CSV format
    private String vehicleToCSV(Vehicle vehicle) {
        // Convert the fields of the Vehicle object into a CSV string
        return vehicle.getVin() + "," +
                vehicle.getYear() + "," +
                vehicle.getMake() + "," +
                vehicle.getModel() + "," +
                vehicle.getVehicleType() + "," +
                vehicle.getColor() + "," +
                vehicle.getOdometer() + "," +
                vehicle.getPrice();
    }
}