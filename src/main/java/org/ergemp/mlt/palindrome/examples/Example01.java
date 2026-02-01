package org.ergemp.mlt.palindrome.examples;

import org.ergemp.mlt.palindrome.algorithm.ReverseString;

import static org.ergemp.mlt.palindrome.algorithm.Anagram.isAnagram;

public class Example01 {
    public static void main(String[] args) {
        if (isAnagram("erg","ger")) {
            System.out.println("strings are anagram");
        }
        else {
            System.out.println("strings are not anagram");
        }

        String testPalindrome = "child";
        if (testPalindrome.equals(ReverseString.reverse(testPalindrome))){
            System.out.println("is palindrome");
        }
        else {
            System.out.println("is not palindrome");
        }
    }
}
