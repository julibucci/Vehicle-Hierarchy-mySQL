package org.example.Model;
import org.example.Interfaces.IGenericDAO;
import org.example.Model.Classes.Vehicle;

import java.sql.SQLException;
import java.util.List;

public class VehicleServiceImpl
{
    private final IGenericDAO<Vehicle, Integer> vehicleDAO;

    // Constructor que recibe un DAO generico
    public VehicleServiceImpl(IGenericDAO<Vehicle, Integer> vehicleDAO) {
        this.vehicleDAO = vehicleDAO;
    }

    public void addVehicle(Vehicle vehicle) throws SQLException {
        vehicleDAO.insert(vehicle);
    }

    public Vehicle getVehicleById(int id) throws SQLException {
        return vehicleDAO.findById(id);
    }

    public List<Vehicle> getAllVehicles() throws SQLException {
        return vehicleDAO.findAll();
    }

    public void updateVehicle(Vehicle vehicle) throws SQLException {
        vehicleDAO.update(vehicle);
    }

    public void removeVehicle(int id) throws SQLException {
        vehicleDAO.delete(id);
    }
}
