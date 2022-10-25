package org.ergemp.mlt.palindrome.algorithm;

import java.util.Arrays;

public class Anagram {
    public static Boolean isAnagram(String gStr1, String gStr2){

        Boolean retVal = false;

        char[] cArr1 = gStr1.toLowerCase().toCharArray();
        char[] cArr2 = gStr2.toLowerCase().toCharArray();

        Arrays.sort(cArr1);
        Arrays.sort(cArr2);

        if (Arrays.equals(cArr1, cArr2)){
            retVal = true;
        }

        return retVal;
    }
}
