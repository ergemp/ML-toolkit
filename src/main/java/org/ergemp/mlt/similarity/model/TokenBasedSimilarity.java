package org.ergemp.mlt.similarity.model;

import java.util.ArrayList;
import java.util.List;

public class TokenBasedSimilarity {

    private String seperator;

    public TokenBasedSimilarity(String seperator) {
        this.seperator = seperator;
    }

    public double jaccardCoefficient(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        double coef;
        List<String> biGramsOfStr1 = paddedNGramOfString2(str1);
        List<String> biGramsOfStr2 = paddedNGramOfString2(str2);

        coef = (double)intersect(biGramsOfStr1, biGramsOfStr2) / (double)union(biGramsOfStr1, biGramsOfStr2);
        return coef;
    }

    public double diceCoefficient(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        double coef;
        List<String> biGramsOfStr1 = paddedNGramOfString2(str1);
        List<String> biGramsOfStr2 = paddedNGramOfString2(str2);

        System.out.println(biGramsOfStr1.toString());
        System.out.println(biGramsOfStr2.toString());

        coef = (double) 2*intersect(biGramsOfStr1, biGramsOfStr2)/(biGramsOfStr1.size()+biGramsOfStr2.size());
        return coef;
    }

    private int intersect(List<String> str1, List<String> str2) {
        List <String> intersections = new ArrayList<>();
        for(int i=0 ; i<str1.size() ; i++) {
            for(int j=0 ; j<str2.size() ; j++) {
                if(str1.get(i).equals(str2.get(j)))
                    if(!intersections.contains(str1.get(i))) {
                        intersections.add(str1.get(i));
                    }
            }
        }
        return intersections.size();
    }

    private int union(List<String> str1, List<String> str2) {
        return str1.size()+str2.size()-intersect(str1, str2);
    }

    private List<String> nGramsOfString(String str, int n) {
        List<String> nGrams = new ArrayList<>();
        String []words;
        str = str.toLowerCase();
        words = str.split(seperator);
        for(String word: words)
            nGrams.addAll(nGramsOfWord(word, n));
        return nGrams;
    }

    private List<String> paddedNGramOfString(String str, int n) {
        List<String> nGrams = new ArrayList<>();
        String[] words;
        str = str.toLowerCase();
        words = str.split(seperator);
        for(String word: words)
            nGrams.addAll(paddedNGramsOfWord(word, n));
        return nGrams;
    }

    private List<String> paddedNGramOfString2(String str) {
        List<String> nGrams = new ArrayList<>();
        String[] words;
        str = str.toLowerCase();
        words = str.split(seperator);
        for(String word: words)
            nGrams.add(word);
        return nGrams;
    }

    private static List<String> nGramsOfWord(String word, int n) {
        List<String> nGrams = new ArrayList<>();
        for (int i = 0; i < word.length() - n + 1; i++) {
            nGrams.add(word.substring(i, i+n));
        }
        return nGrams;
    }

    private static List<String> paddedNGramsOfWord(String word, int n) {
        List<String> nGrams = new ArrayList<>();
        nGrams.add("_" + word.charAt(0));
        for (int i = 0; i < word.length() - n + 1; i++) {
            nGrams.add(word.substring(i, i+n));
        }
        nGrams.add(word.charAt(word.length()-1) + "_");
        return nGrams;
    }
}
