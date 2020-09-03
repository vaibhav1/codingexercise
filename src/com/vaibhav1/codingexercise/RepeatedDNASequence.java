package com.vaibhav1.codingexercise;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vaibhav.shukla
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 *
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 *
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 */
public class RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i+10 <= s.length(); i++){

            String dna = s.substring(i, i+10);

            map.put(dna, map.getOrDefault(dna, 0) + 1);

            if(map.get(dna) == 2){
                result.add(dna);
            }
        }

        return result;
    }
}
