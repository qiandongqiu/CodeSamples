package com.dq.learning;
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/
//Also here: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/  to see algorithm

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
public class ArrayMaxSumSubArray {

	 //algorithm:  (1,2, -10, 2, 3)
	 //     1) define 2 variables:  max_so_far and max_end_here, init to 0
	 //     2) go through every item
	 //         max_end_here+num[i] > max_so_far, set max_so_far to it
     //	         if(max_end_here<0) set it to 0
	
	 public static int maxSubArray(int[] nums) {
	        int max=0;
	        int presum=0;
	        for(int i=0; i<nums.length; i++) {
	        	if(presum+nums[i] >= max) {
	        		max = presum + nums[i];
	        	} 
	        	presum += nums[i];
	        	if(presum<0) presum=0;
	        }
	        
	        return max;
	 }
	 
	 public static void main(String args[]) {
		 int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		 System.out.println(maxSubArray(nums)); //6 = 4,-1,2,1
	 }
}

