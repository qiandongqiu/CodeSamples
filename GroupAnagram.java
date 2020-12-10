package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

 */

public class GroupAnagram {
	
	//Algorith:
	//    1) find a unique key for every string: for anagram strings, they have the same key:
	//        a) way 1: sort the string
	//        b) way 2: new array with 26 chars: 
	//                  for every char in the string, set array[char-'a']++
	//
	
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(int i=0; i<strs.length; i++) {
        	char[] currentChars = strs[i].toCharArray();
        	Arrays.sort(currentChars);
        	
        	//using currentChars (sorted) as the key
        	String key = String.valueOf(currentChars);
        	if(map.containsKey(key)) {
        		List<String> list = map.get(key);
        		list.add(strs[i]);
        	} else {
        		List<String> value = new ArrayList<String>();
        		value.add(strs[i]);
        		map.put(key, value);
        	}
        }
        
        for(List<String> oneList : map.values()) {
        	result.add(oneList);
        }
        
        return result;
    }

    
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        
        System.out.println(result);
    	
    }
}

