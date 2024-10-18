package org.example.Model.Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Passenger")
public class Passenger {

    private int passengerID;
    private String name;

    public Passenger() {}

    public Passenger(int passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
    }

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

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerID=" + passengerID +
                ", name='" + name + '\'' +
                '}';
    }
}
