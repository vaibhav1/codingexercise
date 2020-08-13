package com.vaibhav1.codingexercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 */
public class WordSearch2 {

    /*
    We make use of (@Link WordSearch solution to find if the word exists in the Board. If yes, add it to results)
     */
    public List<String> findWords(char[][] board, String[] words) {

        List<String> results  = new ArrayList<String>();
        WordSearch search = new WordSearch();
        for(String word: words){

            if(search.exist(board,word)){
                results.add(word);
            }
        }
        return  results;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {"oath", "pea", "eat", "rain"};

        WordSearch2 searchWords = new WordSearch2();
        List<String> results = searchWords.findWords(board, words);
        System.out.println(results);
    }
}
