package org.example.Model.Classes;

import java.util.List;

public class Bus extends Vehicle {
    private int busID;
    private int seatingCapacity;
    private int numberOfDoors;
    private String fuelType;
    private List<Passenger> passengers;

    // Constructor
    public Bus(int vehicleID, String brand, String model, int busID, int seatingCapacity, int numberOfDoors, String fuelType, List<Passenger> passengers) {
        super(vehicleID, brand, model);
        this.busID = busID;
        this.seatingCapacity = seatingCapacity;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.passengers = passengers;
    }

    // Getters y Setters
    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}

