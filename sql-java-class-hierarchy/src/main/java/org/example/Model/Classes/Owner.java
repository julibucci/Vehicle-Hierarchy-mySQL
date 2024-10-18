package org.example.Model.Classes;

import java.util.List;

public class Owner {
    private int ownerID;
    private String name;
    private List<Vehicle> ownedVehicles;

    // Constructor
    public Owner(int ownerID, String name, List<Vehicle> ownedVehicles) {
        this.ownerID = ownerID;
        this.name = name;
        this.ownedVehicles = ownedVehicles;
    }

    // Getters y Setters
    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vehicle> getOwnedVehicles() {
        return ownedVehicles;
    }

    public void setOwnedVehicles(List<Vehicle> ownedVehicles) {
        this.ownedVehicles = ownedVehicles;
    }
}

