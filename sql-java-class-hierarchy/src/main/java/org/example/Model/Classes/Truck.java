package org.example.Model.Classes;

public class Truck extends Vehicle {
    private int truckID;
    private int loadCapacity;
    private int cabinSize;

    // Constructor
    public Truck(int vehicleID, String brand, String model, int truckID, int loadCapacity, int cabinSize) {
        super(vehicleID, brand, model);
        this.truckID = truckID;
        this.loadCapacity = loadCapacity;
        this.cabinSize = cabinSize;
    }

    // Getters y Setters
    public int getTruckID() {
        return truckID;
    }

    public void setTruckID(int truckID) {
        this.truckID = truckID;
    }

    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getCabinSize() {
        return cabinSize;
    }

    public void setCabinSize(int cabinSize) {
        this.cabinSize = cabinSize;
    }
}
