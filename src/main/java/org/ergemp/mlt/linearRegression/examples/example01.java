package org.ergemp.mlt.linearRegression.examples;

import org.ergemp.mlt.linearRegression.actor.Calculator;
import org.ergemp.mlt.linearRegression.model.RegressionModel;

import java.util.Arrays;
import java.util.List;

public class example01 {
    public static void main(String[] args){

        List<Double> arr1 = Arrays.asList(17.0,13.0,12.0,15.0,16.0,14.0,16.0,16.0,18.0,19.0);
        List<Double> arr2 = Arrays.asList(94.0,73.0,59.0,80.0,93.0,85.0,66.0,79.0,77.0,91.0);

        RegressionModel model = Calculator.calculate(arr1,arr2,false);

        System.out.println(model.getY(15.0));

    }
}
