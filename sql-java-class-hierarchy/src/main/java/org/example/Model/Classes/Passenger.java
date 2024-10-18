package org.example.Model.Classes;

public class Passenger {
    private int passengerID;
    private String name;

    // Constructor
    public Passenger(int passengerID, String name) {
        this.passengerID = passengerID;
        this.name = name;
    }

    // Getters y Setters
    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

