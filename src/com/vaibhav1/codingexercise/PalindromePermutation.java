package com.vaibhav1.codingexercise;

import java.util.HashMap;
import java.util.Map;

/**
 * Check if the characters in given string could be arranged to form a palindrom
 */
public class PalindromePermutation {


    public boolean isPalindromicPermutation(String str){
        Map<Character, Integer> freq = new HashMap<Character, Integer>();

        char [] strChar = str.toCharArray();
        for(int i=0;i<strChar.length;i++){
            if(freq.containsKey(strChar[i])){
                freq.remove(strChar[i]);
            } else{
                freq.put(strChar[i], i);
            }
        }

        if(str.length()%2 ==0 && freq.size() == 0){
            return true;
        }

        if(str.length() %2 ==1 && freq.size()==1){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        PalindromePermutation perm = new PalindromePermutation();
        System.out.println(perm.isPalindromicPermutation("abcba"));

    }
}
