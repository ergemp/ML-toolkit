package org.ergemp.mlt.sentiment.examples;

import org.ergemp.mlt.sentiment.actor.calculate.VNB;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.source.LoadFromFile;

import javax.naming.Name;
import java.util.Iterator;
import java.util.Map;

public class LabelPosNegFromLexicon {
    public static void main(String[] args){
        NamedFreqMatrix lexMatrix = new NamedFreqMatrix();

        lexMatrix = LoadFromFile.load("lexicon_pos_neg");

        Map<String, Double> outClass = VNB.calculate(lexMatrix,"good food but not happy about the rat that ran right up to the middle of the aisle by my table not happy at all i am sad to say this because i sort of liked the place");

        Iterator it = outClass.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " " + pair.getValue().toString());
        }

    }
}
