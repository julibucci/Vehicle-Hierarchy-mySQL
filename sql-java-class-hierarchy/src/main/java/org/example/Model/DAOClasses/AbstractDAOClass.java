package org.example.Model.DAOClasses;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.example.Interfaces.IGenericDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class AbstractDAOClass<T, K> implements IGenericDAO<T,K>
{
    protected DataSource dataSource;

    public AbstractDAOClass(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected Connection getConnection() throws SQLException {
        return dataSource.getConnection(); // Usamos el pool de conexiones
    }

    // Metodo generico para encontrar por ID, que sera llamado por las clases especificas del DAO
    @Override
    public T findById(K id) throws SQLException {
        String sql = getFindByIdQuery();
        T entity = null;
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            setIdInStatement(stmt, id);  // Metodo que cada DAO debe implementar para personalizar el ID
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    entity = mapResultSetToEntity(rs);  // Metodo que mapea el resultado
                }
            }
        }
        return entity;
    }

    // Metodo generico para encontrar todas las entidades
    @Override
    public List<T> findAll() throws SQLException {
        String sql = getFindAllQuery();
        List<T> entities = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                entities.add(mapResultSetToEntity(rs));  // Mapeamos cada fila del ResultSet a la entidad correspondiente
            }
        }
        return entities;
    }

    // Método generico para eliminar una entidad por ID
    @Override
    public void delete(K id) throws SQLException {
        String sql = getDeleteQuery();
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            setIdInStatement(stmt, id);  // Usamos el metodo para personalizar la sentencia SQL con el ID
            stmt.executeUpdate();
        }
    }

    // Metodos abstractos que deben ser implementados por cada clase DAO concreta
    protected abstract String getFindByIdQuery();
    protected abstract String getFindAllQuery();
    protected abstract String getDeleteQuery();
    protected abstract void setIdInStatement(PreparedStatement stmt, K id) throws SQLException;
    protected abstract T mapResultSetToEntity(ResultSet rs) throws SQLException;
}