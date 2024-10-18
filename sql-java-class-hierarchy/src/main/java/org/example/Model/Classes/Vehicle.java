package org.example.Model.Classes;

public abstract class Vehicle {
    private int vehicleID;
    private String brand;
    private String model;

    // Constructor
    public Vehicle(int vehicleID, String brand, String model) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
    }

    // Getters y Setters
    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
