package com.vaibhav1.codingexercise;


import org.w3c.dom.ls.LSOutput;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;

        while(i<j){

            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }

            while(j>i && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            if(Character.toLowerCase(s.charAt(i++))!=Character.toLowerCase(s.charAt(j--))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome(s));
    }
}
