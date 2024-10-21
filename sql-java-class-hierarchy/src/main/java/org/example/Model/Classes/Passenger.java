package org.example.Model.Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "Passenger")
public class Passenger
{
    //ATTRIBUTES
    @JsonProperty("passengerID")
    private int passengerID;

    @JsonProperty("name")
    private String name;

    @JsonBackReference
    private Bus bus;


    //CONSTRUCTOR
    public Passenger() {}

    public Passenger(int passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
    }

    /// GETTER AND SETTER
    @XmlElement(name = "PassengerID")
    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //TOSTRING METHOD
    @Override
    public String toString() {
        return "Passenger{" +
                "passengerID=" + passengerID +
                ", name='" + name + '\'' +
                '}';
    }
}
