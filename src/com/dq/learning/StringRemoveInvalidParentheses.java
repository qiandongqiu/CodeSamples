package com.dq.learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/remove-invalid-parentheses/
/*
 Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
 */
/*
 Algo: we can use BFS here: treat the original string as a node; then go over every ( and ), remove it to see whether the remain is a valid string.
 */

public class StringRemoveInvalidParentheses {
	
	private boolean isValid(String s)  {
		int cnt=0;
		for(int i=0;i<s.length(); i++) {
			char ch=s.charAt(i);
			if(ch=='(')
				cnt++;
			if(ch==')')
				cnt--;
			if(cnt<0) return false;
		}
		
		return cnt==0;
	}

	public List<String> removeInvalidParentheses(String s) {
          List<String> result = new ArrayList<>();
          
          Queue<String> q = new LinkedList<>();
          q.add(s);
          
          Set<String> visited = new HashSet<>();
          visited.add(s);
          
          boolean level=false;
          
          while(!q.isEmpty()) {
        	  String current = q.remove();
        	  //visited.add(current);
        	  if(isValid(current)) {
        		  result.add(current);
        		  level=true;  //since we only want the shortest path, we set this to true, so that we only process strings in queue already.
        	  }
        	  if(level) continue;
        	  
        	  //now, dig deeper for every ( and )
        	  for(int i=0; i<current.length();i++) {
        		  String subString = current.substring(0,i) + current.substring(i+1);
        		  if(!visited.contains(subString)) {
        		    q.add(subString);
        	        visited.add(subString);
        		  }
        	  }
        	  
          }
          
          return result;
	}
	
	
	public static void main(String[] args) {
		String data="()())()";
		StringRemoveInvalidParentheses ins = new StringRemoveInvalidParentheses();
		List<String > result = ins.removeInvalidParentheses(data);
		System.out.println(result);
		
	}
}
