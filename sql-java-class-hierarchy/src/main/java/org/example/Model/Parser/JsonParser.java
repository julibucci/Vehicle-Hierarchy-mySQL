package org.example.Model.Parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.example.Model.Classes.Vehicles;

public class JsonParser
{
    // Metodo para parsear el archivo JSON
    public Vehicles parseJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        Vehicles vehicles = null;

        try
        {
            vehicles = objectMapper.readValue(new File(filePath), Vehicles.class); // Lee el archivo JSON y lo convierte en un objeto de la clase Vehicles

        } catch (IOException e) {
            e.printStackTrace();
        }

        return vehicles;
    }
}
