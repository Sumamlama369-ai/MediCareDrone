/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.medicaredrone.controller.algorithms;

import com.medicaredrone.model.DroneModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Suman lama 23048591
 */
public class InsertionSort {

    List<DroneModel> droneSortList;

    public InsertionSort() {
        droneSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of DroneModel objects by their ItemName in ascending or
     * descending order.
     *
     * @param droneList the list of DroneModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<DroneModel> sortByItemName(List<DroneModel> droneList, boolean isDesc) {
        this.droneSortList.clear();
        this.droneSortList.addAll(droneList);

        if (droneSortList == null || droneSortList.isEmpty()) {
            throw new IllegalArgumentException("Drone list cannot be null or empty.");
        }

        // Insertion sort algorithm
        for (int i = 1; i < droneSortList.size(); i++) {
            DroneModel currentDrone = droneSortList.get(i);
            int j = i - 1;

            // Move elements that are greater than currentDrone (or less, based on order)
            while (j >= 0 && shouldSwap(currentDrone.getItemName(), droneSortList.get(j).getItemName(), isDesc)) {
                droneSortList.set(j + 1, droneSortList.get(j));
                j = j - 1;
            }
            droneSortList.set(j + 1, currentDrone);
        }

        return droneSortList;
    }

    /**
     * Determines whether the current ItemName should be swapped based on the
     * order.
     *
     * @param current the current ItemName value
     * @param comparison the ItemName to compare with
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current ItemName should be swapped; false otherwise
     */
    private boolean shouldSwap(String current, String other, boolean isDesc) {
        int comparisonResult = current.compareTo(other);//lexicographical comparison
        return isDesc ? comparisonResult > 0 : comparisonResult < 0;
    }
}
