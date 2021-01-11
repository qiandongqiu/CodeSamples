package com.dq.learning;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 You are given an integer array nums and you have to return a new counts array. 
 The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 Algorithm: no tricks here, use 2 loops.
 */

public class ArrayCountSmallerAfterSelf {

	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new ArrayList<>();
		int N=nums.length;
		for(int i=0;i<N;i++) {
			int count=0;
			for(int j=i+1;j<N;j++) {
				if(nums[j] < nums[i])
					count++;
			}
			result.add(count);
		}
        return result;
	}
	
	public static void main(String[] args) {
		int nums[]=   {5,2,6,1};
		ArrayCountSmallerAfterSelf ins = new ArrayCountSmallerAfterSelf();
		List<Integer> r = ins.countSmaller(nums);
		System.out.println(r);
	}
}
