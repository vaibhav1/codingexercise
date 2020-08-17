package com.vaibhav1.codingexercise;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase English letters is given.
 * We want to partition this string into as many parts as possible so that each letter appears in at most one part,
 * and return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 *
 *
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {

        List<Integer> partitions = new ArrayList<Integer>();

        int []lastIndices = new int[26];

        for(int i=0;i<S.length();i++){
            lastIndices[S.charAt(i)-'a'] = i;
        }

        int i=0;

        while(i<S.length()){

            int end = lastIndices[S.charAt(i)-'a'];
            int j = i;

            while(j!=end){
                end  = Math.max(end, lastIndices[S.charAt(j++)-'a']);
            }

            partitions.add(j+1-i);
            i=j+1;
        }

        return partitions;
    }

    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";

        PartitionLabels partition = new PartitionLabels();
        System.out.println(partition.partitionLabels(S));
    }
}
