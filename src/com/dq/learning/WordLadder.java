package com.dq.learning;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/word-ladder/

/*
 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

 */

/*
 Algorithm:  basically, the words can be checked whether they are connected using BFS: the neighbours are the words with only one char diff from current one.
 */

public class WordLadder {

	private boolean isNeighbour(String a, String b) {
		int N = a.length();
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (a.charAt(i) != b.charAt(i))
				count++;
		}

		return count == 1; // only 1 char diff, so it is a good neighbour
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		List<String> Q = new LinkedList<>();
		Q.add(beginWord);
		int level = 0;

		while (!Q.isEmpty()) {

			// for every neighbours of this level, we have to go through them once; and we
			// only increase the level once
			int currentSize = Q.size();
			level++;

			for (int i = 0; i < currentSize; i++) {

				String currentWord = Q.remove(0);
				if (currentWord.equals(endWord)) {
					return level;
				}

				Iterator<String> ite = wordList.iterator();
				while (ite.hasNext()) {
					String word = ite.next();
					if (isNeighbour(currentWord, word)) {
						ite.remove();
						Q.add(word);  //although we add it to Q, since we only loop until currentSize for this loop; we are okay.
					}
				}
			}

		}

		return 0;
	}

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> wordsList = new LinkedList<>();
		wordsList.addAll(Arrays.asList(words));

		WordLadder wl = new WordLadder();

		int level = wl.ladderLength(beginWord, endWord, wordsList); //NOTE: ArrayList does not have remove() defined; remove() is used on line 43;
		System.out.println(level);
	}
}
