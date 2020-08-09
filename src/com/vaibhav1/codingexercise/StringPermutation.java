package com.vaibhav1.codingexercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement: Given a String, return all its permutations
 * Input: String s = "abc"
 * Output: {"abc", "acb", "bac", "bca", "cab", "cba"}
 */
public class StringPermutation {

    public List<String> generatePermutations(String s){

        List<String> results = new ArrayList<String>();
        permutationHelper(results, new StringBuilder(""), s, new boolean[s.length()]);
        return results;
    }

    /**
     * Recursive helper function to generate all permutations
     * @param results
     * @param sb
     * @param s
     * @param visited
     */
    private void permutationHelper(List<String> results, StringBuilder sb, String s, boolean[] visited) {

        if(sb.length() == s.length()){
            results.add(sb.toString());
            return;
        }


        for(int i=0;i<s.length();i++){

            if(visited[i]) continue;

            //if String contains duplicates
            if(i>0 && s.charAt(i)==s.charAt(i-1) && !visited[i-1]){
                continue;
            }

            sb.append(s.charAt(i));
            visited[i]=true;
            permutationHelper(results,sb,s,visited);
            sb.deleteCharAt(sb.length()-1);
            visited[i]=false;
        }

    }

    public static void main(String[] args) {
        StringPermutation sp = new StringPermutation();
        String input = "1122";

        List<String> permutations = sp.generatePermutations(input);

        displayPermutations(permutations);
    }

    /**
     * Prints permututations
     * @param permutations
     */
    private static void displayPermutations(final List<String> permutations) {

        for(String s: permutations){
            System.out.println(s);
        }
    }
}
