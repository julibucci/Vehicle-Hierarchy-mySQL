package org.example.Model.Classes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Passenger {
    private int passengerID;
    private String name;

    public Passenger() {}  // Required by JAXB

    // Constructor
    public Passenger(int passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
    }

    @XmlElement
    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
