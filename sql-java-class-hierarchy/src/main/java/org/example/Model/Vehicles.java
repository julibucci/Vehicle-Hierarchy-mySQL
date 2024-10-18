package org.example.Model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.example.Model.Classes.Vehicle;

@XmlRootElement(name = "Vehicles")
public class Vehicles {

    private List<Vehicle> vehicles;

    @XmlElement(name = "Vehicle")
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
