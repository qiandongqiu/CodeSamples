package test;

import java.util.Arrays;
//https://leetcode.com/problems/candy/
/*
 There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
 */
/*
 Algo:  first do from begin to end, if rating i+1 > rating i, make sure result[i+1] > result[i];
        do second loop from end to begin, if rating i > raing i+1, make sure result[i] > result[i+1];
 */

public class ArrayDistrictCandy {
	private void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i] + ",");
		}
		System.out.println();
	}

	public int candy(int[] ratings) {
int count = 0;

		int[] result = new int[ratings.length];
		Arrays.fill(result, 1);
		// go from begin to end first
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				while(result[i]<=result[i-1])
					result[i]++;
			}
		}
		print(result);

		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				while(result[i]<=result[i+1])
					result[i]++;
			}
		}
		print(result);

		for (int i = 0; i < result.length; i++) {
			count += result[i];
		}
		return count;
	}

	public static void main(String[] args) {
		ArrayDistrictCandy ins = new ArrayDistrictCandy();

		int[] data = { 1, 2, 87, 87, 87, 2, 1 };

		System.out.println(ins.candy(data));
	}

}
