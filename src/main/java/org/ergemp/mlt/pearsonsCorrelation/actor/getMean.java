package org.ergemp.mlt.pearsonsCorrelation.actor;

import java.util.List;

public class getMean {
    public static Double get(List<Double> gList, Boolean debug){
        Double sum = 0.0;
        for (Double d : gList) {
            sum += d;
        }
        if (debug) {System.out.println(sum / gList.size());}
        return sum / gList.size();
    }
}
