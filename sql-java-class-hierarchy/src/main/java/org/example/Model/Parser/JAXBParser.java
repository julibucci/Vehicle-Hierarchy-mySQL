package org.example.Model.Parser;

import org.example.Model.Classes.Vehicles;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JAXBParser {
    public Vehicles parseVehiclesXML(String xmlFilePath) throws JAXBException {
        // Create a new JAXB context for the Vehicles class
        JAXBContext context = JAXBContext.newInstance(Vehicles.class);

        // Create an unmarshaller
        Unmarshaller unmarshaller = context.createUnmarshaller();

        // Parse the XML file and return the Vehicles object
        File xmlFile = new File(xmlFilePath);
        return (Vehicles) unmarshaller.unmarshal(xmlFile);
    }
}


