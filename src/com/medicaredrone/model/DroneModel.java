package com.medicaredrone.model;

/**
 *
 * @author suman lama 23048591
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
    
     /**
     * Retrieves the unique identifier of the drone.
     * @return int representing the drone ID.
     */
    public int getDroneId() {
        return droneId;
    }

    /**
     * Retrieves the current operational status of the drone.
     * @return String representing the drone's status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Retrieves the name of the requester.
     * @return String representing the requester's name.
     */
    public String getRequesterName() {
        return requesterName;
    }

    /**
     * Retrieves the name of the item being delivered.
     * @return String representing the item name.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Retrieves the delivery location or operational location of the drone.
     * @return String representing the location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Retrieves the emergency contact information related to the delivery.
     * @return String representing the emergency contact details.
     */
    public String getEmergencyContact() {
        return emergencyContact;
    }

    /**
     * Retrieves the weather conditions affecting the drone's operation.
     * @return String representing the weather conditions.
     */
    public String getWeatherCondition() {
        return weatherCondition;
    }
/**
     * Retrieves the maximum payload capacity of the drone.
     * @return double representing the load capacity in kilograms.
     */
    public double getLoadCapacity() {
        return loadCapacity;
    }

    // Setters
    
    /**
     * Updates the unique identifier of the drone.
     * @param droneId int representing the new drone ID.
     */
    public void setDroneId(int droneId) {
        this.droneId = droneId;
    }

    /**
     * Updates the current operational status of the drone.
     * @param status String representing the new status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Updates the name of the requester.
     * @param requesterName String representing the new requester's name.
     */
    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    /**
     * Updates the name of the item being delivered.
     * @param itemName String representing the new item name.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Updates the delivery location or operational location of the drone.
     * @param location String representing the new location.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Updates the emergency contact information related to the delivery.
     * @param emergencyContact String representing the new emergency contact details.
     */
    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    /**
     * Updates the weather conditions affecting the drone's operation.
     * @param weatherCondition String representing the new weather conditions.
     */
    public void setWeatherCondition(String weatherCondition) {
        this.weatherCondition = weatherCondition;
    }

    /**
     * Updates the maximum payload capacity of the drone.
     * @param loadCapacity double representing the new load capacity in kilograms.
     */
    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }    
}