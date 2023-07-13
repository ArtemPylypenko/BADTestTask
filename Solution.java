package org.example;

import java.nio.charset.CharsetEncoder;
import java.time.temporal.ChronoField;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static Character solve(String input) {
        //Delete all specific chars in input
        String modifyString = input.replaceAll("[^a-zA-Z0-9]", " ");
        String tmpWord = "";//Temporary word we check
        String uniqueSymbols = "";//All unique symbols from words
        for (int i = 0; i < modifyString.length(); i++) {
            if (modifyString.charAt(i) == ' ' && modifyString.charAt(i - 1) != ' ') {//if we find word and to avoid all multiple " "
                uniqueSymbols += findFirstUnique(tmpWord);
                tmpWord = "";
            } else if (modifyString.charAt(i) != ' ') {
                tmpWord += modifyString.charAt(i);
            }
        }
        System.out.println(findFirstUnique("mamaamfqf")) ;
        return findFirstUnique(uniqueSymbols);
    }

    private static Character findFirstUnique(String word) {
        Set<Character> notUnique = new HashSet<>();
         for (int i = 0; i < word.length(); i++) {
            boolean isUnique = true;
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j) || notUnique.contains(word.charAt(i))){
                    isUnique = false;
                    break;
                }
            }
            notUnique.add(word.charAt(i));
            if (isUnique)
                return Character.valueOf(word.charAt(i));
        }
        return Character.valueOf(' ');
    }
}
