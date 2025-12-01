package org.ergemp.mlt.imageOperations.util;

import org.apache.commons.math3.complex.Complex;

public class Convert1DComplexArray2MagnitudeArray {
    public static Double[] convert(Complex[] gArr){

        Double[] retArr = new Double[gArr.length];

        for (Integer i=0; i<gArr.length; i++){
            retArr[i] = (gArr[i].getReal() * gArr[i].getReal()) + (gArr[i].getImaginary() * gArr[i].getImaginary())  ;
        }
        return retArr;
    }
}
