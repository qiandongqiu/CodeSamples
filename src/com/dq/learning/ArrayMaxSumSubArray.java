package com.dq.learning;
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/

//Also here: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/  to see algorithm

//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
public class ArrayMaxSumSubArray {

	// algorithm: (1,2, -10, 2, 3)
	// 1) define 2 variables: max_so_far and max_end_here, init to 0
	// 2) go through every item
	// max_end_here+num[i] > max_so_far, set max_so_far to it
	// if(max_end_here<0) set it to 0

	public static int maxSubArray(int[] nums) { // using int as return may not be good, since max_int+max_int will be a
												// problem

		int max = 0;
		int presum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (presum + nums[i] >= max) {
				max = presum + nums[i];
			}
			presum += nums[i];
			if (presum < 0)
				presum = 0; // this makes this algorithm does not work on all negative number
		}

		return max;
	}

	static int maxSubArraySum(int a[], int size) { //this one works with Negative numbers
		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < size; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);  //the current max is either this number; or this number + curr_max
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	public static void main(String args[]) {
		// int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		int[] nums = { -2, -1, -3, -1, -5, -4 }; // all negative???, the result is not right
		System.out.println(maxSubArray(nums)); // 6 = 4,-1,2,1
		System.out.println(maxSubArraySum(nums, nums.length)); // -1
	}
}
