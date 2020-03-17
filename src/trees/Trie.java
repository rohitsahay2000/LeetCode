/*
 * Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 * 
 * 
 * 
 */


package com.rohit.trees;

import java.util.HashMap;
import java.util.Map;


public class Trie {
	
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {

			if (node.childrenMap.get(word.charAt(i)) == null) {
				TrieNode newTrieNode = new TrieNode();
				node.childrenMap.put(word.charAt(i), newTrieNode);
			}
			node = node.childrenMap.get(word.charAt(i));

		}
		node.endOfWord = true;        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        
        TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {

			if (node.childrenMap.get(word.charAt(i)) == null) {
				return false;
			}
			node = node.childrenMap.get(word.charAt(i));

		}
		if(node.endOfWord==true)
			return true;

		return false;       
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        
        TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {

			if (node.childrenMap.get(prefix.charAt(i)) == null) {
				return false;
			}
			node = node.childrenMap.get(prefix.charAt(i));

		}
		return true;       
    }

}

class TrieNode {
	Map<Character, TrieNode> childrenMap;
	boolean endOfWord;

	public TrieNode() {
		childrenMap = new HashMap<>();
	}

}

