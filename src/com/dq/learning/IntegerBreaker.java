package com.dq.learning;

//https://leetcode.com/problems/integer-break/
/*
 Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

Example 1:

Input: 2
Output: 1
Explanation: 2 = 1 + 1, 1 × 1 = 1.
Example 2:

Input: 10
Output: 36
Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
Note: You may assume that n is not less than 2 and not larger than 58.


 */

public class IntegerBreaker {
	
	//brutal force method, timeout when n=31
	public int integerBreakHelper(int n) {
		if(n==2) return 2;   //The trick is here: when the last number is 2, no need to go deeper; 2 x Number > 1*1*Number!  
		                     //But when the original number passed in is 2, we have to return 1;
		if(n<2) return 1;

        int localMax=0;
		int subMax = 0;
		for(int i=1; i<n; i++) {
			subMax = integerBreakHelper(n-i);
			subMax = i*subMax;
			if(subMax>localMax) localMax=subMax;
		}
		
		if(localMax<n) localMax=n;  //if separate it make the value smaller, then do not do it.
		
		return localMax;
	}
	
	
	//using memory to store already done results.
	public int integerBreakHelper(int n, int[] DP) {
		if(DP[n]!=0) return DP[n];
		
        int localMax=0;
		int subMax = 0;
		for(int i=1; i<n; i++) {
			subMax = integerBreakHelper(n-i, DP);
			subMax = i*subMax;
			if(subMax>localMax) localMax=subMax;
		}
		
		if(localMax<n) localMax=n;  //if separate it make the value smaller, then do not do it.
		
		DP[n] = localMax;
		return localMax;
	}
	
	
	public int integerBreak(int n) {
		//if(n<=2) return 1;   //here, we have to return 1:  2=1+1, and 1*1=1
		//if(n==3) return 2;   //here, we have to return 2:  2+1
		
		int[] DP=new int[100];  //requirement says <=58
		//there are 4 special cases here, especially for 2 and 3;  since our helper function could not handle them.
		DP[0]=1;
		DP[1]=1;
		DP[2]=2;
		DP[3]=2;

		return integerBreakHelper(n,DP);
	}
	
	public static void main(String[] args) {
		IntegerBreaker ins= new IntegerBreaker();
		//System.out.println(ins.integerBreak(2));
		System.out.println(ins.integerBreak(3));
		//System.out.println(ins.integerBreak(6));
		//System.out.println(ins.integerBreak(4));
		System.out.println(ins.integerBreak(10));
		System.out.println(ins.integerBreak(31));//this one timed out with the brutal force solution
	}
}
