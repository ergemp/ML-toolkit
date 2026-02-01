package org.ergemp.mlt.sorting.algorithm;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {
    public static List<Integer> sort(List<Integer> gList) {
        List<Integer> retVal = new ArrayList<>();

        Integer tmpVal = null ;
        Integer tmpIndex = null ;

        try {
            while (gList.size() != 0) {
                tmpVal = null;
                for (Integer i = 0; i < gList.size(); i++) {

                    if (tmpVal != null) {
                        if (tmpVal >= gList.get(i)) {
                            tmpVal = gList.get(i);
                            tmpIndex = i;
                        }
                    } else {
                        tmpVal = gList.get(i);
                        tmpIndex = i;
                    }
                }
                retVal.add(tmpVal);
                gList.remove(tmpVal);

                //System.out.println(retVal.toString());
                //System.out.println(gList.toString());
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally{
            return retVal;
        }
    }
}
