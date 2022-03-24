package org.ergemp.mlt.similarity.examples;

import org.ergemp.mlt.similarity.model.EditBasedSimilarity;
import org.ergemp.mlt.similarity.model.TokenBasedSimilarity;

public class CommonExample {
    public static void main(String[] args) {
        TokenBasedSimilarity tSim = new TokenBasedSimilarity(" ");
        Double ttDice = tSim.diceCoefficient("hellori hazretleri muhittin", "ergem hellori rabia");
        System.out.println("Dice Coeff: " + ttDice.toString());

        Double ttJaccard = tSim.jaccardCoefficient("hellori hazretleri muhittin", "ergem hellori rabia");
        System.out.println("Jackard Coeff: " + ttJaccard.toString());

        EditBasedSimilarity eSim = new EditBasedSimilarity();
        Double tt2 = eSim.levenstheinSimilarity("hellori hazretleri ergem", "ergem hellori");
        System.out.println("Levensthein Coeff: " + tt2.toString());

        /*
        0.7272727272727273
        0.5384615384615384
        */
    }
}
