package com.dq.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
/*
 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
/*
 Algo is easy:
    for evey P characters in S, check to see whether the substr is a valid anagram of P!!!
    NO TRICK here.
 */
public class StringAnagramAll {
	 public List<Integer> findAnagrams(String s, String p) {
	        if(s==null || p==null ) {
	            return null;
	        }

	        List<Integer> result = new ArrayList<Integer>();
	        int end=0;
	        for(int index=0;index<s.length();index++){
	            end=index+p.length();
	            if(end <=s.length() && isValidAnagram(s.substring(index,end),p)){
	                result.add(index);
	            }

	        }
	        return result;
	    }

	    private boolean isValidAnagram(String substr, String p) {
	        int[]  isVisited = new int[128];
	        for(int i=0;i<substr.length();i++) {
	            isVisited[substr.charAt(i)] ++;
	        }

	        for(int index=0;index<p.length();index++)
	        {
	            isVisited[p.charAt(index)]--;
	            if(isVisited[p.charAt(index)] ==-1) {
	              return false ;
	            }
	        }

	        return true;
	    }  
	 
	 public static void main(String[] args) {
		 //String s="cbaebacd", p="abc";
		 //String s="cbaebabacd", p="abc";
		 //String s="abab", p="ab"; //0,1,2!!!
		 String s="abaab", p="aab"; //0,1,2!!!
		 StringAnagramAll ins = new StringAnagramAll();
		 List<Integer> res = ins.findAnagrams(s, p);
		 for(Integer one:res) {
			 System.out.print(one+",");
		 }
	 }

}
