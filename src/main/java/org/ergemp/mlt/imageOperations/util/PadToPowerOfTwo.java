package org.ergemp.mlt.imageOperations.util;

import org.apache.commons.math3.complex.Complex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PadToPowerOfTwo {
    public static List<Double> padLower (List<Double> gData) {

            int res = 0;
            for(int i = gData.size(); i >= 1; i--)
            {
                // If i is a power of 2
                if ((i & (i-1)) == 0)
                {
                    res = i;
                    break;
                }
            }

            return gData.subList(0,res);
    }

    public static Complex[] padLower (Complex[] gData) {

        int res = 0;
        for(int i = gData.length; i >= 1; i--)
        {
            // If i is a power of 2
            if ((i & (i-1)) == 0)
            {
                res = i;
                break;
            }
        }

        return Arrays.copyOf(gData, res);
    }

    public static List<Double> padUpper (List<Double> gData) {

        List<Double> retList = new ArrayList<>();
        List<Double> addOnList = new ArrayList<>();

        int res = 0;
        int limit = gData.size()*2;

        for(int i = limit; i >= 1; i--)
        {
            // If i is a power of 2
            if ((i & (i-1)) == 0)
            {
                res = i;
                break;
            }
        }

        for (Integer i=0; i<res - gData.size(); i++){
            addOnList.add(0.0);
        }

        retList.addAll(gData);
        retList.addAll(addOnList);

        return retList;
    }

}
