package org.example.Model.Classes;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement(name = "Owner")
public class Owner
{
    //ATTRIBUTES
    @JsonProperty("ownerID")
    private int ownerID;

    @JsonProperty("name")
    private String name;

    @JsonProperty("ownedVehicleIDs")
    private List<Integer> ownedVehicleIDs;

    //GETTER Y SETTER

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

    // TOSTRING METHOD
    @Override
    public String toString() {
        return "Owner{" +
                "ownerID=" + ownerID +
                ", name='" + name + '\'' +
                ", ownedVehicleIDs=" + ownedVehicleIDs +
                '}';
    }
}
