package org.ergemp.mlt.imageOperations.util;

import org.apache.commons.math3.complex.Complex;

public class ConvertComplex2Pixels {
    public static int[][] convert(Complex[][] gArray){

        int[][] retMatrix = new int[gArray.length][gArray.length];

        for (Integer i=0; i<gArray.length; i++) {
            for (Integer j=0; j<gArray[0].length; j++) {

                Integer tt = (int)gArray[i][j].getReal();
                if (tt > 255) {
                    tt = 255;
                }
                else if (tt < 0) {
                    tt = 0;
                }
                retMatrix[i][j] = tt;
            }
        }
        return retMatrix;
    }
}
