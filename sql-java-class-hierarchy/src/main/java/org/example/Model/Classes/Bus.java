package org.example.Model.Classes;

import java.util.List;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "Bus")  // Matches <Bus> in your XML
public class Bus extends Vehicle {

    private int busID;
    private int seatingCapacity;
    private int numberOfDoors;
    private String fuelType;
    private List<Passenger> passengers;

    public Bus() {}

    public Bus(int vehicleID, String brand, String model, int busID, int seatingCapacity, int numberOfDoors, String fuelType, List<Passenger> passengers) {
        super(vehicleID, brand, model);
        this.busID = busID;
        this.seatingCapacity = seatingCapacity;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.passengers = passengers;
    }

    @XmlElement(name = "BusID")
    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    @XmlElement(name = "SeatingCapacity")
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @XmlElement(name = "NumberOfDoors")
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @XmlElement(name = "FuelType")
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @XmlElement(name = "Passenger")
    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    @Override
    public String toString() {
        return super.toString() + "Bus{" +
                "busID=" + busID +
                ", seatingCapacity=" + seatingCapacity +
                ", numberOfDoors=" + numberOfDoors +
                ", fuelType='" + fuelType + '\'' +
                ", passengers=" + passengers +
                '}';
    }
}
