package com.dq.learning;

import java.util.Stack;

/*
 Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
 */

public class CheckValidString {
	static boolean validate(char[] s) {  //to see whether s (without *), is valid or not
		int left=0;
		for(int i=0; i<s.length; i++) {
			char ch = s[i];
			if(ch=='(') left++;
			if(ch==')') left--;
			if(left<0) break;
		}
		
		return left==0;
	}
	//brutal force: replace * with (, ), _ individually, recursively solve it
	public static boolean checkValidString_2(char[] s, int k) {
		if(k==s.length) {
			if(validate(s)) return true;
			else return false;
		}
		
		if(s[k]=='*') {
			for(char c : "() ".toCharArray()) {
				s[k]=c;
				if(checkValidString_2(s,k+1)) return true;
				s[k]='*';
			}
			
		} else {
			return checkValidString_2(s, k+1);
		}
		
        return false;
	}
	
	

	//**************************************************
	
	//this is a tricky way, O(n)
	public static boolean checkValidString(String s) {
		       int lo = 0, hi = 0;
		       for (char c: s.toCharArray()) {
		           lo += c == '(' ? 1 : -1;
		           hi += c != ')' ? 1 : -1;
		           if (hi < 0) break;
		           lo = Math.max(lo, 0);
		       }
		       return lo == 0;
	}
	
	public static void main(String[] args) {
		//String s = "(*))";
		//String s = "**((*"; //false
		//String s = "((***";  //true
        String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";   //false

		//String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
		//String s = "    ((())()()(*)(*()(())())())()()((()())((()))(*";
		//String s = "    ((())()()(*)(*()(())())())()()((()())((()))(*";
		//String s = "    (    ()()(*)(*()(())())())()()((()())((()))(*";
		//String s = "    (        (*)(*()(())())())()()((()())((()))(*";
		//String s = "    (         * (*()(())())())()()((()())((()))(*";
		//String s = "    (         * (*  (  )())())()()((()())((()))(*";
		//String s = "    (         * (*        )())()()((()())((()))(*";
		//String s = "    (         *  *           )()()((()())((()))(*";
		//String s = "              *  *            ()()((()())((()))(*";
		//String s = "              *  *                ((()())((()))(*";
		//String s = "              *  *                ((    )((()))(*";
		//String s = "              *  *                (      ((()))(*";
		//String s = "              *  *                (      ((  ))(*";
		//String s = "              *  *                (            (*";
		//String s = "              *  *                (            (*";
		 //"*(";
		System.out.println(checkValidString_2(s.toCharArray(),0));
	}

}
