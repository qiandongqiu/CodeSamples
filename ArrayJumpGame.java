package test;
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/531/week-4/3310/

/*
 *Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

 */
public class ArrayJumpGame {

	// Algorithm: reach[N] array, set to true means can be reached from 0 to N;
	// other wise false
	public static boolean canJump(int[] nums) {
		int N = nums.length;
		boolean reach[] = new boolean[N];
		if (nums[0] == 0)
			return false;
		else
			reach[0] = true;

		for (int i = 0; i < N; i++) {
			if (reach[i] == true) {
				for (int j = i + 1; j <= i + nums[i] && j < N; j++) {
					reach[j] = true;
				}
			}
		}

		return reach[N - 1];
	}

	public static void main(String[] args) {
		// int[] nums = {2,3,1,1,4};
		// int[] nums = {3,2,1,0,4};
		int[] nums = { 1, 0, 1, 0 };
		System.out.println(canJump(nums));
	}
}
