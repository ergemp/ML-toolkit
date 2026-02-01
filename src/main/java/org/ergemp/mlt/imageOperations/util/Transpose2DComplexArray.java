package org.ergemp.mlt.imageOperations.util;

import org.apache.commons.math3.complex.Complex;

public class Transpose2DComplexArray {
    public static Complex[][] transpose(Complex[][] gArray){

        Complex[][] transposedMatrix = new Complex[gArray.length][gArray.length];

        for(Integer i=0; i< gArray.length; i++){
            for (Integer j=0; j< gArray[0].length; j++) {

                transposedMatrix[j][i] = gArray[i][j];
            }
        }
        return transposedMatrix;
    }
}
