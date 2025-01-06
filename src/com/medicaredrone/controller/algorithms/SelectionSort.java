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
 * @author Suman Lama 23048591
 */
public class SelectionSort {

    List<DroneModel> droneSortList;

    public SelectionSort() {
        droneSortList = new ArrayList<>();
    }

    /**
     * Sorts a list of DroneModel objects by their Drone ID in ascending or
     * descending order.
     *
     * @param droneList the list of DroneModel objects to be sorted
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return the sorted list
     */
    public List<DroneModel> sortByDroneId(List<DroneModel> droneList, boolean isDesc) {
        this.droneSortList.clear();
        this.droneSortList.addAll(droneList);

        if (droneSortList == null || droneSortList.isEmpty()) {
            throw new IllegalArgumentException("Drone list cannot be null or empty.");
        }

        // Selection sort algorithm
        for (int i = 0; i < droneSortList.size() - 1; i++) {
            int extremumIndex = findExtremumIndex(droneSortList, i, isDesc);
            if (i != extremumIndex) {
                swap(droneSortList, i, extremumIndex);
            }
        }

        return droneSortList;
    }

    /**
     * Finds the index of the extremum value (minimum or maximum) in the list
     * from the start index.
     *
     * @param droneSortList the list of DroneModel objects
     * @param startIndex the index to start searching from
     * @param isDesc specifies whether to find the maximum (true) or minimum
     * (false)
     * @return the index of the extremum value
     */
    private int findExtremumIndex(List<DroneModel> droneSortList, int startIndex, boolean isDesc) {
        int extremumIndex = startIndex;

        for (int j = startIndex + 1; j < droneSortList.size(); j++) {
            if (shouldSwap(droneSortList.get(j).getDroneId(), droneSortList.get(extremumIndex).getDroneId(), isDesc)) {
                extremumIndex = j;
            }
        }

        return extremumIndex;
    }

    /**
     * Determines whether the current value should replace the current extremum
     * based on sort order.
     *
     * @param current the current value
     * @param extremum the current extremum value
     * @param isDesc specifies the sort order (true for descending, false for
     * ascending)
     * @return true if the current value should replace the extremum; false
     * otherwise
     */
    private boolean shouldSwap(int current, int extremum, boolean isDesc) {
        return isDesc ? current > extremum : current < extremum;
    }

    /**
     * Swaps two elements in the list.
     *
     * @param droneSortList the list of DroneModel objects
     * @param i the index of the first element
     * @param j the index of the second element
     */
    private void swap(List<DroneModel> droneSortList, int i, int j) {
        DroneModel temp = droneSortList.get(i);
        droneSortList.set(i, droneSortList.get(j));
        droneSortList.set(j, temp);
    }
}
