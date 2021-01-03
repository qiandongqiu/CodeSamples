package com.dq.learning;

import java.util.Arrays;

//https://leetcode.com/problems/burst-balloons/
/*
 Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. 
 You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. 
 Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 */
public class ArrayBurstBallon {
	private int maxCoinsHelper(int[] nums, int[] parent, int start, int end) {
		if (start == end)
			return nums[start]; // only 1 item left, just return its value

		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
		// for (int i = 1; i <= 1; i++) {
			// take one item i out, then calculate the max
			if (parent[i] == -2)
				continue;

			// first, find the left
			int l = i-1;
			while (l >= 0 && parent[l] == -2)
				l--;
			int leftValue = 1;
			if (l >= 0)
				leftValue = nums[l];

			int r = i + 1;
			while (r <= end && parent[r] == -2)
				r++;
			int rightValue = 1;
			if (r <= end)
				rightValue = nums[r];

			int currentMax = leftValue * nums[i] * rightValue;

			int previousParent = parent[i];
			parent[i] = -2; // mart it as used

			int subMax = maxCoinsHelper(nums, parent, start, end);

			max += currentMax + subMax;

			parent[i] = previousParent; 

		}

		if (max == Integer.MIN_VALUE)
			return 0;
		return max;
	}

	public int maxCoins(int[] nums) {
		int[] parent = new int[nums.length]; // -1: no parent; otherwise set it to parent.
		parent[0] = -1;
		for (int i = 1; i < nums.length; i++) {
			parent[i] = parent[i - 1];
		}
		int r = maxCoinsHelper(nums, parent, 0, nums.length - 1);
		return r;

	}

	public static void main(String[] args) {
		ArrayBurstBallon ins = new ArrayBurstBallon();
		int[] nums = { 3, 1, 5, 8 };
		int r = ins.maxCoins(nums);
		System.out.println(r);

	}
}
