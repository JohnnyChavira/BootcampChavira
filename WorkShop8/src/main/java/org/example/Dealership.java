package org.example;

import java.util.ArrayList;

public class Dealership {
    String name;
    String address;
    String phone;

    ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //method to return list of vehicles wihtin price range
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> matches = new ArrayList<>();

        //loops through inventory & check if vehicle price is in range
        for(Vehicle vehicle : inventory) {
            if(vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                matches.add(vehicle);
            }
        }
        return matches;

    }

    // Returns list of vehicles by make & model
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> matches = new ArrayList<>();

        for(Vehicle vehicle : inventory) {
            if(vehicle.getModel().equalsIgnoreCase(model) && vehicle.getMake().equalsIgnoreCase(make)) {
                matches.add(vehicle);
            }
        }
        return matches;
    }

    // Returns list of vehicle's year range
    public ArrayList<Vehicle> getVehiclesByYear(int minYear, int maxYear) {
        ArrayList<Vehicle> matches = new ArrayList<>();

        for(Vehicle vehicle : inventory) {
            if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear) {
                matches.add(vehicle);
            }
        }
        return matches;

    }

    // Returns list of vehicles by color
    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> matches = new ArrayList<>();

        for(Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                matches.add(vehicle);
            }
        }

        return matches;
    }

    // Returns list of vehicles by mileage
    public ArrayList<Vehicle> getVehiclesByMileage(int minMileage, int maxMileage) {
        ArrayList<Vehicle> matches = new ArrayList<>();

        for(Vehicle vehicle : inventory) {
            if(vehicle.getOdometer() >= minMileage && vehicle.getOdometer() <= maxMileage) {
                matches.add(vehicle);
            }
        }
        return matches;
    }

    // Returns list of vehicle types
    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        ArrayList<Vehicle> matches = new ArrayList<>();

        for(Vehicle vehicle : inventory) {
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                matches.add(vehicle);

            }
        }
        return matches;
    }

    // Returns vehicles in inventory
    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    // Adds a vehicle to inventory
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    // Removes a vehicle from inventory
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

}

