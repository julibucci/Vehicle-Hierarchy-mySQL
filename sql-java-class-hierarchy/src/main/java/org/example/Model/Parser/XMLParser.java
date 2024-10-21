package org.example.Model.Parser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {
    public void parseXMLFile(String filePath) {
        try {
            // Crear un DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML
            Document document = builder.parse(new File(filePath));

            // Normalizar el documento
            document.getDocumentElement().normalize();

            // Obtener el elemento raíz
            Element root = document.getDocumentElement();
            System.out.println("Elemento raíz: " + root.getNodeName());

            // Obtener todos los vehículos (Asegúrate de que la etiqueta coincida con el XML)
            NodeList vehicleList = document.getElementsByTagName("Vehicle");

            for (int i = 0; i < vehicleList.getLength(); i++) {
                Node vehicleNode = vehicleList.item(i);

                if (vehicleNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element vehicleElement = (Element) vehicleNode;

                    // Obtener atributos del vehículo
                    String id = vehicleElement.getElementsByTagName("VehicleID").item(0).getTextContent();
                    String brand = vehicleElement.getElementsByTagName("Brand").item(0).getTextContent();
                    String model = vehicleElement.getElementsByTagName("Model").item(0).getTextContent();

                    System.out.println("ID: " + id + ", Marca: " + brand + ", Modelo: " + model);

                    // Verificar tipo de vehículo (Bus, Airplane, Truck)
                    if (vehicleElement.getElementsByTagName("Bus").getLength() > 0) {
                        Element busElement = (Element) vehicleElement.getElementsByTagName("Bus").item(0);
                        String seatingCapacity = busElement.getElementsByTagName("SeatingCapacity").item(0).getTextContent();
                        System.out.println("Capacidad de asientos (Bus): " + seatingCapacity);
                    }

                    if (vehicleElement.getElementsByTagName("Airplane").getLength() > 0) {
                        Element airplaneElement = (Element) vehicleElement.getElementsByTagName("Airplane").item(0);
                        String passengerCapacity = airplaneElement.getElementsByTagName("PassengerCapacity").item(0).getTextContent();
                        System.out.println("Capacidad de pasajeros (Airplane): " + passengerCapacity);
                    }

                    if (vehicleElement.getElementsByTagName("Truck").getLength() > 0) {
                        Element truckElement = (Element) vehicleElement.getElementsByTagName("Truck").item(0);
                        String loadCapacity = truckElement.getElementsByTagName("LoadCapacity").item(0).getTextContent();
                        System.out.println("Capacidad de carga (Truck): " + loadCapacity);
                    }

                    System.out.println("-----------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
