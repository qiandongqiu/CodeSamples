package com.dq.learning;
import java.math.*;

public class AddString {
	static int add(char A, char B, int carry) {
		int a = A - '0';
		int b = B - '0';
		return a+b+carry;
	}
	
	static String addString(String strA, String strB) {
		int lengthA = strA.length();
		int lengthB = strB.length();
		
		StringBuilder builder = new StringBuilder();
		
		int maxLength = Math.max(lengthA, lengthB);
		int carry=0;
		for(int i=0; i<maxLength; i++) {
			char A;
			char B;
			if(i<lengthA) {
				A = strA.charAt(lengthA-i-1);
			} else {
				A = '0';
			}
			if(i<lengthB) {
				B = strB.charAt(lengthB-i-1);
			} else {
				B = '0';
			}
			//now add A and B
			int result = add(A, B, carry);
			
			if(result>10) {
				carry = 1;
				result = result - 10;
			} else {
				carry = 0;
			}
			char R = (char) ( '0' + result );
			
			//builder.append(R);
			builder.insert(0, R);
		}
		if(carry>0) builder.insert(0,'1');
		
		return builder.toString();
		
	}
	
	public static void main(String args[]) {
		System.out.println(AddString.addString("823","456"));
	}

}
