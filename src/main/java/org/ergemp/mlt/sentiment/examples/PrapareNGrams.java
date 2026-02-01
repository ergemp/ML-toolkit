package org.ergemp.mlt.sentiment.examples;

import org.ergemp.mlt.sentiment.actor.prepare.PrepareBi;
import org.ergemp.mlt.sentiment.actor.prepare.PrepareTri;
import org.ergemp.mlt.sentiment.actor.prepare.PrepareUni;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;

import java.util.Iterator;

public class PrapareNGrams {

    public static void main(String[] args) {
        NamedFreqMatrix matrix = new NamedFreqMatrix();

        PrepareUni.prepare(matrix, "what the fuck");
        PrepareUni.prepare(matrix, "fuck you");
        PrepareBi.prepare(matrix, "what the fuck");
        PrepareBi.prepare(matrix, "fuck you");
        PrepareTri.prepare(matrix, "what the fuck");
        PrepareTri.prepare(matrix, "fuck you");

        Iterator it;
        it = matrix.listUniFreqMatrix.iterator() ;
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
        it = matrix.listBiFreqMatrix.iterator() ;
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
        it = matrix.listTriFreqMatrix.iterator() ;
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}
