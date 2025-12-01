package org.ergemp.mlt.imageOperations.util;

import java.util.ArrayList;
import java.util.List;

public class Transpose2DDoubleArray {
    public static List<List<Double>> transpose(List<List<Double>> gArray){

        List<List<Double>> retVal = new ArrayList<>();


        for (Integer i=0; i<gArray.get(0).size(); i++){

            List<Double> ttRow = new ArrayList<>();
            for (Integer j=0; j<gArray.size(); j++){

                ttRow.add(gArray.get(j).get(i));

            }
            retVal.add(ttRow);
        }

        return retVal;
    }
}
