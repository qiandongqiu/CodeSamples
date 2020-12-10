package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/word-break-ii/
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


	public List<String> wordBreak(String s, List<String> wordDict) {  //add memorilization for DP FAST!!
		List<String> result = new ArrayList<>();
		if(wordDict.contains(s))  {
			result.add(s);
			return result;
		}
		
		
		for(int i=0; i<s.length(); i++) {
			String prefix = s.substring(0,i);
			if(wordDict.contains(prefix)) {
				List<String> subResult = wordBreak(s.substring(i), wordDict);
				for(String one: subResult) {
					result.add(prefix+" "+ one);
				}
				
			}
		}
		
		return result;
		

	}
	

	public static void main(String[] args) {
		//String s = "catsanddog";
		//String[] wordDict = { "cat", "cats", "and", "sand", "dog" };
		
		String s="pineapplepenapple";
		String[] wordDict= {"apple","pen","applepen","pine","pineapple"};	
		//expected:  ["pine apple pen apple","pineapple pen apple","pine applepen apple"]

		//Time limit exceeds one withput DP:
		//String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		//String[] wordDict= {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		
		List<String> dict = Arrays.asList(wordDict);

		StringWordBreak ins = new StringWordBreak();
		List<String> result = ins.wordBreak(s, dict);
		for (String one : result) {
			System.out.println(one);
		}
	}
}
