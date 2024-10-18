package org.example.Model.Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Airplane extends Vehicle {
    private int airplaneID;
    private int altitude;
    private int passengerCapacity;
    private String fuelType;

    public Airplane() {}  // Required by JAXB

    // Constructor
    public Airplane(int vehicleID, String brand, String model, int airplaneID, int altitude, int passengerCapacity, String fuelType) {
        super(vehicleID, brand, model);
        this.airplaneID = airplaneID;
        this.altitude = altitude;
        this.passengerCapacity = passengerCapacity;
        this.fuelType = fuelType;
    }

    @XmlElement
    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    @XmlElement
    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @XmlElement
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @XmlElement
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
