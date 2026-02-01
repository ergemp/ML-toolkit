package org.ergemp.mlt.sentiment.examples;

import org.ergemp.mlt.sentiment.actor.Print;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.source.LoadFromFile;

public class LoadNgramsFromFile {
    public static void main(String[] args){
        NamedFreqMatrix myMatrix = new NamedFreqMatrix();
        myMatrix = LoadFromFile.load("ngrams");
        Print.print(myMatrix);
    }
}
