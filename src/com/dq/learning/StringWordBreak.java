package com.dq.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/word-break-ii/
//https://www.geeksforgeeks.org/word-break-problem-trie-solution/
/*
 *Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence 
 *where each word is a valid dictionary word. Return all such possible sentences.
Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]

 */

/*Algorithm:
 *  "catsanddog" :
 *  find first prefix; then try the same algo for rest of string
 *  so:
 *    1) find the prefix of s which is in dict
 *    2)   if (s-prefix) can be formed using words in dict, we are good
 *    3)   if not, keep going on step 1.
 * 
 */

public class StringWordBreak {

	public List<String> wordBreak(String s, List<String> wordDict) {
		return dfs(s, wordDict, new HashMap<String, List<String>>());
	}

	private List<String> dfs(String s, List<String> wordDict, HashMap<String, List<String>> mem) {
		if (mem.containsKey(s)) { // DP: memorize previous result
			return mem.get(s);
		}

		List<String> res = new ArrayList<String>();
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				String next = s.substring(word.length());
				if (next.isEmpty())
					res.add(word);
				else {
					for (String sub : dfs(next, wordDict, mem)) {
						res.add(word + " " + sub);
					}
				}
			}
		}
		mem.put(s, res);
		return res;
	}

	public static void main(String[] args) {
		// String s = "catsanddog";
		// String[] wordDict = { "cat", "cats", "and", "sand", "dog" };

		// String s="pineapplepenappleA"; //not possible
		// String s="pineapplepenapple";
		// String[] wordDict= {"apple","pen","applepen","pine","pineapple"};
		// expected: ["pine apple pen apple","pineapple pen apple","pine applepen
		// apple"]

		// Time limit exceeds one withput DP: ( the String could not be splited using
		// the words)
		// String s =
		// "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		// String[] wordDict = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa",
		// "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa" };

		String s = "abcdefg";
		String[] wordDict = { "ab", "abc", "cd", "de", "defg", "fg", "efg" };

		List<String> dict = Arrays.asList(wordDict);

		StringWordBreak ins = new StringWordBreak();
		List<String> result = ins.wordBreak(s, dict);
		System.out.println("size=" + result.size());

		for (String one : result) {
			System.out.println(one);
		}
	}
}
