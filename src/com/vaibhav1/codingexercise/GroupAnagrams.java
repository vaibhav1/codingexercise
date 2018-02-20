/**
 * 
 */
package com.vaibhav1.codingexercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author vshukla
 *
 */
public class GroupAnagrams {
	
	public static void groupAnagrams(String []words){
		
		List<String> output = new ArrayList<String>();
		Map<String, List<String>> map = populateAnagramsTogether(words);
		for(Map.Entry<String, List<String>> entry: map.entrySet()){
			List<String> anagrams = entry.getValue();
			Collections.sort(anagrams);
			StringBuilder sb = new StringBuilder("");
			for(int i=0;i<anagrams.size();i++){
				String s = anagrams.get(i);
				sb.append(s);
				if(i<anagrams.size()-1){
					sb.append(",");
				}
				
			}
			output.add(sb.toString());
		}
		Collections.sort(output);
		for(String s:output){
			
			System.out.println(s);
		}
	}
	
	static int countOccurrence(String[] word, String str) 
    {
        // counter
        int counter = 0;
         
        // for extracting words
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(str);
         
        // HashSet for quick check whether
        //  a word in str present in word[] or not
        HashSet<String> hs = new HashSet<String>();
         
        for (String string : word) {
            hs.add(string);
        }
         
        while(m.find())
        {
            if(hs.contains(m.group()))
                counter++;
        }
         
        return counter;
         
    }

	/**
	 * @param words
	 * @param map
	 */
	private static Map<String, List<String>> populateAnagramsTogether(String[] words) {
		Map<String, List<String>> map = new HashMap<String,List<String>>();
		for(int i=0;i<words.length;i++){
			String word = words[i];
			word = word.replaceAll(" ", "");
			String sortedKey = getSortedWord(word);
			
			if(!map.containsKey(sortedKey)){
				List<String> list = new ArrayList<String>();
				list.add(word);
				map.put(sortedKey, list);
			} else {
				List<String> anagrams = map.get(sortedKey);
				anagrams.add(word);
				map.put(sortedKey, anagrams);
			}
			
		}
		return map;
	}

	/**
	 * @param word
	 */
	private static String getSortedWord(String word) {
		char[]sorted = word.toCharArray();
		Arrays.sort(sorted);
		String sortedKey = new String(sorted);
		return sortedKey;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String []words = {"pear","amleth","dormitory","tinsel","dirty room","hamlet","listen","silent"};
		groupAnagrams(words);
	}

}
