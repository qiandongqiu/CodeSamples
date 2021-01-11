package com.dq.learning;

import java.util.Stack;

public class BackspaceStringCompare {
	 //string: a#c, where # is a backspace, so the string a#c becomes c.
	
	private static Stack<Character> pushToStack(String a) {
		Stack<Character> stack=new Stack<>();
		for(int i=0; i<a.length();i++) {
			Character ch = a.charAt(i);
			if(ch!='#') {
				stack.push(ch);
			} else {
				if(!stack.empty()) {
					stack.pop();
				}
			}
		}
		return stack;
	}
	
	static boolean backspaceCompare(String a, String b) {
		Stack<Character> stackA = pushToStack(a);
		Stack<Character> stackB = pushToStack(b);
		if(stackA.size() != stackB.size()) return false;
		
		int size=stackA.size();
		
		for(int k=0; k<size; k++) {
			Character A = stackA.pop();
			Character B = stackB.pop();
			if(A!=B) return false;
		}
		
		return true;
		
	}
	
	public static void main(String[] args) {
		System.out.println(backspaceCompare("a##c","#a#c"));
		//System.out.println(backspaceCompare("abcd","bbcd"));
	}

}
