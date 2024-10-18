package org.example.Model.Classes;

import java.util.List;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Owner {
    private int ownerID;
    private String name;
    private List<Vehicle> ownedVehicles;

    public Owner() {}  // Required by JAXB

    // Constructor
    public Owner(int ownerID, String name, List<Vehicle> ownedVehicles) {
        this.ownerID = ownerID;
        this.name = name;
        this.ownedVehicles = ownedVehicles;
    }

    @XmlElement
    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElementWrapper(name = "ownedVehicles")
    @XmlElement(name = "vehicle")
    public List<Vehicle> getOwnedVehicles() {
        return ownedVehicles;
    }

    public void setOwnedVehicles(List<Vehicle> ownedVehicles) {
        this.ownedVehicles = ownedVehicles;
    }
}
