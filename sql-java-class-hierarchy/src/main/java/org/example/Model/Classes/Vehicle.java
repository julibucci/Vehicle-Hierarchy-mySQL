package org.example.Model.Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Vehicle {
    private int vehicleID;
    private String brand;
    private String model;

    public Vehicle() {}  // Required by JAXB

    // Constructor
    public Vehicle(int vehicleID, String brand, String model) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
    }

    @XmlElement
    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    @XmlElement
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @XmlElement
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
