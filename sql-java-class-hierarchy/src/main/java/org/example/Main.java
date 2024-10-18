package org.example;

import org.example.Model.*;
import org.example.Model.Classes.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.File;
import javax.xml.bind.Unmarshaller;

import javax.sql.DataSource;
import org.example.Interfaces.IGenericDAO;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            // Define paths for XML and XSD files
            String xmlFilePath = "C:\\Users\\julie\\OneDrive\\Documentos\\Vehicle-Hierarchy-mySQL\\sql-java-class-hierarchy\\src\\main\\resources\\vehicles.xml";
            String xsdFilePath = "C:\\Users\\julie\\OneDrive\\Documentos\\Vehicle-Hierarchy-mySQL\\sql-java-class-hierarchy\\src\\main\\resources\\vehicles.xsd";

            // Validate XML against the XSD using XMLValidator
            boolean isXMLValid = XMLValidator.validateXMLWithXSD(xmlFilePath, xsdFilePath);

            if (isXMLValid) {
                System.out.println("El archivo XML es válido.");
            } else {
                System.out.println("El archivo XML no es válido.");
                return;
            }

            // Set up database connection and vehicle service
            DataSource dataSource = ConnectionPool.getDataSource();
            IGenericDAO<Vehicle, Integer> vehicleDAO = new VehicleDAO(dataSource);  // Use the generic DAO
            VehicleServiceImpl vehicleService = new VehicleServiceImpl(vehicleDAO);

            // Parse the XML file using JAXBParser
            JAXBParser parser = new JAXBParser();
            Vehicles vehicles = parser.parseVehiclesXML(xmlFilePath);  // Parse XML into Vehicles object

            // Iterate over the list of vehicles and insert them into the database
            for (Vehicle vehicle : vehicles.getVehicles()) {
                vehicleService.addVehicle(vehicle);  // Insert each vehicle into the database
                System.out.println("Vehículo insertado: " + vehicle);  // Print the vehicle details
            }

            // Iterate over the owners and print their details (if required)
            for (Owner owner : vehicles.getOwners()) {
                System.out.println("Propietario: " + owner.getName());
                System.out.println("Vehículos del propietario: " + owner.getOwnedVehicleIDs());
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Handle SQL exceptions
        }
        try {
            // Parse XML
            String xmlFilePath = "C:\\Users\\julie\\OneDrive\\Documentos\\Vehicle-Hierarchy-mySQL\\sql-java-class-hierarchy\\src\\main\\resources\\vehicles.xml";  // Update this to your actual XML file path
            File xmlFile = new File(xmlFilePath);

            JAXBContext context = JAXBContext.newInstance(Vehicles.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Vehicles vehicles = (Vehicles) unmarshaller.unmarshal(xmlFile);

            // Print parsed vehicles
            for (Vehicle vehicle : vehicles.getVehicles()) {
                System.out.println(vehicle);  // You can override toString() in each class to print the details
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }



        }

    }

