package org.ergemp.mlt.sorting.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static List<List<Integer>> singular = new ArrayList<>();
    public static List<List<Integer>> singularTmp = new ArrayList<>();
    public static List<Integer> sorted = new ArrayList<>();

    //divide recursion function
    public static void divide(List<Integer> gList) {
        try {
            if (gList.size() == 1) {
                //System.out.println("return: " + gList.toString());
                singular.add(gList);
            } else {
                //System.out.println("divide: " + gList.subList(0, Math.round(gList.size() / 2)).toString());
                //System.out.println("divide: " + gList.subList(Math.round(gList.size() / 2), gList.size()).toString());
                divide(gList.subList(0, Math.round(gList.size() / 2)));
                divide(gList.subList(Math.round(gList.size() / 2), gList.size()));
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }

    public static void merge () {
        try {
            if (singular.size() == 1) {
                //exit condition from recursive function
                return;
            }
            else {
                while (singular.size() > 0) {
                    //System.out.println(singularTmp.toString());

                    if (singular.size() != 1) {
                        for (Integer i = 1; i < singular.size(); i++) {
                            List<Integer> merged = subMerge(singular.get(i - 1), singular.get(i));
                            singularTmp.add(merged);

                            List<List<Integer>> cTmp = new ArrayList<>();
                            cTmp.add(singular.get(i - 1));
                            cTmp.add(singular.get(i));
                            singular.removeAll(cTmp);
                        }
                    }
                    else {
                        singularTmp.add(singular.get(0));
                        singular.remove(singular.get(0));
                        break;
                    }
                }
                singular = singularTmp;
                merge();
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    //merge function
    //merge two distinct arrayLists
    public static List<Integer> subMerge(List<Integer> gList1, List<Integer> gList2) {
        List<Integer> retVal = new ArrayList<>();

        Integer pointer1 = 0 ;
        Integer pointer2 = 0 ;

        try {
            while (true) {
                //check if one of the lists consumed completely
                if (gList1.size() - (pointer1) == 0) {
                    if (gList2.size() - (pointer2) != 0) {
                        retVal.add(gList2.get(pointer2));
                        pointer2 ++;
                        continue;
                    }
                    else
                    {
                        break;
                    }
                }
                else if (gList2.size() - (pointer2) == 0) {
                    if (gList1.size() - (pointer1) != 0) {
                        retVal.add(gList1.get(pointer1));
                        pointer1 ++;
                        continue;
                    }
                    else {
                        break;
                    }
                }

                //generate sorted and merged list
                if (gList1.get(pointer1) <= gList2.get(pointer2)) {
                    retVal.add(gList1.get(pointer1));
                    pointer1 ++;
                }
                else {
                    retVal.add(gList2.get(pointer2));
                    pointer2 ++;
                }
            }
        }
        catch(IndexOutOfBoundsException iobe) {
            //ex.printStackTrace();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            //singularTmp.add(retVal);
            return retVal;
        }
    }
}