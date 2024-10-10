package org.example.Classes;
import org.apache.commons.dbcp2.BasicDataSource;
import javax.sql.DataSource;

public class ConnectionPool {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setUrl("jdbc:mysql://localhost:3306/hierarchyVehicle");
        ds.setUsername("root");
        ds.setPassword("Kira202120"); //Lo probe usando mi constraseña de mySQL
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    public static DataSource getDataSource() {
        return ds;
    }
}
