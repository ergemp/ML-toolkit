package org.ergemp.mlt.sorting.examples;

import org.ergemp.mlt.sorting.algorithm.MergeSort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortUsage {
    public static void main(String[] args){
        Integer arr[] = {64,25,12,22,11,5,4,9,10,2,3,7,6};
        List<Integer> llist = new ArrayList<>();

        for (Integer i=0; i<arr.length; i++){
            llist.add(arr[i]);
        }
        System.out.println("main: " + llist.toString());

        MergeSort.divide(llist);
        System.out.println("main: " + MergeSort.singular.toString());

        MergeSort.merge();
        System.out.println("main: " + MergeSort.singularTmp.toString());
    }
}
