package org.ergemp.mlt.sentiment.model;

import java.util.Iterator;
import java.util.Map;

public class FreqMatrix {
    public String word;
    public Map<String, Integer> freq ;

    public FreqMatrix(String gword, Map<String, Integer> gfreq)
    {
        this.word=gword;
        this.freq=gfreq;
    }

    @Override
    public String toString() {
        String retVal = "";
        try {
            retVal += "\"word\":\"" + word + "\",";

            Iterator<Map.Entry<String, Integer>> it = freq.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<String, Integer> entry = it.next();

                retVal += "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\",";
            }

            retVal = "{" + retVal.substring(0,retVal.length()-1) + "}";

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            return retVal;
        }
    }
}
