package org.ergemp.mlt.pearsonsCorrelation.examples;

import org.ergemp.mlt.pearsonsCorrelation.actor.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculateCoeffExample {
    public static void main(String[] args){

        List<Double> arr1 = Arrays.asList(17.0,13.0,12.0,15.0,16.0,14.0,16.0,16.0,18.0,19.0);
        List<Double> arr2 = Arrays.asList(94.0,73.0,59.0,80.0,93.0,85.0,66.0,79.0,77.0,91.0);

        System.out.println(Calculator.calculate(arr1, arr2, false));

    }
}
