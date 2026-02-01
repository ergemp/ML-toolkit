package org.ergemp.mlt.imageOperations.util;

import org.apache.commons.math3.complex.Complex;

import java.util.List;

public class Convert1DListToArray {
    public static double[] convert(List<Double> gList, Integer gLimit){

        double[] retVal = new double[gList.size()];

        for(Integer i=0; i<gList.size() && i< gLimit; i++) {
            retVal[i]=gList.get(i);
        }

        return retVal;
    }

    public static Complex[] convert(List<Complex> gList){

        Complex[] retVal = new Complex[gList.size()];

        for(Integer i=0; i<gList.size(); i++) {
            retVal[i]=gList.get(i);
        }

        return retVal;
    }

}
