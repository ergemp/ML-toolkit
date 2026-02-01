package org.ergemp.mlt.blackjack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm {
    public static Integer findWinningHand(List<List<Integer>> desk){

        Integer retVal = 0;

        try{
            Map<Integer, Integer> totals = getTotals(desk);
            Integer winningIndex = findWinning(totals);

            retVal = winningIndex;
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            return retVal;
        }
    }

    public static Map<Integer, Integer> getTotals(List<List<Integer>> desk){

        Map<Integer, Integer> totals = new HashMap<>();

        try{
            Integer handIndex = 0;

            for (List<Integer> hand: desk) {
                for(Integer each: hand){
                    totals.put(handIndex, totals.getOrDefault(handIndex, 0).intValue() + each);
                }
                handIndex ++ ;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            return totals;
        }
    }

    public static Integer findWinning(Map<Integer, Integer> totals) {

        Integer winningIndex = 0;
        try{
            for (Map.Entry each: totals.entrySet()) {
                if (Integer.parseInt(each.getValue().toString()) > totals.get(winningIndex).intValue()){
                    winningIndex = Integer.parseInt(each.getKey().toString());
                }
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            return winningIndex;
        }
    }
}
