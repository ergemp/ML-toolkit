package org.ergemp.mlt.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<List<Integer>> desk = new ArrayList<List<Integer>>();

        List<Integer> hand1 = new ArrayList<>();
        hand1.add(1);
        hand1.add(10);

        List<Integer> hand2 = new ArrayList<>();
        hand2.add(4);
        hand2.add(8);

        desk.add(hand1);
        desk.add(hand2);

        Integer winningHand = Algorithm.findWinningHand(desk);

        System.out.println("the desk: " + desk.toString());
        System.out.println("winningIndex: " + winningHand + " - " + desk.get(winningHand));
    }
}
