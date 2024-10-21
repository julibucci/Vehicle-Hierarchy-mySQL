package org.example;

import org.example.Model.*;
import org.example.Model.Classes.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import javax.xml.bind.Unmarshaller;

import javax.sql.DataSource;
import org.example.Interfaces.IGenericDAO;
import org.example.Model.DAOClasses.VehicleDAO;
import org.example.Model.Parser.JAXBParser;

import java.sql.SQLException;
import org.example.Model.Parser.JsonParser;

public class Main {
    public static void main(String[] args) throws SQLException {
        {
            // Define paths for XML and JSON files
            String xmlFilePath = "C:\\Users\\julie\\OneDrive\\Documentos\\Vehicle-Hierarchy-mySQL\\sql-java-class-hierarchy\\src\\main\\resources\\vehicles.xml";
            String jsonFilePath = "C:\\Users\\julie\\OneDrive\\Documentos\\Vehicle-Hierarchy-mySQL\\sql-java-class-hierarchy\\src\\main\\resources\\vehicles.json";

            // Validate XML against the XSD using XMLValidator
            String xsdFilePath = "C:\\Users\\julie\\OneDrive\\Documentos\\Vehicle-Hierarchy-mySQL\\sql-java-class-hierarchy\\src\\main\\resources\\vehicles.xsd";
            boolean isXMLValid = XMLValidator.validateXMLWithXSD(xmlFilePath, xsdFilePath);
            if (isXMLValid) {
                System.out.println("El archivo XML es valido.");
            } else {
                System.out.println("El archivo XML no es valido.");
                return;
            }

            // Set up database connection and vehicle service
            DataSource dataSource = ConnectionPool.getDataSource();
            IGenericDAO<Vehicle, Integer> vehicleDAO = new VehicleDAO(dataSource);
            VehicleServiceImpl vehicleService = new VehicleServiceImpl(vehicleDAO);

            // Parse the XML file using JAXBParser
            JAXBParser parser = new JAXBParser();
            try {
                Vehicles vehiclesFromXML = parser.parseVehiclesXML(xmlFilePath);
                // Print parsed vehicles from XML
                System.out.println("Vehicles from XML:");
                for (Vehicle vehicle : vehiclesFromXML.getVehicles()) {
                    System.out.println(vehicle);
                }
            } catch (JAXBException e) {
                throw new RuntimeException(e);
            }

            // Parse the JSON file using JsonParser
            JsonParser jsonParser = new JsonParser();
            Vehicles vehiclesFromJSON = jsonParser.parseJson(jsonFilePath);

            // Print parsed vehicles from JSON
            if (vehiclesFromJSON != null) {
                System.out.println("Vehicles from JSON:");
                System.out.println(vehiclesFromJSON);
            } else {
                System.out.println("Error al parsear el JSON.");
            }
        }
    }
}


