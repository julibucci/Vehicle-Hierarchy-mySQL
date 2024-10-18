package org.example.Model.Classes;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Owner")
public class Owner {

    private int ownerID;
    private String name;
    private List<Integer> ownedVehicleIDs;

    @XmlElement(name = "OwnerID")
    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    @XmlElement(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "VehicleID")
    public List<Integer> getOwnedVehicleIDs() {
        return ownedVehicleIDs;
    }

    public void setOwnedVehicleIDs(List<Integer> ownedVehicleIDs) {
        this.ownedVehicleIDs = ownedVehicleIDs;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerID=" + ownerID +
                ", name='" + name + '\'' +
                ", ownedVehicleIDs=" + ownedVehicleIDs +
                '}';
    }
}
