package org.example.Model.DAOClasses;

import org.example.Model.Classes.Airplane;
import org.example.Model.Classes.Bus;
import org.example.Model.Classes.Truck;
import org.example.Model.Classes.Vehicle;
import org.example.Model.DAOClasses.AbstractDAOClass;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class VehicleDAO extends AbstractDAOClass<Vehicle, Integer> {

    public VehicleDAO(DataSource dataSource) {
        super(dataSource);
    }

    private String getVehicleType(Vehicle vehicle) {
        if (vehicle instanceof Bus) {
            return "Bus";
        } else if (vehicle instanceof Airplane) {
            return "Airplane";
        } else if (vehicle instanceof Truck) {
            return "Truck";
        } else {
            return "Unknown";
        }
    }

    private void insertBus(Bus bus, int vehicleID) throws SQLException {
        String sql = "INSERT INTO Bus (seating_capacity, number_of_doors, fuel_type, vehicle_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, bus.getSeatingCapacity());
            stmt.setInt(2, bus.getNumberOfDoors());
            stmt.setString(3, bus.getFuelType());
            stmt.setInt(4, vehicleID);  // Usamos el vehicle_id generado
            stmt.executeUpdate();
        }
    }
    private void insertAirplane(Airplane airplane, int vehicleID) throws SQLException {
        String sql = "INSERT INTO Airplane (altitude, passenger_capacity, fuel_type, vehicle_id) VALUES (?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, airplane.getAltitude());
            stmt.setInt(2, airplane.getPassengerCapacity());
            stmt.setString(3, airplane.getFuelType());
            stmt.setInt(4, vehicleID);  // Usamos el vehicle_id generado
            stmt.executeUpdate();
        }
    }
    private void insertTruck(Truck truck, int vehicleID) throws SQLException {
        String sql = "INSERT INTO Truck (load_capacity, cabin_size, vehicle_id) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, truck.getLoadCapacity());
            stmt.setInt(2, truck.getCabinSize());
            stmt.setInt(3, vehicleID);  // Usamos el vehicle_id generado
            stmt.executeUpdate();
        }
    }

    @Override
    public void insert(Vehicle vehicle) throws SQLException {
        // First, insert general data into the Vehicle table
        String sqlVehicle = "INSERT INTO Vehicle (brand, model, vehicle_type) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement stmtVehicle = connection.prepareStatement(sqlVehicle, Statement.RETURN_GENERATED_KEYS)) {

            stmtVehicle.setString(1, vehicle.getBrand());
            stmtVehicle.setString(2, vehicle.getModel());
            stmtVehicle.setString(3, getVehicleType(vehicle));

            // Execute the insertion into the Vehicle table
            stmtVehicle.executeUpdate();

            // Retrieve the generated vehicle ID
            ResultSet generatedKeys = stmtVehicle.getGeneratedKeys();
            if (generatedKeys.next()) {
                int vehicleID = generatedKeys.getInt(1);

                // Now insert into the specific table depending on the vehicle type
                if (vehicle instanceof Bus) {
                    insertBus((Bus) vehicle, vehicleID);
                } else if (vehicle instanceof Airplane) {
                    insertAirplane((Airplane) vehicle, vehicleID);
                } else if (vehicle instanceof Truck) {
                    insertTruck((Truck) vehicle, vehicleID);
                } else {
                    throw new SQLException("Unknown vehicle type");
                }
            }
        }
    }


    @Override
    public Vehicle findById(Integer id) throws SQLException {
        String sql = "SELECT * FROM Vehicle WHERE id = ?";
        Vehicle vehicle = null;
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    vehicle = mapResultSetToEntity(rs);
                }
            }
        }
        return vehicle;
    }

    @Override
    public List<Vehicle> findAll() throws SQLException {
        String sql = "SELECT * FROM Vehicle";
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Vehicle vehicle = mapResultSetToEntity(rs);
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    @Override
    public void update(Vehicle vehicle) throws SQLException {
        String vehicleType = getVehicleType(vehicle);
        String sql = "UPDATE Vehicle SET brand = ?, model = ?, vehicle_type = ?, seating_capacity = ?, number_of_doors = ?, fuel_type = ?, altitude = ?, passenger_capacity = ?, load_capacity = ?, cabin_size = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, vehicle.getBrand());
            stmt.setString(2, vehicle.getModel());
            stmt.setString(3, vehicleType);

            switch (vehicleType) {
                case "Bus":
                    Bus bus = (Bus) vehicle;
                    stmt.setInt(4, bus.getSeatingCapacity());
                    stmt.setInt(5, bus.getNumberOfDoors());
                    stmt.setString(6, bus.getFuelType());
                    stmt.setNull(7, Types.INTEGER);  // No es un Airplane
                    stmt.setNull(8, Types.INTEGER);  // No es un Airplane
                    stmt.setNull(9, Types.INTEGER);  // No es un Truck
                    stmt.setNull(10, Types.INTEGER); // No es un Truck
                    break;
                case "Airplane":
                    Airplane airplane = (Airplane) vehicle;
                    stmt.setNull(4, Types.INTEGER);  // No es un Bus
                    stmt.setNull(5, Types.INTEGER);  // No es un Bus
                    stmt.setString(6, airplane.getFuelType());
                    stmt.setInt(7, airplane.getAltitude());
                    stmt.setInt(8, airplane.getPassengerCapacity());
                    stmt.setNull(9, Types.INTEGER);  // No es un Truck
                    stmt.setNull(10, Types.INTEGER); // No es un Truck
                    break;
                case "Truck":
                    Truck truck = (Truck) vehicle;
                    stmt.setNull(4, Types.INTEGER);  // No es un Bus
                    stmt.setNull(5, Types.INTEGER);  // No es un Bus
                    stmt.setNull(6, Types.VARCHAR);  // No es un Airplane
                    stmt.setNull(7, Types.INTEGER);  // No es un Airplane
                    stmt.setNull(8, Types.INTEGER);  // No es un Airplane
                    stmt.setInt(9, truck.getLoadCapacity());
                    stmt.setInt(10, truck.getCabinSize());
                    break;
            }

            stmt.setInt(11, vehicle.getVehicleID());  // Usamos el ID para actualizar
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM Vehicle WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
    private Bus getBusDetails(int vehicleID, String brand, String model) throws SQLException {
        String sql = "SELECT * FROM Bus WHERE vehicle_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, vehicleID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int seatingCapacity = rs.getInt("seating_capacity");
                    int numberOfDoors = rs.getInt("number_of_doors");
                    String fuelType = rs.getString("fuel_type");

                    // Crear y devolver el objeto Bus
                    return new Bus(vehicleID, brand, model, vehicleID, seatingCapacity, numberOfDoors, fuelType, new ArrayList<>());
                }
            }
        }
        throw new SQLException("Bus not found for vehicle ID: " + vehicleID);
    }

    private Airplane getAirplaneDetails(int vehicleID, String brand, String model) throws SQLException {
        String sql = "SELECT * FROM Airplane WHERE vehicle_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, vehicleID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int altitude = rs.getInt("altitude");
                    int passengerCapacity = rs.getInt("passenger_capacity");
                    String fuelType = rs.getString("fuel_type");

                    // Crear y devolver el objeto Airplane
                    return new Airplane(vehicleID, brand, model, vehicleID, altitude, passengerCapacity, fuelType);
                }
            }
        }
        throw new SQLException("Airplane not found for vehicle ID: " + vehicleID);
    }

    private Truck getTruckDetails(int vehicleID, String brand, String model) throws SQLException {
        String sql = "SELECT * FROM Truck WHERE vehicle_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, vehicleID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int loadCapacity = rs.getInt("load_capacity");
                    int cabinSize = rs.getInt("cabin_size");

                    // Crear y devolver el objeto Truck
                    return new Truck(vehicleID, brand, model, vehicleID, loadCapacity, cabinSize);
                }
            }
        }
        throw new SQLException("Truck not found for vehicle ID: " + vehicleID);
    }



    @Override
    protected Vehicle mapResultSetToEntity(ResultSet rs) throws SQLException {
        int vehicleID = rs.getInt("id");
        String brand = rs.getString("brand");
        String model = rs.getString("model");
        String vehicleType = rs.getString("vehicle_type");

        switch (vehicleType) {
            case "Bus":
                // Ejecuta una consulta separada para obtener los detalles del Bus
                return getBusDetails(vehicleID, brand, model);

            case "Airplane":
                // Ejecuta una consulta separada para obtener los detalles del Airplane
                return getAirplaneDetails(vehicleID, brand, model);

            case "Truck":
                // Ejecuta una consulta separada para obtener los detalles del Truck
                return getTruckDetails(vehicleID, brand, model);

            default:
                throw new SQLException("Unknown vehicle type: " + vehicleType);
        }
    }

    @Override
    protected String getFindByIdQuery() {
        return "SELECT * FROM Vehicle WHERE id = ?";
    }

    @Override
    protected String getFindAllQuery() {
        return "SELECT * FROM Vehicle";
    }

    @Override
    protected String getDeleteQuery() {
        return "DELETE FROM Vehicle WHERE id = ?";
    }

    @Override
    protected void setIdInStatement(PreparedStatement stmt, Integer id) throws SQLException {
        stmt.setInt(1, id);
    }
}
