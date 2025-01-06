/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medicaredrone.controller;

import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @ Suman lama 23048591
 */
public class ValidationUtil {

    // Regular expressions for validation
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");
    private static final Pattern ALPHABET_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$"); // Only alphabets and spaces
    private static final Pattern CONTACT_PATTERN = Pattern.compile("^(98|97)\\d{8}$"); // Starts with 98 or 97, 10 digits

    /**
     * Checks if a string is null or empty.
     *
     * @param value the string to check
     * @return true if the string is null or empty, otherwise false
     */
    private static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validates the Drone ID. It should be numeric and exactly 8 digits.
     *
     * @param droneId the drone ID to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidDroneId(String droneId, JLabel lblError) {
        if (isNullOrEmpty(droneId)) {
            lblError.setText("Drone ID cannot be empty.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        if (!NUMERIC_PATTERN.matcher(droneId).matches() || droneId.length() != 8) {
            lblError.setText("Drone ID must be exactly 8 digits and numeric.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        return true;
    }

    /**
     * Validates the status. It should be a single word (alphabetical).
     *
     * @param status the status to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidStatus(String status, JLabel lblError) {
        if (isNullOrEmpty(status)) {
            lblError.setText("Status cannot be empty.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        if (!ALPHABET_PATTERN.matcher(status).matches() || status.split("\\s+").length != 1) {
            lblError.setText("Status must be a single word (alphabets only).");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        return true;
    }

    /**
     * Validates the requester name. It should consist of a maximum of 4 words
     * and contain only alphabets.
     *
     * @param requesterName the requester name to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidRequesterName(String requesterName, JLabel lblError) {
        if (isNullOrEmpty(requesterName)) {
            lblError.setText("Requester name cannot be empty.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        if (!ALPHABET_PATTERN.matcher(requesterName).matches() || requesterName.split("\\s+").length > 4) {
            lblError.setText("Requester name must contain only alphabets and up to 4 words.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        return true;
    }

    /**
     * Validates the location. It should consist of a maximum of 4 words and
     * contain only alphabets.
     *
     * @param location the location to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidLocation(String location, JLabel lblError) {
        if (isNullOrEmpty(location)) {
            lblError.setText("Location cannot be empty.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        if (!ALPHABET_PATTERN.matcher(location).matches() || location.split("\\s+").length > 4) {
            lblError.setText("Location must contain only alphabets and up to 4 words.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        return true;
    }

    /**
     * Validates the item name. It should consist of exactly 2 words and contain
     * only alphabets.
     *
     * @param itemName the item name to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidItemName(String itemName, JLabel lblError) {
        // Check if the item name is null or empty
        if (isNullOrEmpty(itemName)) {
            lblError.setText("Item name cannot be empty.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }

        // Check if the item name contains only letters and spaces, and has at most 3 words
        if (!ALPHABET_PATTERN.matcher(itemName).matches() || itemName.split("\\s+").length > 3) {
            lblError.setText("Item name must contain a maximum of 3 words, each with valid characters.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        return true;
    }

    /**
     * Validates the emergency contact. It should be 10 digits, starting with 98
     * or 97.
     *
     * @param emergencyContact the emergency contact to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmergencyContact(String emergencyContact, JLabel lblError) {
        if (isNullOrEmpty(emergencyContact)) {
            lblError.setText("Emergency contact cannot be empty.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        if (!CONTACT_PATTERN.matcher(emergencyContact).matches()) {
            lblError.setText("Emergency contact must be 10 digits, starting with 98 or 97.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        return true;
    }

    /**
     * Validates the weather condition. It should be a single word and contain
     * only alphabets.
     *
     * @param weatherCondition the weather condition to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidWeatherCondition(String weatherCondition, JLabel lblError) {
        if (isNullOrEmpty(weatherCondition)) {
            lblError.setText("Weather condition cannot be empty.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        if (!ALPHABET_PATTERN.matcher(weatherCondition).matches() || weatherCondition.split("\\s+").length != 1) {
            lblError.setText("Weather condition must be a single word.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        return true;
    }

    /**
     * Validates the load capacity. It should be numeric, greater than 0 and
     * less than or equal to 15.
     *
     * @param loadCapacity the load capacity to validate
     * @param lblError the JLabel to show error messages
     * @return true if valid, false otherwise
     */
    public static boolean isValidLoadCapacity(String loadCapacity, JLabel lblError) {
        if (isNullOrEmpty(loadCapacity)) {
            lblError.setText("Load capacity cannot be empty.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        try {
            double capacity = Double.parseDouble(loadCapacity);
            if (capacity <= 0 || capacity > 15) {
                lblError.setText("Load capacity must be between 1 and 15.");
                lblError.setForeground(Color.RED); // Set error color to red
                return false;
            }
        } catch (NumberFormatException e) {
            lblError.setText("Load capacity must be numeric.");
            lblError.setForeground(Color.RED); // Set error color to red
            return false;
        }
        return true;
    }
}
