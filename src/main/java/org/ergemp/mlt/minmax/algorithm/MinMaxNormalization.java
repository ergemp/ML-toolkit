package org.ergemp.mlt.minmax.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MinMaxNormalization {
    public static List<Double> normalize(List<Double> gList){
        List<Double> retVal = new ArrayList<>();
        try {
            Double max = FindMax.find(gList);
            Double min = FindMin.find(gList);

            for(Double item: gList) {
                retVal.add((item-min)/max-min);
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
