package org.ergemp.mlt.palindrome.algorithm;

public class ReverseString {
    //create the reverse function
    //takes a string argument
    //returns the reverse of the incoming argument
    public static String reverse(String gStr){

        //create an empty char array to be filled with the reverse string
        char[] reverseCharArr = new char[gStr.length()];

        //convert the incoming argument to char array
        char[] charArr = gStr.toCharArray();

        //loop the char array and create the reverse array
        for (Integer i=0; i<charArr.length; i++){
            reverseCharArr[i] = charArr[charArr.length-i-1];
        }

        //convert he reversed char array as string
        return(String.valueOf(reverseCharArr));
    }
}
