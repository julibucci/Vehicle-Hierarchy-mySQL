package org.example.Classes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public class AbstractDAOClass<T, ID> implements IGenericDAO<T.ID>
{
    private DataSource dataSource;

    public AbstractDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public Optional<T> findById(ID id) {
        try (Connection conn = getConnection()) {
            return mapResultSet(executeFindById(conn, id));
        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<T> findAll() {
        try (Connection conn = getConnection()) {
            return mapToList(executeFindAll(conn));
        } catch (SQLException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    @Override
    public void save(T entity) {
        try (Connection conn = getConnection()) {
            executeSave(conn, entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(T entity) {
        try (Connection conn = getConnection()) {
            executeUpdate(conn, entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {
        try (Connection conn = getConnection()) {
            executeDelete(conn, entity);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(ID id) {
        try (Connection conn = getConnection()) {
            executeDeleteById(conn, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract PreparedStatement executeFindById(Connection conn, ID id) throws SQLException;
    protected abstract PreparedStatement executeFindAll(Connection conn) throws SQLException;
    protected abstract void executeSave(Connection conn, T entity) throws SQLException;
    protected abstract void executeUpdate(Connection conn, T entity) throws SQLException;
    protected abstract void executeDelete(Connection conn, T entity) throws SQLException;
    protected abstract void executeDeleteById(Connection conn, ID id) throws SQLException;

    protected abstract Optional<T> mapResultSet(ResultSet rs) throws SQLException;
    protected abstract List<T> mapToList(ResultSet rs) throws SQLException;
}

