package com.dq.learning;
/*
https://leetcode.com/problems/additive-number/

Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

 

Example 1:

Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199. 
             1 + 99 = 100, 99 + 100 = 199

*/
public class StringIsAdditiveNumbers {
	
	private String add(String a, String b) {
		try {
		long A = Long.valueOf(a);
		long B = Long.valueOf(b);
		
		long C = A+B;
		return String.valueOf(C);
		} catch(NumberFormatException e) {
			return "";
		}
		
	}
	
	private boolean isAdditiveHelper(String first, String leftOver) {
	    if(first.startsWith("0") && first.length()>1) {
	    	return false; //the rule says: number cannot start with '0'
	    }
		if(leftOver.length()==0) return true; //at the end, we get here, which means, all the conditions are met before; return true!
		//System.out.println(first+"->"+leftOver);
		int N=leftOver.length();
        for(int j=1; j<=N/2+1; j++) {
        	//System.out.println("   --------------j="+j);
        	String second =  leftOver.substring(0,j);
	        if(second.startsWith("0") && second.length()>1) {
	           continue;	
	        }
        	String third = add(first, second);
        	String left = leftOver.substring(j);
	        if(left.startsWith("0") && left.length()>1) {
	           continue;	
	        }
            	
        	if(left.startsWith(third)) {
        	    if(left.equals(third)) return true;
        		boolean result=isAdditiveHelper(second, leftOver.substring(second.length()));
        		if(result)
        			return true;
        	}
        }
		
        return false;
	}
	
	 public boolean isAdditiveNumber(String num) {
		 int N=num.length();
		 if(N<3) return false;
		 
		 for(int i=1; i<= N/2+1; i++) {  //most we can we is prefix takes half of the string (when it is even, half won't work either; but odd would work)
			 //System.out.println("-------"+i);
			 String prefix=num.substring(0,i);
			 String leftOver = num.substring(i);
			 if(isAdditiveHelper(prefix,leftOver)) return true;
		 }
	        
		 return false;
	 }
	 
	 
	 public static void main(String[] args) {
		//String num="12358132133";
		//String num="199100199";
		//String num="0235813";  //this is the one failed first: it should  FAIL
		//String num="000";  //GOOD
		//String num="199001200";

       // String num="111122335588143"; //true: 11,11,22,33,44,88,143
		 
		//String num= "1991000199299498797";  //would throw NumberFormatException
		String num="121474836472147483648"; //using Integer: it will fail; but using Long will succeed
		
		StringIsAdditiveNumbers ins = new StringIsAdditiveNumbers();
		boolean r = ins.isAdditiveNumber(num);
		System.out.println(r);
	 }
}
