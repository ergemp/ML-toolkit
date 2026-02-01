package org.ergemp.mlt.sentiment.actor.prepare;

import org.ergemp.mlt.sentiment.model.FreqMatrix;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.util.Concat;
import org.ergemp.mlt.sentiment.util.Contain;

import java.util.HashMap;
import java.util.Map;

public class PrepareBi {
    public static NamedFreqMatrix prepare(NamedFreqMatrix gNamedFreqMatrix, String gStr) {
        try {
            String[] words = gStr.split(" ");
            String word;

            for (int w = 0; w < words.length - (2) + 1; w++)
            {
                word = Concat.concat(words, w, w + (2));
                int index = Contain.contain(gNamedFreqMatrix.listBiFreqMatrix, word);
                if(index != -1) {

                    if (gNamedFreqMatrix.listBiFreqMatrix.get(index).freq.containsKey(word))
                    {
                        gNamedFreqMatrix.listBiFreqMatrix.get(index).freq.replace(word, gNamedFreqMatrix.listBiFreqMatrix.get(index).freq.get(word)+1);
                    }
                    else
                    {
                        gNamedFreqMatrix.listBiFreqMatrix.get(index).freq.put(word, 1);
                    }
                }
                else
                {
                    Map<String,Integer> tmpFreq = new HashMap();
                    tmpFreq.put(word, 1);

                    gNamedFreqMatrix.listBiFreqMatrix.add(new FreqMatrix(word, tmpFreq));
                }
            }
            //System.out.println(line);
        }
        catch(Exception Ex)
        {
            System.out.println(Ex);
        }
        finally{
            return gNamedFreqMatrix;
        }
    }
}
