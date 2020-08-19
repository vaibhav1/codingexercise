package com.vaibhav1.codingexercise;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 *
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs ==null || strs.length ==0){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        String first = strs[0];


        for(int j=0;j<first.length();j++){


            for(int i=1;i<strs.length; i++){


                if(j>= strs[i].length() || first.charAt(j)!=strs[i].charAt(j)){
                    return sb.toString();
                }

            }

            sb.append(first.charAt(j));
        }

        return sb.toString();


    }

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();

        String [] strs = {"flower","flow","flight"};

        System.out.println(prefix.longestCommonPrefix(strs));
    }
}
