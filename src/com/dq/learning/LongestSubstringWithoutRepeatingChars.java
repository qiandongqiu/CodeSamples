package com.dq.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingChars {
	 public static int lengthOfLongestSubstring(String s) {
		 //String: abcdbx ==> abcd ==> 4
		 //algorithm:  1) using a hash map to remember the location of a char
		 //            2) when it encounters a char already in the hash, then the longest will be:  current-1; or from previous location+1 and going
		 //               here, use an array to remember possible longest, then at the end, iterator through it to get max?
		 
		 ArrayList<Integer> possibleLongest = new ArrayList<Integer>();
		 
		 HashMap<Character, Integer> map = new HashMap<>();
		 int longest=0;
		 for(int i=0; i<s.length(); i++) {
			 char ch = s.charAt(i);
			 if(map.containsKey(ch)) {
				 //char was seen before
				 //1: the longest is current longest
				 //System.out.println("   put ="+longest);
				 possibleLongest.add(longest);
				 longest=0;
				 int previousLocation = map.get(ch);
				 longest = i - previousLocation;
				 //ALSO, now, mark the seen character to the new index
				 //DQ Important note: for "abba", when we see the 2nd b, we need clean out the map with index < first b is everything;
				 
				 //clean up map with value < previousLocation
				 Iterator<Character> it= map.keySet().iterator();
				 while(it.hasNext()) {
					 Character key = it.next();
					 Integer value = map.get(key);
					 if(value<previousLocation) {
						 it.remove();
					 }
				 }

				 map.put(ch, i);
				 

			 } else {
				 //char is new
				 longest++;
				 map.put(ch, i);
			 }
		 }
		 //System.out.println(" leftover longest="+longest);
		 for(int i=0;i<possibleLongest.size(); i++) {
			 if(possibleLongest.get(i)>longest) longest=possibleLongest.get(i);
		 }
	        
		 return longest;
	 }
	 
	 public static void main(String[] args) {
		 //String s="pwwkew";
		 //String s="bbbbb";
		 String s="abxyaxy";
		 //String s=" ";
		 //String s="abba";
		 System.out.println(lengthOfLongestSubstring(s));
	 }

}
