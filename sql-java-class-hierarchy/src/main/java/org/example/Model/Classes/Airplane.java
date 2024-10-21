package org.example.Model.Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

@XmlRootElement(name = "Airplane")
public class Airplane extends Vehicle {

    //ATTRIBUTES
    @JsonProperty("airplaneID")
    private int airplaneID;

    @JsonProperty("altitude")
    private int altitude;

    @JsonProperty("passengerCapacity")
    private int passengerCapacity;

    @JsonProperty("fuelType")
    private String fuelType;

    @JsonProperty("lastMaintenance")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date lastMaintenance;

    //CONSTRUCTOR
    public Airplane() {}

    public Airplane(int vehicleID, String brand, String model, int airplaneID, int altitude, int passengerCapacity, String fuelType, Date lastMaintenance) {
        super(vehicleID, brand, model, "Airplane");
        this.airplaneID = airplaneID;
        this.altitude = altitude;
        this.passengerCapacity = passengerCapacity;
        this.fuelType = fuelType;
        this.lastMaintenance = lastMaintenance;
    }

    public Airplane(int vehicleID, String brand, String model, int vehicleID1, int altitude, int passengerCapacity, String fuelType) {
    }

    /// GETTER AND SETTER
    @XmlElement(name = "AirplaneID")
    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    @XmlElement(name = "Altitude")
    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @XmlElement(name = "PassengerCapacity")
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @XmlElement(name = "FuelType")
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    //TOSTRING METHOD
    @Override
    public String toString() {
        return super.toString() + " Airplane{" +
                "airplaneID=" + airplaneID +
                ", altitude=" + altitude +
                ", passengerCapacity=" + passengerCapacity +
                ", fuelType='" + fuelType + '\'' +
                ", lastMaintenance=" + lastMaintenance +
                '}';
    }

}

