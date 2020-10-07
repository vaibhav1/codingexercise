package com.vaibhav1.codingexercise.company.facebook;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 *
 *
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {

    int i=0;
    int j=s.length()-1;

        while(i<j){

        if(s.charAt(i) != s.charAt(j)){
            return isPalindrome(s,i+1,j) || isPalindrome(s, i, j-1);
        }
        i++;
        j--;
    }

        return true;
}

    private boolean isPalindrome(String s, int i, int j){

        while(i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }

        return true;
    }
}
