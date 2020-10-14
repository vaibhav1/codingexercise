package com.vaibhav1.codingexercise;


/**
 *Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class Trie {

    class TrieNode{

        public char c;
        public boolean isWord;
        public TrieNode [] children;


        public TrieNode(char c){
            this.c = c;
            isWord = false;
            children = new TrieNode [26];
        }
    }

    TrieNode root ;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('#');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        TrieNode curr = root;

        for(char c: word.toCharArray()){

            if(curr.children[c - 'a'] == null ){
                curr.children[c - 'a'] = new TrieNode(c);
            }

            curr = curr.children[c - 'a'];
        }

        curr.isWord = true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        TrieNode wordNode = searchNode(word);

        return wordNode != null && wordNode.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        return searchNode(prefix) != null;
    }

    public TrieNode searchNode(String word){

        TrieNode curr = root;

        for(char c: word.toCharArray()){

            if(curr.children[c - 'a'] == null){
                return null;
            }

            curr = curr.children[c - 'a'];
        }
        return curr;
    }

}
