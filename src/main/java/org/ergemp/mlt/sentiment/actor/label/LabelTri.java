package org.ergemp.mlt.sentiment.actor.label;

import org.ergemp.mlt.sentiment.model.FreqMatrix;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.util.Concat;
import org.ergemp.mlt.sentiment.util.Contain;

import java.util.HashMap;
import java.util.Map;

public class LabelTri {
    public static NamedFreqMatrix label(NamedFreqMatrix gNamedFreqMatrix, String gStr, String gLabel){
            try
            {
                String[] words = gStr.split(" ");
                String word;

                for (int w = 0; w < words.length - (3) + 1; w++)
                {
                    word = Concat.concat(words, w, w+(3));
                    int index = Contain.contain(gNamedFreqMatrix.listUniFreqMatrix, word);
                    if(index != -1) {

                        if (gNamedFreqMatrix.listTriFreqMatrix.get(index).freq.containsKey(gLabel))
                        {
                            gNamedFreqMatrix.listTriFreqMatrix.get(index).freq.replace(gLabel, gNamedFreqMatrix.listTriFreqMatrix.get(index).freq.get(gLabel)+1);
                        }
                        else
                        {
                            gNamedFreqMatrix.listTriFreqMatrix.get(index).freq.put(gLabel, 1);
                        }
                    }
                    else
                    {
                        Map<String,Integer> tmpFreq = new HashMap();
                        tmpFreq.put(gLabel, 1);

                        gNamedFreqMatrix.listTriFreqMatrix.add(new FreqMatrix(word, tmpFreq));
                    }
                }
                //System.out.println(line);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally {
            return gNamedFreqMatrix;
        }
    }
}
