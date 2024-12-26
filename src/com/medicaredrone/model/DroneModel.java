package com.medicaredrone.model;

/**
 *
 * @author suman lama
 */
public class DroneModel {
    private int droneId;
    private String status;
    private String requesterName;
    private String itemName;
    private String location;
    private String emergencyContact;
    private String weatherCondition;
    private double loadCapacity;

    public DroneModel() {
    }

    public DroneModel(int droneId, String status, String requesterName, String itemName,
                        String location, String emergencyContact, 
                        String weatherCondition, double loadCapacity) {
        this.droneId = droneId;
        this.status = status;
        this.requesterName = requesterName;
        this.itemName = itemName;
        this.location = location;
        this.emergencyContact = emergencyContact;
        this.weatherCondition = weatherCondition;
        this.loadCapacity = loadCapacity;
    }
    
        // Getters
    public int getDroneId() {
        return droneId;
    }

    public String getStatus() {
        return status;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public String getItemName() {
        return itemName;
    }

    public String getLocation() {
        return location;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public String getWeatherCondition() {
        return weatherCondition;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    // Setters
    public void setDroneId(int droneId) {
        this.droneId = droneId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }    
}