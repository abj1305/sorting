package com.practice.dsa.anuj.trie;

public class TrieNode {

	TrieNode[] children;
	boolean isEndOfWord;
	
	public TrieNode() {
		children = new TrieNode[26];
		isEndOfWord = false;
	}
	
	public void insert(TrieNode root , String str) {
		
		TrieNode curNode = root;
		for(int i=0;i<str.length();i++) {
			char cur = str.charAt(i);
			if(curNode.children[cur-'a'] == null) {
				TrieNode newNode = new TrieNode();
				curNode.children[cur-'a'] = newNode;
			}
			curNode = curNode.children[cur-'a'];
		}
		curNode.isEndOfWord=true;
	}
	
	public boolean search(TrieNode root , String str) {
		TrieNode curNode = root;
		for(int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if(curNode.children[cur-'a']==null) {
				return false;
			}
			curNode = curNode.children[cur-'a'];
		}
		return curNode.isEndOfWord;
	}
}
