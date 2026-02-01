package org.ergemp.mlt.sorting.algorithm;

import java.util.List;

public class BubbleSort {
    public static List<Integer> sort(List<Integer> gList) {
        try {
            Boolean checkSwap = false;

            for (Integer i=0; i<gList.size()-1 ; i++) {
                if (gList.get(i) > gList.get(i + 1)) {

                    Integer tmp1 ;
                    Integer tmp2 ;
                    tmp1 = gList.get(i+1);
                    tmp2 = gList.get(i);

                    gList.remove(tmp1);
                    gList.remove(tmp2);

                    gList.add(i, tmp1);
                    gList.add(i+1, tmp2);

                    checkSwap=true;
                }
            }

            //System.out.println(gList.toString());
            if (checkSwap){
                sort(gList);
            }
            else {
                return gList;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            return gList;
        }
    }
}


