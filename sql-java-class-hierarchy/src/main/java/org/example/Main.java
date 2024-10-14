package org.example;
import org.example.Classes.Vehicle;
import javax.sql.DataSource;
import org.example.Classes.ConnectionPool;
import org.example.Classes.VehicleDAO;
import java.sql.SQLException;
import org.example.Interfaces.IGenericDAO;
import org.example.Classes.VehicleServiceImpl;
import org.example.Classes.XMLValidator;
import org.example.Classes.XMLParser;


public class Main {
    public static void main(String[] args)
    {
// Validar XML con XSD usando la clase XMLValidator
        String xmlFilePath = "C:\\Users\\julie\\OneDrive\\Documentos\\Vehicle-Hierarchy-mySQL\\sql-java-class-hierarchy\\src\\main\\resources\\vehicles.xml";
        String xsdFilePath = "C:\\Users\\julie\\OneDrive\\Documentos\\Vehicle-Hierarchy-mySQL\\sql-java-class-hierarchy\\src\\main\\resources\\vehicles.xsd";

        // Valida XML con XSD usando la clase XMLValidator
        boolean isXMLValid = XMLValidator.validateXMLWithXSD(xmlFilePath, xsdFilePath);

        if (isXMLValid) {
            System.out.println("El archivo XML es valido.");
        } else {
            System.out.println("El archivo XML no es valido.");
            return;
        }

        // Conectar a la base de datos y manejar vehiculos
        DataSource dataSource = ConnectionPool.getDataSource();
        IGenericDAO<Vehicle, Integer> vehicleDAO = new VehicleDAO(dataSource);  // Usamos el DAO genérico
        VehicleServiceImpl vehicleService = new VehicleServiceImpl(vehicleDAO);

        try {
            // Parsear el archivo XML
            XMLParser xmlParser = new XMLParser();
            xmlParser.parseXMLFile(xmlFilePath);

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
