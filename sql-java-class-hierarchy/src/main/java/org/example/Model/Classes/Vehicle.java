package org.example.Model.Classes;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"vehicleID", "brand", "model"})
@XmlSeeAlso({Bus.class, Truck.class, Airplane.class})  // Make sure the subclasses are recognized
public class Vehicle {

    private int vehicleID;
    private String brand;
    private String model;

    public Vehicle() {}

    public Vehicle(int vehicleID, String brand, String model) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
    }

    @XmlElement(name = "VehicleID")
    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    @XmlElement(name = "Brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @XmlElement(name = "Model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle [ID=" + vehicleID + ", Brand=" + brand + ", Model=" + model + "]";
    }

}
