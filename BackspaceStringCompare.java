package test;

import java.util.Stack;

public class BackspaceStringCompare {
	 //string: a#c, where # is a backspace, so the string a#c becomes c.
	
	static boolean backspaceCompare(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		
		Stack<Character> stackA = new Stack<>();
		Stack<Character> stackB = new Stack<>();
		
		for(int i=0; i<lengthA; i++) {
			Character charA = a.charAt(i);
			if(charA!='#') {
				stackA.push(charA);
			} else {
				if(!stackA.empty()) {
					stackA.pop();
				}
			}
		}
		
		for(int i=0; i<lengthB; i++) {
			Character charB = b.charAt(i);
			if(charB!='#') {
				stackB.push(charB);
			} else {
				if(!stackB.empty()) {
					stackB.pop();
				}
			}
		}
		
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
		//System.out.println(backspaceCompare("a##c","#a#c"));
		System.out.println(backspaceCompare("abcd","bbcd"));
	}

}
