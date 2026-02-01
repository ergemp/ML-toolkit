package org.ergemp.mlt.similarity.model;

import java.util.Date;
import java.time.LocalDate;

public class EditBasedSimilarity {
    private int steps;  //distance
    private double relative;    //steps/|longer string|
    private double similarity;  //1-relative

    public EditBasedSimilarity() {
    }

    public int hammingDistance(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int dist=0;
        if(str1.length() != str2.length())
            return -1;
        for(int i=0 ; i<str1.length() ; i++) {
            if(str1.charAt(i) != str2.charAt(i))
                dist++;
        }
        return dist;
    }

    public double damerauLevenstheinSimilarity(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        steps = damerauLevenstheinDistance(str1, str2);
        relative = (double)steps/(double)longerString(str1, str2);
        similarity = 1-relative;
        return similarity;
    }

    public double levenstheinSimilarity(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        steps = levenstheinDistance(str1, str2);
        relative = (double)steps / (double)longerString(str1, str2);
        similarity = 1-relative;
        return similarity;
    }

    public int damerauLevenstheinDistance(String str1, String str2) {
        int matrix[][] = new int[str1.length()+1][str2.length()+1]; //to store the distances
        int cost;   //change or stay penalty point
        int min;

        for(int i=0 ; i<=str1.length() ; i++)
            matrix[i][0] = i;
        for(int j=0 ; j<=str2.length() ; j++)
            matrix[0][j] = j;

        for(int i=1 ; i<=str1.length() ; i++) {
            for(int j=1 ; j<=str2.length() ; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    cost = 0;
                else
                    cost = 1;

                min = (matrix[i-1][j]+1);
                if((matrix[i][j-1]+1) < min)
                    min = (matrix[i][j-1]+1);
                if((matrix[i-1][j-1]+cost) < min)
                    min = (matrix[i-1][j-1]+cost);
                if(i>1 && j>1)
                    if(str1.charAt(i-1) == str2.charAt(j-2) && str1.charAt(i-2) == str2.charAt(j-1))
                        if((matrix[i-2][j-2]+cost) < min)
                            min = (matrix[i-2][j-2]+cost);

                matrix[i][j] = min;
            }
        }
        return matrix[str1.length()][str2.length()];
    }

    public int levenstheinDistance(String str1, String str2) {
        int matrix[][] = new int[str1.length()+1][str2.length()+1]; //to store the distances
        int cost;   //change or stay penalty point
        int min;

        for(int i=0 ; i<=str1.length() ; i++)
            matrix[i][0] = i;
        for(int j=0 ; j<=str2.length() ; j++)
            matrix[0][j] = j;

        for(int i=1 ; i<=str1.length() ; i++) {
            for(int j=1 ; j<=str2.length() ; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    cost = 0;
                else
                    cost = 1;

                min = (matrix[i-1][j]+1);
                if((matrix[i][j-1]+1) < min)
                    min = (matrix[i][j-1]+1);
                if((matrix[i-1][j-1]+cost) < min)
                    min = (matrix[i-1][j-1]+cost);

                matrix[i][j] = min;
            }
        }
        return matrix[str1.length()][str2.length()];
    }

    public int longerString(String str1, String str2) {
        if(str1.length()>=str2.length())
            return str1.length();
        else
            return str2.length();
    }

    public double dateComparison(Date date1, Date date2) {
        double sim;
        double daysbetween;
        double dmax = 500;
        daysbetween = Math.abs(Math.round((date1.getTime() - date2.getTime()) / (1000*60*60*24)));
        if(daysbetween<dmax) {
            return (double)(1-(daysbetween/dmax));
        } else {
            return 0;
        }
    }
}
