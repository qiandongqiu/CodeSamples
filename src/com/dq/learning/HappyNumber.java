package com.dq.learning;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
public class HappyNumber {
	
	static Map<Integer, Boolean> seen = new HashMap<Integer, Boolean>();
	
	private static int squareOfAllDigits(int n) {
		int result=0;
		while(n!=0) {
			int d = n % 10;
			result += d*d;
			n = n/10;
		}
		return result;
	}
	
	public static boolean isHappy(int n) {
		System.out.println(n);;
		if(n==0) return false;
		if(n==1) return true;
		seen.put(n, true);

		int k = squareOfAllDigits(n);
		if(k==1)
			return true;
		else {
			if(seen.get(k)!=null && seen.get(k)==true) return true;
			return isHappy(k);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(isHappy(2));
		
	}

}
