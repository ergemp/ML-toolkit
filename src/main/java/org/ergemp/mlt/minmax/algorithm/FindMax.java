package org.ergemp.mlt.minmax.algorithm;

import java.util.List;

public class FindMax {
    public static Double find(List<Double> gList){
        Double retVal = 0.0;
        try {
            for (Double item: gList) {
                if (item > retVal){
                    retVal = item;
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            return retVal;
        }
    }
}
