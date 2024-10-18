package org.example.Model.Classes;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Truck")  // Matches <Truck> in your XML
public class Truck extends Vehicle {

    private int truckID;
    private int loadCapacity;
    private int cabinSize;

    public Truck() {}

    public Truck(int vehicleID, String brand, String model, int truckID, int loadCapacity, int cabinSize) {
        super(vehicleID, brand, model);
        this.truckID = truckID;
        this.loadCapacity = loadCapacity;
        this.cabinSize = cabinSize;
    }

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

    @Override
    public String toString() {
        return super.toString() + "Truck{" +
                "truckID=" + truckID +
                ", loadCapacity=" + loadCapacity +
                ", cabinSize=" + cabinSize +
                '}';
    }
}
