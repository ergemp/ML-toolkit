package org.ergemp.mlt.sentiment.util;

import org.ergemp.mlt.sentiment.model.FreqMatrix;

import java.util.List;

public class Contain {
    public static int contain(List<FreqMatrix> listOfWords, String word) {
        for(int i=0 ; i < listOfWords.size() ; i++) {
            if(listOfWords.get(i).word.equalsIgnoreCase(word))	//equals vs contains
                return i;
        }
        return -1;
    }
}
