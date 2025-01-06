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
public class MergeSort {

    /**
     * Sorts a list of DroneModel objects by "Location" using the Merge Sort
     * algorithm. The sorting order is determined by the isDesc parameter (true
     * for descending, false for ascending).
     *
     * @param droneList The list of DroneModel objects to sort.
     * @param isDesc If true, sorts in descending order; false for ascending.
     * @return A new sorted list of DroneModel objects.
     * @throws IllegalArgumentException If droneList is null or empty.
     */
    // Sort a list of DroneModel objects based on Location (String) in ascending or descending order
    public List<DroneModel> sortByLocation(List<DroneModel> droneList, boolean isDesc) {
        if (droneList == null || droneList.isEmpty()) {
            throw new IllegalArgumentException("Drone list cannot be null or empty.");
        }

        // Convert the List to an array for merge sort (MergeSort works with arrays)
        List<DroneModel> sortedList = new ArrayList<>(droneList);
        mergeSort(sortedList, 0, sortedList.size() - 1, isDesc);
        return sortedList;
    }

    /**
     * Recursively sorts a list of DroneModel objects using the Merge Sort
     * algorithm. The sorting order is determined by the isDesc parameter (true
     * for descending, false for ascending).
     *
     * @param list The list of DroneModel objects to sort.
     * @param left The starting index of the list to sort.
     * @param right The ending index of the list to sort.
     * @param isDesc If true, sorts in descending order; false for ascending.
     */
    // The mergeSort function recursively splits the list and merges it back
    private void mergeSort(List<DroneModel> list, int left, int right, boolean isDesc) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(list, left, mid, isDesc);   // Sort the left half
            mergeSort(list, mid + 1, right, isDesc); // Sort the right half

            merge(list, left, mid, right, isDesc); // Merge the sorted halves
        }
    }

    /**
     * Merges two sorted halves of a list of DroneModel objects based on the
     * "Location" field. The merge is done in either ascending or descending
     * order, depending on the isDesc parameter.
     *
     * @param list The list of DroneModel objects to merge.
     * @param left The starting index of the left half.
     * @param mid The middle index dividing the two halves.
     * @param right The ending index of the right half.
     * @param isDesc If true, merges in descending order; false for ascending.
     */
    // The merge function combines two sorted halves of the list
    private void merge(List<DroneModel> list, int left, int mid, int right, boolean isDesc) {
        // Temporary arrays for the two halves
        List<DroneModel> leftList = new ArrayList<>(list.subList(left, mid + 1));
        List<DroneModel> rightList = new ArrayList<>(list.subList(mid + 1, right + 1));

        int i = 0, j = 0, k = left;

        // Merge the two halves based on Location (String comparison)
        while (i < leftList.size() && j < rightList.size()) {
            if (shouldSwap(leftList.get(i).getLocation(), rightList.get(j).getLocation(), isDesc)) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }

        // Copy any remaining elements from the left half
        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }

        // Copy any remaining elements from the right half
        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }

    /**
     * Determines whether two locations should be swapped based on the sorting
     * order.
     *
     * @param leftLocation The location of the left DroneModel.
     * @param rightLocation The location of the right DroneModel.
     * @param isDesc If true, swaps for descending order; false for ascending
     * order.
     * @return True if the two locations should be swapped; otherwise, false.
     */
    // Determine whether to swap based on the sorting order (ascending/descending)
    private boolean shouldSwap(String leftLocation, String rightLocation, boolean isDesc) {
        return isDesc ? leftLocation.compareTo(rightLocation) > 0 : leftLocation.compareTo(rightLocation) < 0;
    }
}
