package org.ergemp.mlt.sentiment.actor.label;

import org.ergemp.mlt.sentiment.model.FreqMatrix;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.util.Concat;
import org.ergemp.mlt.sentiment.util.Contain;

import java.util.HashMap;
import java.util.Map;

public class LabelUni {
    public static NamedFreqMatrix label(NamedFreqMatrix gNamedFreqMatrix, String gStr, String gLabel){
        try {
            String[] words = gStr.split(" ");
            String word;

            for (int w = 0; w < words.length - (1) + 1; w++)
            {
                word = Concat.concat(words, w, w + (1));
                int index = Contain.contain(gNamedFreqMatrix.listUniFreqMatrix, word);
                if(index != -1) {

                    if (gNamedFreqMatrix.listUniFreqMatrix.get(index).freq.containsKey(gLabel))
                    {
                        gNamedFreqMatrix.listUniFreqMatrix.get(index).freq.replace(gLabel, gNamedFreqMatrix.listUniFreqMatrix.get(index).freq.get(gLabel)+1);
                    }
                    else
                    {
                        gNamedFreqMatrix.listUniFreqMatrix.get(index).freq.put(gLabel, 1);
                    }
                }
                else
                {
                    Map<String,Integer> tmpFreq = new HashMap();
                    tmpFreq.put(gLabel, 1);

                    gNamedFreqMatrix.listUniFreqMatrix.add(new FreqMatrix(word, tmpFreq));
                }
            }
            //System.out.println(line);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally{
            return gNamedFreqMatrix;
        }
    }
}
