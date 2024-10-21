package org.example.Model.Classes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@XmlRootElement(name = "Bus")
public class Bus extends Vehicle
{

    // ATTRIBUTES
    @JsonProperty("busID")
    private int busID;

    @JsonProperty("seatingCapacity")
    private int seatingCapacity;

    @JsonProperty("numberOfDoors")
    private int numberOfDoors;

    @JsonProperty("fuelType")
    private String fuelType;

    @JsonProperty("passengers")
    @JsonManagedReference  // Relacion bidireccional con pasajeros
    private List<Passenger> passengers;

    //CONSTRUCTOR
    public Bus() {}

    public Bus(int vehicleID, String brand, String model, String vehicleType, int busID, int seatingCapacity, int numberOfDoors, String fuelType, List<Passenger> passengers) {
        super(vehicleID, brand, model, vehicleType);
        this.busID = busID;
        this.seatingCapacity = seatingCapacity;
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
        this.passengers = passengers;
    }

    public <E> Bus(int vehicleID, String brand, String model, int vehicleID1, int seatingCapacity, int numberOfDoors, String fuelType, ArrayList<E> es) {
    }

    //GETTER AND SETTER
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

    // TOSTRING METHOD
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
