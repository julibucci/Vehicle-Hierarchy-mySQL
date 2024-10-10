package org.example;
import org.example.Classes.Vehicle;
import javax.sql.DataSource;
import org.example.Classes.ConnectionPool;
import org.example.Classes.VehicleDAO;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        DataSource dataSource = ConnectionPool.getDataSource();
        VehicleDAO vehicleDAO = new VehicleDAO(dataSource);

        try {
            // Insert a new vehicle
            Vehicle vehicle = new Vehicle(0, "Toyota", "Corolla");
            vehicleDAO.insert(vehicle);

            // Retrieve and print vehicle
            Vehicle retrievedVehicle = vehicleDAO.findById(1);
            System.out.println("Vehicle: " + retrievedVehicle.getBrand() + " " + retrievedVehicle.getModel());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
