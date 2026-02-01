package org.ergemp.mlt.sentiment.actor.calculate;

import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.util.Concat;
import org.ergemp.mlt.sentiment.util.Contain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class UniGrams {
    public static void calculate(NamedFreqMatrix gNamedFreqMatrix, String gText) {

        Map<String, Double> weights = new HashMap<String, Double>();

        Double totalScore = 0.00;
        String[] words = gText.split(" ");
        String word;

        //calculate uniGrams
        for (int i = 0; i < words.length - (1) + 1; i++) {
            word = Concat.concat(words, i, i + (1));

            int index = Contain.contain(gNamedFreqMatrix.listUniFreqMatrix, word);

            if(index != -1) {
                Iterator it = gNamedFreqMatrix.listUniFreqMatrix.get(index).freq.entrySet().iterator() ;
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();

                    if (weights.containsKey(pair.getKey())) {
                        //weights.replace(pair.getKey().toString(), weights.get(pair.getKey())+1 / listUniFreqMatrix.size());

                        int tmpInt = Integer.parseInt(pair.getValue().toString());

                        weights.replace(pair.getKey().toString(), weights.get(pair.getKey()) + (double)tmpInt);
                        totalScore += (Integer)pair.getValue();
                    }
                    else {
                        weights.put(pair.getKey().toString(), (Integer)pair.getValue() + 0.00);
                        totalScore += (Integer)pair.getValue();
                    }
                }
            }
        }
    }
}
