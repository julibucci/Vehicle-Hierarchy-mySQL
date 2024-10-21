package org.example.Model.Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "Truck")
public class Truck extends Vehicle
{
    // ATTRIBUTES
    @JsonProperty("truckID")
    private int truckID;

    @JsonProperty("loadCapacity")
    private int loadCapacity;

    @JsonProperty("cabinSize")
    private int cabinSize;

    //CONSTRUCTOR
    public Truck() {}

    public Truck(int vehicleID, String brand, String model, String vehicleType, int truckID, int loadCapacity, int cabinSize) {
        super(vehicleID, brand, model, vehicleType);
        this.truckID = truckID;
        this.loadCapacity = loadCapacity;
        this.cabinSize = cabinSize;
    }

    public Truck(int vehicleID, String brand, String model, int vehicleID1, int loadCapacity, int cabinSize) {
    }


    /// GETTER AND SETTER
    @XmlElement(name = "TruckID")
    public int getTruckID() {
        return truckID;
    }

    public void setTruckID(int truckID) {
        this.truckID = truckID;
    }

    @XmlElement(name = "LoadCapacity")
    public int getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(int loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @XmlElement(name = "CabinSize")
    public int getCabinSize() {
        return cabinSize;
    }

    public void setCabinSize(int cabinSize) {
        this.cabinSize = cabinSize;
    }

    //TOSTRING METHOD
    @Override
    public String toString() {
        return super.toString() + "Truck{" +
                "truckID=" + truckID +
                ", loadCapacity=" + loadCapacity +
                ", cabinSize=" + cabinSize +
                '}';
    }
}
