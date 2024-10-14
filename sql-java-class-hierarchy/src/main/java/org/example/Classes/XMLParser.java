package org.example.Classes;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
public class XMLParser {
    public void parseXMLFile(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML
            Document document = builder.parse(new File(filePath));

            // Normalizar el documento
            document.getDocumentElement().normalize();

            // Obtener el elemento raiz
            Element root = document.getDocumentElement();
            System.out.println("Elemento raiz: " + root.getNodeName());

            // Obtener todos los vehiculos
            NodeList vehicleList = document.getElementsByTagName("vehicle");

            for (int i = 0; i < vehicleList.getLength(); i++) {
                Node vehicleNode = vehicleList.item(i);

                if (vehicleNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element vehicleElement = (Element) vehicleNode;

                    // Obtener atributos del vehiculo
                    String id = vehicleElement.getElementsByTagName("id").item(0).getTextContent();
                    String brand = vehicleElement.getElementsByTagName("brand").item(0).getTextContent();
                    String model = vehicleElement.getElementsByTagName("model").item(0).getTextContent();

                    System.out.println("ID: " + id + ", Marca: " + brand + ", Modelo: " + model);

                    // Verificar tipo de vehiculo (bus, airplane, truck)
                    if (vehicleElement.getElementsByTagName("bus").getLength() > 0) {
                        Element busElement = (Element) vehicleElement.getElementsByTagName("bus").item(0);
                        String seatingCapacity = busElement.getElementsByTagName("seatingCapacity").item(0).getTextContent();
                        System.out.println("Capacidad de asientos: " + seatingCapacity);
                    }

                    if (vehicleElement.getElementsByTagName("airplane").getLength() > 0) {
                        Element airplaneElement = (Element) vehicleElement.getElementsByTagName("airplane").item(0);
                        String passengerCapacity = airplaneElement.getElementsByTagName("passengerCapacity").item(0).getTextContent();
                        System.out.println("Capacidad de pasajeros: " + passengerCapacity);
                    }

                    if (vehicleElement.getElementsByTagName("truck").getLength() > 0) {
                        Element truckElement = (Element) vehicleElement.getElementsByTagName("truck").item(0);
                        String loadCapacity = truckElement.getElementsByTagName("loadCapacity").item(0).getTextContent();
                        System.out.println("Capacidad de carga: " + loadCapacity);
                    }

                    System.out.println("-----------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}