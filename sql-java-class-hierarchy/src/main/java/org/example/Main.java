package org.example;
import org.example.Classes.Vehicle;
import javax.sql.DataSource;
import org.example.Classes.ConnectionPool;
import org.example.Classes.VehicleDAO;
import java.sql.SQLException;
import org.example.Interfaces.IGenericDAO;
import org.example.Classes.VehicleServiceImpl;

public class Main {
    public static void main(String[] args) {

        DataSource dataSource = ConnectionPool.getDataSource();
        IGenericDAO<Vehicle, Integer> vehicleDAO = new VehicleDAO(dataSource);  // Usamos el DAO genérico
        VehicleServiceImpl vehicleService = new VehicleServiceImpl(vehicleDAO);

        try {
            // Insertar un nuevo vehiculo
            Vehicle vehicle = new Vehicle(0, "Toyota", "Corolla");
            vehicleService.addVehicle(vehicle);

            // Recuperar y mostrar el vehiculo insertado
            Vehicle retrievedVehicle = vehicleService.getVehicleById(1);
            if (retrievedVehicle != null) {
                System.out.println("Vehicle: " + retrievedVehicle.getBrand() + " " + retrievedVehicle.getModel());
            }

            // Actualizar el vehiculo
            retrievedVehicle.setBrand("Honda");
            vehicleService.updateVehicle(retrievedVehicle);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
