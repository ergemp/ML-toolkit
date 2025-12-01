package org.ergemp.mlt.imageOperations.util;

import org.apache.commons.math3.complex.Complex;

public class Convert2DArrayTo1DArray {
    public static double[] convert(double[][] gArray) {

        int returnSize = gArray.length * gArray[0].length;

        double[] retVal = new double[returnSize];

        int ii = 0;
        for (int i=0; i< gArray.length; i++) {
            for(int j=0; j<gArray[0].length; j++) {
                retVal[ii] = gArray[i][j];
                ii++;
            }
        }
        return retVal;
    }

    public static Complex[] convert(Complex[][] gArray) {

        int returnSize = gArray.length * gArray[0].length;

        Complex[] retVal = new Complex[returnSize];

        int ii = 0;
        for (int i=0; i< gArray.length; i++) {
            for(int j=0; j<gArray[0].length; j++) {
                retVal[ii] = gArray[i][j];
                ii++;
            }
        }
        return retVal;
    }

}
