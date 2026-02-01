package org.ergemp.mlt.sorting.examples;

import org.ergemp.mlt.sorting.algorithm.SelectionSort;

import java.util.ArrayList;
import java.util.List;

public class SelectionSortUsage {
    public static void main(String[] args){

        //total time n2

        Integer arr[] = {64,25,12,22,11,5,4,9,10,2,3,7,6};
        List<Integer> llist = new ArrayList<>();

        for (Integer i=0; i<arr.length; i++){
            llist.add(arr[i]);
        }

        List<Integer> sortedLlist = SelectionSort.sort(llist);
        System.out.println(sortedLlist.toString());
    }
}
