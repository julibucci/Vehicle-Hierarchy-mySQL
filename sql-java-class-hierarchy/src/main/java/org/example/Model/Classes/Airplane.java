package org.example.Model.Classes;

public class Airplane extends Vehicle {
    private int airplaneID;
    private int altitude;
    private int passengerCapacity;
    private String fuelType;

    // Constructor
    public Airplane(int vehicleID, String brand, String model, int airplaneID, int altitude, int passengerCapacity, String fuelType) {
        super(vehicleID, brand, model);
        this.airplaneID = airplaneID;
        this.altitude = altitude;
        this.passengerCapacity = passengerCapacity;
        this.fuelType = fuelType;
    }

    // Getters y Setters
    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}

