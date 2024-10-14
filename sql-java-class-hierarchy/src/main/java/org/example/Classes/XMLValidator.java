package org.example.Classes;
import org.xml.sax.SAXException;

import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.XMLConstants;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.stream.StreamSource;

public class XMLValidator {
    public static boolean validateXMLWithXSD(String xmlPath, String xsdPath) {
        try {
            // Cargar la fábrica para esquemas de XML
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Cargar el esquema XSD
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();

            // Validar el archivo XML
            validator.validate(new StreamSource(new File(xmlPath)));
            return true;
        } catch (IOException | SAXException e)
        {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}
