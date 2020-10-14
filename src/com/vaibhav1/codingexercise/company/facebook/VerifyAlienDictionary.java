package com.vaibhav1.codingexercise.company.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 *
 *
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 *
 *
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.)
 * According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character
 */
public class VerifyAlienDictionary {


    public boolean isAlienSorted(String[] words, String order) {

        Map<Character,Integer> orderMap = new HashMap<Character, Integer>();

        for(int i=0;i<order.length();i++){
            orderMap.put(order.charAt(i),i);
        }

        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){

                int min = Math.min(words[i].length(),words[j].length());
                for(int k=0; k<min; k++){
                    char iChar = words[i].charAt(k);
                    char jChar = words[j].charAt(k);

                    if(orderMap.get(iChar)<orderMap.get(jChar)){
                        break;
                    } else if(orderMap.get(jChar)<orderMap.get(iChar)){
                        return false;
                    } else if(k == min-1 && words[i].length()>words[j].length()){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String [] words = {"apple", "app"};
        String order = "abcdefghijklmnopqrstuvwxyz";

        VerifyAlienDictionary verify = new VerifyAlienDictionary();
        System.out.println(verify.isAlienSorted(words,order));
    }
}
