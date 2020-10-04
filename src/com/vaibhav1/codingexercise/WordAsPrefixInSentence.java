package com.vaibhav1.codingexercise;


/**
 * Given a sentence that consists of some words separated by a single space, and a searchWord.
 * You have to check if searchWord is a prefix of any word in sentence.
 * Return the index of the word in sentence where searchWord is a prefix of this word (1-indexed).
 * If searchWord is a prefix of more than one word, return the index of the first word (minimum index). If there is no such word return -1.
 *
 * A prefix of a string S is any leading contiguous substring of S.
 *
 *
 *
 * Example 1:
 * Input: sentence = "i love eating burger", searchWord = "burg"
 * Output: 4
 * Explanation: "burg" is prefix of "burger" which is the 4th word in the sentence.
 *
 * Example 2:
 * Input: sentence = "this problem is an easy problem", searchWord = "pro"
 * Output: 2
 * Explanation: "pro" is prefix of "problem" which is the 2nd and the 6th word in the sentence, but we return 2 as it's the minimal index.
 *
 * Example 3:
 * Input: sentence = "i am tired", searchWord = "you"
 * Output: -1
 * Explanation: "you" is not a prefix of any word in the sentence.
 *
 * Example 4:
 * Input: sentence = "i use triple pillow", searchWord = "pill"
 * Output: 4
 *
 * Example 5:
 * Input: sentence = "hello from the other side", searchWord = "they"
 * Output: -1
 */
public class WordAsPrefixInSentence {

    public int isPrefixOfWord(String sentence, String searchWord) {

        String [] words = sentence.split(" ");

        int index = -1;
        for(int i=0; i< words.length; i++){
            String word = words[i];

            if(word.charAt(0) != searchWord.charAt(0)){
                continue;
            }
            if(word.length()>=searchWord.length()){
                index = i+1;
                if(searchWord.equals(word.substring(0, searchWord.length()))){
                    return index;
                }
            }

        }

        return index;
    }


}
