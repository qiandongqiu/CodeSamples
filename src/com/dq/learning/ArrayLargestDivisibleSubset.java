package com.dq.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 https://leetcode.com/problems/largest-divisible-subset/
 Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
 */
public class ArrayLargestDivisibleSubset {
	class Point {
		int parent;
		int length;
		int value;
		
		Point(int v) {
			length=1;
			value=v;
			parent=-1;
		}
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		Arrays.sort(nums);
		int N=nums.length;
		
		Point[] DP = new Point[N];
	    DP[0]=new Point(nums[0]); 	

		
	    int maxIndex=0;
		for(int i=1;i<N; i++) {
			DP[i] = new Point(nums[i]);
			for(int j=0;j<i;j++) {
				if(nums[i] % nums[j]==0) {
					if(DP[i].length < DP[j].length+1) {
					    DP[i].length = DP[j].length+1;
					    DP[i].parent = j;
					}
				}
			} //j
            if(DP[i].length > DP[maxIndex].length)
            	maxIndex = i;
		}
		
		//now, construct the result
		List<Integer> result = new ArrayList<>();
		int index=maxIndex;
		while(index!=-1) {
			result.add(nums[index]);
			index = DP[index].parent;
		}

		return result;
	}
	
	public static void main(String[] args) {
		//int[] nums= {1,2,3};
		//int[] nums= {4,8,10,240};
		int[] nums= {3,6,9,18};
		
		ArrayLargestDivisibleSubset ins = new ArrayLargestDivisibleSubset();
		List<Integer> res = ins.largestDivisibleSubset(nums);
		for(Integer one:res) {
			System.out.print(one+",");
		}
	}

}
