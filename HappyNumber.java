package test;

import java.util.HashMap;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
/*
Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, 
and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Return True if n is a happy number, and False if not.

Example: 

Input: 19
Output: true
Explanation: 
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 02 = 1
	
*/
public class HappyNumber {
	HashMap<Integer, Boolean> map = new HashMap<>();
	public int numberSquare(String s) {
	   //System.out.println(s);
		int result=0;
		for(int i=0; i<s.length();i++) {
			int v = s.charAt(i) - '0';
			result += v*v;
		}
		return result;
	}

   public boolean isHappy(int n) {
      if(map.containsKey(n)) return false;
      map.put(n, true);
	   String s = String.valueOf(n);
	   int result = numberSquare(s);
	   if(result==1) {
		   return true;
	   } else {
		   //not 1, how to prevent forever loop?
		   return isHappy(result);
	   }
   }
   
   
   public static void main(String args[]) {
	   HappyNumber a = new HappyNumber();
	   System.out.println(a.isHappy(19));
	   System.out.println(a.isHappy(1919));
	   System.out.println(a.isHappy(192346919));
   }

}

