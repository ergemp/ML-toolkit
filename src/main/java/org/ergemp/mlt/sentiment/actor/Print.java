package org.ergemp.mlt.sentiment.actor;

import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;

import java.util.Iterator;
import java.util.Map;

public class Print {
    //pretty print the namedFreqMatrix
    public static void print(NamedFreqMatrix gNamedFreqmatrix){
        System.out.println("-------------");
        System.out.println("Print UniGram");
        System.out.println("-------------");

        for (Integer c=0; c < gNamedFreqmatrix.listUniFreqMatrix.size() ; c++)
        {
            Iterator it = gNamedFreqmatrix.listUniFreqMatrix.get(c).freq.entrySet().iterator() ;

            System.out.println(gNamedFreqmatrix.listUniFreqMatrix.get(c).word);

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                System.out.println("\t" + pair.getKey() + " = " + pair.getValue());
                //it.remove();
            }
        }

        System.out.println("-------------");
        System.out.println("Print BiGram");
        System.out.println("-------------");
        for (Integer c=0; c < gNamedFreqmatrix.listBiFreqMatrix.size() ; c++)
        {
            Iterator it = gNamedFreqmatrix.listBiFreqMatrix.get(c).freq.entrySet().iterator() ;

            System.out.println(gNamedFreqmatrix.listBiFreqMatrix.get(c).word);

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                System.out.println("\t" + pair.getKey() + " = " + pair.getValue());
                //it.remove();
            }
        }

        System.out.println("-------------");
        System.out.println("Print TriGram");
        System.out.println("-------------");
        for (Integer c=0; c < gNamedFreqmatrix.listTriFreqMatrix.size() ; c++)
        {
            Iterator it = gNamedFreqmatrix.listTriFreqMatrix.get(c).freq.entrySet().iterator() ;

            System.out.println(gNamedFreqmatrix.listTriFreqMatrix.get(c).word);

            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                System.out.println("\t" + pair.getKey() + " = " + pair.getValue());
                //it.remove();
            }
        }
    }
}
