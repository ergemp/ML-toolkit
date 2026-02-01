package org.ergemp.mlt.imageOperations.util;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class GetLargestN {

    // thanks to gfg
    // ref: https://www.geeksforgeeks.org/dsa/kth-largest-element-in-an-array/

    public static Double[] getLargestNUsingHeap(Double[] arr, Integer gMany) {
        // Create a min-heap (PriorityQueue)
        PriorityQueue<Double> minHeap = new PriorityQueue<>();

        for (double number : arr) {
            if (minHeap.size() < gMany) {
                minHeap.add(number);
            } else if (number > minHeap.peek()) {
                minHeap.poll(); // Remove the smallest element
                minHeap.add(number); // Add the larger element
            }
        }

        // Convert the heap elements to an array
        Double[] largestTen = new Double[minHeap.size()];
        int i = minHeap.size() - 1;
        while (!minHeap.isEmpty()) {
            largestTen[i--] = minHeap.poll();
        }
        return largestTen;
    }

    // Function to perform quick select
    // [QuickSelect] Works Best in Practice - O(n) on average time and O(n) space
    public static double quickSelect(List<Double> arr, int k) {

        // Randomly select a pivot index
        int pivotIdx = new Random().nextInt(arr.size());

        // Get the pivot value
        double pivot = arr.get(pivotIdx);

        // For elements greater than the pivot
        List<Double> leftArr = new ArrayList<>();

        // For elements equal to the pivot
        List<Double> midArr = new ArrayList<>();

        // For elements less than the pivot
        List<Double> rightArr = new ArrayList<>();

        // Partitioning the array based on the pivot
        for (double val : arr) {
            if (val > pivot) {
                leftArr.add(val);
            } else if (val < pivot) {
                rightArr.add(val);
            } else {
                midArr.add(val);
            }
        }

        // Recursive selection
        if (k <= leftArr.size()) {
            return quickSelect(leftArr, k);
        }
        if (leftArr.size() + midArr.size() < k) {
            return quickSelect(rightArr, k - leftArr.size()
                    - midArr.size());
        }

        // Return pivot as the k-th largest
        return pivot;
    }

    public static double KthLargest(Double[] arr, int k) {
        List<Double> arrList = new ArrayList<>();
        for (double val : arr) {
            arrList.add(val);
        }
        return quickSelect(arrList, k);
    }
}
