package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class VehicleDao {
    private final String connectionString;
    private final String userName;
    private final String password;

    public VehicleDao(String connectionString, String userName, String password) {
        this.connectionString = connectionString;
        this.userName = userName;
        this.password = password;
    }

    //CRUD functions
    //ReadAll (getAll), ReadById (getById), Update, Delete, Create
    public List<Vehicle> getAll() {
        List<Vehicle> list = new ArrayList<>();
        String query = "SELECT * FROM vehicles";

        //connect to the database
        //run our query
        //get back results and convert that to Java
        //return a list of products

        //try-with statement
        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            //loop through rows until you run out
            while (rs.next()) {
                //How do we grab the data from SQL?
                Vehicle newVehicle = new Vehicle();
                newVehicle.setVin(rs.getInt("vehicle_VIN"));
                newVehicle.setModel(rs.getString("name"));
                newVehicle.setVehicleType(rs.getString("type"));
                newVehicle.setMake(rs.getString("brand"));
                newVehicle.setYear(rs.getInt("year"));
                newVehicle.setColor(rs.getString("color"));
                newVehicle.setOdometer(rs.getInt("odometer"));
                newVehicle.setPrice(rs.getDouble("price"));

                list.add(newVehicle);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public Vehicle getByVin(int Vin) {
        String query = "SELECT * FROM vehicles WHERE vehicle_VIN = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query);) {

            stmt.setInt(1, Vin);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Vehicle newVehicle = new Vehicle();
                    newVehicle.setVin(rs.getInt("vehicle_VIN"));
                    newVehicle.setModel(rs.getString("name"));
                    newVehicle.setVehicleType(rs.getString("type"));
                    newVehicle.setMake(rs.getString("brand"));
                    newVehicle.setYear(rs.getInt("year"));
                    newVehicle.setColor(rs.getString("color"));
                    newVehicle.setOdometer(rs.getInt("odometer"));
                    newVehicle.setPrice(rs.getDouble("price"));

                    return newVehicle;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    //DELETE
    public void delete(int Vin) {
        String query = "DELETE FROM vehicles WHERE vehicle_VIN = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, Vin);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //CREATE
    public void create(Vehicle vehicle) {
        String query = "INSERT INTO vehicles (vehicle_VIN, name, type, brand, year, sold, color, odometer, price) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, vehicle.getVin());
            stmt.setString(2, vehicle.getModel());
            stmt.setString(3, vehicle.getVehicleType());
            stmt.setString(4, vehicle.getMake());
            stmt.setInt(5, vehicle.getYear());
            stmt.setBoolean(6, false);
            stmt.setString(7, vehicle.getColor());
            stmt.setInt(8, vehicle.getOdometer());
            stmt.setDouble(9, vehicle.getPrice());



            //exc. Remember, you don't need to set the id, let SQL do it
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //UPDATE
    public void update(Vehicle vehicle) {
        String query = "UPDATE vehicles SET name = ?, type = ?, brand = ?, sold = ? WHERE vehicle_VIN = ?";

        try (Connection conn = DriverManager.getConnection(connectionString, userName, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            //replace ? with actual data
            stmt.setString(1, vehicle.getModel());
            stmt.setString(2, vehicle.getVehicleType());
            stmt.setString(3, vehicle.getMake());
            stmt.setBoolean(4, false); // or vehicle.isSold() if tracking
            stmt.setInt(5, vehicle.getVin());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

