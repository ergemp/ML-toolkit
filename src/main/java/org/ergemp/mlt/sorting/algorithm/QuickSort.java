package org.ergemp.mlt.sorting.algorithm;

import java.util.ArrayList;
import java.util.List;

//randomize recursive sorting
public class QuickSort {

    public static List<List<Integer>> singular = new ArrayList<>();
    public static List<Integer> sorted = new ArrayList<>();

    public static void divide(List<Integer> gList) {
        Integer iindex = 0;
        Integer ppivot ;
        List<Integer> nList1 = new ArrayList<>();
        List<Integer> nList2 = new ArrayList<>();

        try {
            if (gList.size() != 1) {
                iindex = (int) Math.floor(Math.random() * gList.size());
                ppivot = gList.get(iindex);
                //System.out.println(ppivot);

                for (Integer i = 0; i < gList.size(); i++) {
                    if (gList.get(i) <= ppivot) {
                        nList1.add(gList.get(i));
                    } else {
                        nList2.add(gList.get(i));
                    }
                }

                if (nList1.size() != 0) {
                    //System.out.println(nList1.toString());
                    divide(nList1);
                }

                if (nList2.size() != 0) {
                    //System.out.println(nList2.toString());
                    divide(nList2);
                }
            }
            else {
                singular.add(gList);
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }

    public static void merge() {
        for(Integer i=0; i<singular.size(); i++){
            sorted.add(singular.get(i).get(0));
        }
    }
}
