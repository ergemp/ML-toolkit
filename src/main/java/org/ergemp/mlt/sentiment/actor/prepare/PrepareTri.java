package org.ergemp.mlt.sentiment.actor.prepare;

import org.ergemp.mlt.sentiment.model.FreqMatrix;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.util.Concat;
import org.ergemp.mlt.sentiment.util.Contain;

import java.util.HashMap;
import java.util.Map;

public class PrepareTri {

    public static NamedFreqMatrix prepare(NamedFreqMatrix gNamedFreqMatrix, String gStr)
    {
        try
        {
            String[] words = gStr.split(" ");
            String word;

            for (int w = 0; w < words.length - (3) + 1; w++)
            {
                word = Concat.concat(words, w, w + (3));
                int index = Contain.contain(gNamedFreqMatrix.listUniFreqMatrix, word);
                if(index != -1) {

                    if (gNamedFreqMatrix.listTriFreqMatrix.get(index).freq.containsKey(word))
                    {
                        gNamedFreqMatrix.listTriFreqMatrix.get(index).freq.replace(word, gNamedFreqMatrix.listTriFreqMatrix.get(index).freq.get(word)+1);
                    }
                    else
                    {
                        gNamedFreqMatrix.listTriFreqMatrix.get(index).freq.put(word, 1);
                    }
                }
                else
                {
                    Map<String,Integer> tmpFreq = new HashMap();
                    tmpFreq.put(word, 1);

                    gNamedFreqMatrix.listTriFreqMatrix.add(new FreqMatrix(word, tmpFreq));
                }
            }
            //System.out.println(line);
        }
        catch(Exception Ex)
        {
            System.out.println(Ex);
        }
        finally {
            return gNamedFreqMatrix;
        }
    }

}
