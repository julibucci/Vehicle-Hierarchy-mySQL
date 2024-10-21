package org.example.Model.Classes;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "vehicleType")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Airplane.class, name = "Airplane"),
        @JsonSubTypes.Type(value = Bus.class, name = "Bus"),
        @JsonSubTypes.Type(value = Truck.class, name = "Truck")
})
@JsonIgnoreProperties(ignoreUnknown = true) // Ignora propiedades desconocidas
@XmlType(propOrder = {"vehicleID", "brand", "model", "vehicleType"})
@XmlSeeAlso({Bus.class, Truck.class, Airplane.class})  // Make sure the subclasses are recognized
@JsonInclude(JsonInclude.Include.NON_NULL)  // Solo incluir campos no nulos
public class Vehicle
{
    // ATTRIBUTES
    @JsonProperty("VehicleID")
    private int vehicleID;

    @JsonProperty("Brand")
    private String brand;

    @JsonProperty("Model")
    private String model;

    @JsonProperty("VehicleType")
    private String vehicleType;

    ///CONSTRUCTOR
    public Vehicle() {}

    public Vehicle(int vehicleID, String brand, String model,String vehicleType) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
        this.vehicleType = vehicleType;
    }

    //GETTER AND SETTER
    @XmlElement(name = "VehicleID")
    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    @XmlElement(name = "Brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @XmlElement(name = "Model")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("VehicleType")
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    //TOSTRING METHOD
    @Override
    public String toString() {
        return "Vehicle [ID=" + vehicleID + ", Brand=" + brand + ", Model=" + model + "]";
    }

}
