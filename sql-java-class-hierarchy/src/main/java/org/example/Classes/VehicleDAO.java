package org.example.Classes;
import java.sql.*;
import java.util.List;
import javax.sql.DataSource;
import java.util.ArrayList;
public class VehicleDAO extends AbstractDAOClass<Vehicle, Integer>
{
    public VehicleDAO(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public void insert(Vehicle vehicle) throws SQLException {
        String sql = "INSERT INTO Vehicle (brand, model) VALUES (?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, vehicle.getBrand());
            stmt.setString(2, vehicle.getModel());
            stmt.executeUpdate();
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
                    vehicle = new Vehicle(rs.getInt("id"), rs.getString("brand"), rs.getString("model"));
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
                Vehicle vehicle = new Vehicle(rs.getInt("id"), rs.getString("brand"), rs.getString("model"));
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    @Override
    public void update(Vehicle vehicle) throws SQLException {
        String sql = "UPDATE Vehicle SET brand = ?, model = ? WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, vehicle.getBrand());
            stmt.setString(2, vehicle.getModel());
            stmt.setInt(3, vehicle.getId());
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
    // Implementamos el método mapResultSetToEntity
    @Override
    protected Vehicle mapResultSetToEntity(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String brand = rs.getString("brand");
        String model = rs.getString("model");
        return new Vehicle(id, brand, model);
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