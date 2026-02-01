package org.ergemp.mlt.sentiment.actor.calculate;

import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.util.Concat;
import org.ergemp.mlt.sentiment.util.Contain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VNB {
    public static Map<String, Double> calculate(NamedFreqMatrix gNamedFreqMatrix, String gSample){
        Map<String, Double> weights = new HashMap<String, Double>();

        Double totalScore = 0.00;
        String[] words = gSample.split(" ");
        String word;

        ////////////////////
        //calculate uniGrams
        ////////////////////
        for (int i = 0; i < words.length - (1) + 1; i++)
        {
            word = Concat.concat(words, i, i+(1));

            int index = Contain.contain(gNamedFreqMatrix.listUniFreqMatrix, word);

            if(index != -1)
            {
                Iterator it = gNamedFreqMatrix.listUniFreqMatrix.get(index).freq.entrySet().iterator() ;
                while (it.hasNext())
                {
                    Map.Entry pair = (Map.Entry)it.next();

                    if (weights.containsKey(pair.getKey()))
                    {
                        //weights.replace(pair.getKey().toString(), weights.get(pair.getKey())+1 / listUniFreqMatrix.size());

                        int tmpInt = Integer.parseInt(pair.getValue().toString());

                        weights.replace(pair.getKey().toString(), weights.get(pair.getKey()) + (double)tmpInt);
                        totalScore += (Integer)pair.getValue();
                    }
                    else
                    {
                        weights.put(pair.getKey().toString(), (Integer)pair.getValue() + 0.00);
                        totalScore += (Integer)pair.getValue();
                    }
                }
            }
        }

        ///////////////////
        //calculate BiGrams
        ///////////////////
        for (int i = 0; i < words.length - (2) + 1; i++)
        {
            word = Concat.concat(words, i, i+(2));

            int index = Contain.contain(gNamedFreqMatrix.listBiFreqMatrix, word);

            if(index != -1)
            {
                Iterator it = gNamedFreqMatrix.listBiFreqMatrix.get(index).freq.entrySet().iterator() ;
                while (it.hasNext())
                {
                    Map.Entry pair = (Map.Entry)it.next();

                    if (weights.containsKey(pair.getKey()))
                    {
                        //weights.replace(pair.getKey().toString(), weights.get(pair.getKey())+1 / listBiFreqMatrix.size());

                        int tmpInt = Integer.parseInt(pair.getValue().toString());

                        weights.replace(pair.getKey().toString(), weights.get(pair.getKey()) + (double)tmpInt );
                        totalScore += 1;
                    }
                    else
                    {
                        weights.put(pair.getKey().toString(), 1.0);
                        totalScore += 1;
                    }
                }
            }
        }

        ////////////////////
        //calculate TriGrams
        ////////////////////
        for (int i = 0; i < words.length - (3) + 1; i++)
        {
            word = Concat.concat(words, i, i+(3));

            int index = Contain.contain(gNamedFreqMatrix.listTriFreqMatrix, word);

            if(index != -1)
            {
                Iterator it = gNamedFreqMatrix.listTriFreqMatrix.get(index).freq.entrySet().iterator() ;
                while (it.hasNext())
                {
                    Map.Entry pair = (Map.Entry)it.next();
                    if (weights.containsKey(pair.getKey()))
                    {
                        //weights.replace(pair.getKey().toString(), weights.get(pair.getKey())+1 / listTriFreqMatrix.size());
                        int tmpInt = Integer.parseInt(pair.getValue().toString());

                        weights.replace(pair.getKey().toString(), weights.get(pair.getKey()) + tmpInt );
                        totalScore += 1;
                    }
                    else
                    {
                        weights.put(pair.getKey().toString(), 1.00);
                        totalScore += 1;
                    }
                }
            }
        }

        Iterator it2 = weights.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry pair = (Map.Entry)it2.next();
            if(!pair.getKey().toString().equalsIgnoreCase("Total")) {
                weights.replace(pair.getKey().toString(), (Double)pair.getValue()/totalScore);
            }
        }

        return weights;
    }
}