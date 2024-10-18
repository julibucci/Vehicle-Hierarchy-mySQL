package org.example;

import org.example.Model.*;
import org.example.Model.Classes.*;
import org.example.Interfaces.IGenericDAO;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {

            String xmlFilePath = "C:\\Users\\julie\\OneDrive\\Documentos\\Vehicle-Hierarchy-mySQL\\sql-java-class-hierarchy\\src\\main\\resources\\vehicles.xml";
            String xsdFilePath = "C:\\Users\\julie\\OneDrive\\Documentos\\Vehicle-Hierarchy-mySQL\\sql-java-class-hierarchy\\src\\main\\resources\\vehicles.xsd";

            // Validar XML con XSD usando la clase XMLValidator
            boolean isXMLValid = XMLValidator.validateXMLWithXSD(xmlFilePath, xsdFilePath);

            if (isXMLValid) {
                System.out.println("El archivo XML es válido.");
            } else {
                System.out.println("El archivo XML no es válido.");
                return;
            }

            DataSource dataSource = ConnectionPool.getDataSource();
            IGenericDAO<Vehicle, Integer> vehicleDAO = new VehicleDAO(dataSource);  // Usamos el DAO genérico
            VehicleServiceImpl vehicleService = new VehicleServiceImpl(vehicleDAO);

            // Parsear el archivo XML
            XMLParser xmlParser = new XMLParser();
            xmlParser.parseXMLFile(xmlFilePath);

            Airplane airplane = new Airplane(0, "Boeing", "747", 101, 35000, 400, "Jet Fuel");
            vehicleService.addVehicle(airplane);
            System.out.println("Vehículo 'Boeing 747' insertado.");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
