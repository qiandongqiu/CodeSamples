package com.dq.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieSearchEngine {

	static class TrieNode {
		HashMap<Character, TrieNode> children;
		boolean isWord;
		Character value;

		TrieNode(char v) {
			this.value = v;
			this.isWord = false;
			this.children = new HashMap<>();
		}
	} // TrieNode

	public static void insert(TrieNode root, String word) {
		TrieNode tmp = root;

		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = tmp.children.get(ch);
			if (node != null) { // already inside there
				// do nothing
			} else {
				node = new TrieNode(ch);
				if (i == word.length() - 1) // the last one
					node.isWord = true;

				tmp.children.put(ch, node);
				tmp = node;
			}
		}
	}

	public static List<String> getSuggestion(TrieNode root, String prefix) {
		List<String> result = new ArrayList<>();
		int N = prefix.length();
		TrieNode next = root;
		int i=0;
		//find the last node which has part of the prefix
	    while(i<N && next!=null) {
			char ch = prefix.charAt(i);
			next = root.children.get(ch);
			i++;
		}
	    
	    StringBuilder sb=new StringBuilder();
	    sb.append(prefix.substring(0,i));
	    
	    //now, find all possible words
	    

		return result;
	}

	public static void main(String[] args) {
		TrieNode root = new TrieNode(' ');
		insert(root, "toast");
		insert(root, "tab");
		insert(root, "this");
		insert(root, "that");
		insert(root, "shoot");
		insert(root, "shake");

		List<String> result = getSuggestion(root, "t");
        System.out.println("size ="+result.size());
		for (String one : result) {
			System.out.println(one);
		}

	}
}
