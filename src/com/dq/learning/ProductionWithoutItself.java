package com.dq.learning;
/*
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3300/
 * 
 Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

public class ProductionWithoutItself {
	public static int[] productExceptSelf(int[] nums) {  //using divide, does not count as good answer
        int size=nums.length;
        int product=1;
        for(int i=0;i<size;i++)
            product *=nums[i];
        
        int[] result = new int[size];
        for(int i=0; i<size; i++)
        	result[i]=product / nums[i];
        
        return result;
    }

	
	
	
	
	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		for(int r : productExceptSelf(nums)) {
			System.out.print(r+",");
		}
	}
}
