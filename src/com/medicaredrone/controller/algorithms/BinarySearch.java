/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medicaredrone.controller.algorithms;

import com.medicaredrone.model.DroneModel;
import javax.swing.JOptionPane;
import java.util.List;

/**
 *
 * @author Suman lama 23048591
 */
public class BinarySearch {

    /**
     * Performs a binary search to find a DroneModel in a list based on a
     * specified search value and column. The method searches through the list
     * of drones sorted by the specified column and returns the corresponding
     * DroneModel object if a match is found. If no match is found, the method
     * returns null.
     *
     * @param searchValue The value to search for in the specified column.
     * @param searchColumn The column name (field) to search by. Supported
     * columns are "Drone ID", "ItemName", and "Location".
     * @param droneList The list of DroneModel objects to search through.
     * @param left The left boundary index of the search range.
     * @param right The right boundary index of the search range.
     *
     * @return The DroneModel object that matches the search value in the
     * specified column, or null if no match is found.
     *
     * This method uses binary search to efficiently search through the sorted
     * list of DroneModel objects. The search works differently depending on the
     * type of data in the search column: - For "Drone ID" (numeric), the search
     * compares integer values. - For "ItemName" and "Location" (string), the
     * search compares the values lexicographically (case-insensitive).
     *
     * If an invalid input is entered for "Drone ID" (non-numeric), an error
     * message is shown to the user via a JOptionPane.
     *
     * Example: searchByField("1234", "Drone ID", droneList, 0, droneList.size()
     * - 1); // Searches for Drone ID 1234. searchByField("Medical Supplies",
     * "ItemName", droneList, 0, droneList.size() - 1); // Searches for "Medical
     * Supplies".
     */
    // Generic binary search method
    public DroneModel searchByField(String searchValue, String searchColumn, List<DroneModel> droneList, int left, int right) {
        if (right < left) {
            return null; // Element not found
        }

        int mid = (left + right) / 2;

        // Get the value based on the selected column
        String midValue = getFieldValue(droneList.get(mid), searchColumn);

        // Handle numeric comparisons for Drone ID
        if (searchColumn.equals("Drone ID")) {
            try {
                int searchInt = Integer.parseInt(searchValue); // Convert the search value to an integer
                int midInt = Integer.parseInt(midValue); // Convert mid value (Drone ID) to integer

                if (searchInt == midInt) { // Match found
                    return droneList.get(mid);
                } else if (searchInt < midInt) { // Search left half
                    return searchByField(searchValue, searchColumn, droneList, left, mid - 1);
                } else { // Search right half
                    return searchByField(searchValue, searchColumn, droneList, mid + 1, right);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input for Drone ID. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }

        // Handle string comparisons for ItemName and Location
        if (searchColumn.equals("ItemName") || searchColumn.equals("Location")) {
            int comparison = searchValue.compareToIgnoreCase(midValue);
            if (comparison == 0) { // Match found
                return droneList.get(mid);
            } else if (comparison < 0) { // Search left half
                return searchByField(searchValue, searchColumn, droneList, left, mid - 1);
            } else { // Search right half
                return searchByField(searchValue, searchColumn, droneList, mid + 1, right);
            }
        }

        // Default case (string comparison for other fields, if needed)
        int comparison = searchValue.compareToIgnoreCase(midValue);
        if (comparison == 0) { // Match found
            return droneList.get(mid);
        } else if (comparison < 0) { // Search left half
            return searchByField(searchValue, searchColumn, droneList, left, mid - 1);
        } else { // Search right half
            return searchByField(searchValue, searchColumn, droneList, mid + 1, right);
        }
    }

    /**
     * Helper method to fetch the value of a specified column from a DroneModel
     * object. This method is used to retrieve data for a particular column in
     * the drone data table. The method checks the column name and returns the
     * corresponding value from the DroneModel instance.
     *
     * @param drone The DroneModel object containing drone data.
     * @param columnName The name of the column whose value is to be fetched.
     *
     * @return A string representing the value of the specified column. If the
     * column name is unsupported, an empty string is returned.
     *
     * Supported columns: - "Drone ID" : Drone's unique identifier. - "Status" :
     * Current status of the drone. - "RequesterName" : Name of the requester. -
     * "ItemName" : Name of the item being transported by the drone. -
     * "Location" : Current location of the drone. - "EmergencyContact" :
     * Contact information for emergencies. - "WeatherCondition" : Current
     * weather conditions affecting the drone. - "LoadCapacity(kg)" : The load
     * capacity of the drone in kilograms.
     *
     * Example: getFieldValue(drone, "Status"); // Returns the current status of
     * the drone as a string.
     */
    // Helper method to fetch value based on selected column
    private String getFieldValue(DroneModel drone, String columnName) {
        switch (columnName) {
            case "Drone ID":
                return String.valueOf(drone.getDroneId()); // Convert integer to string
            case "Status":
                return drone.getStatus();
            case "RequesterName":
                return drone.getRequesterName();
            case "ItemName":
                return drone.getItemName();
            case "Location":
                return drone.getLocation();
            case "EmergencyContact":
                return drone.getEmergencyContact();
            case "WeatherCondition":
                return drone.getWeatherCondition();
            case "LoadCapacity(kg)":
                return String.valueOf(drone.getLoadCapacity());
            default:
                return ""; // Default case for unsupported columns
        }
    }
}
