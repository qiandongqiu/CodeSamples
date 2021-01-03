package com.dq.learning;
//https://leetcode.com/problems/nth-digit/

/*
 Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).
Example 1:
Input:
3
Output:
3
Example 2:
Input:
11
Output:
0
Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 */
//good solution here:  https://leetcode.com/problems/nth-digit/discuss/755190/Java-Faster-than-100

public class IntegerNthDigit {
	// : 1 digit number: 9
	// : 2 digits numbers: 90
	// : 3 digits numbers: 900
	// : 4 digits numbers: 9000
	// : x digits numbers: 90...00:(x-1) zeros
	public int findNthDigit(int n) {
		/**
		 * Awesome explanation :
		 * https://leetcode.com/problems/nth-digit/discuss/717042/Python-solution-with-very-detailed-Explanation
		 **/

		// step 1, size 9 : 1,...9
		// step 2, size 90 : 10,11...99
		// step 3, size 900 : 100,101...999
		// ...
		// long for considering last region whose size extends beyond int bounds, eg
		// input 1000000000
		long step = 1;
		long size = 9 * (int) Math.pow(10, step - 1);

		// loop until we reach desired step
		while (n > step * size) {
			n -= step * size;
			step++;
			size = 9 * (int) Math.pow(10, step - 1);
		}
		// extracting number from the current step
		long number = size / 9 + (long) Math.ceil((n * 1.0d) / step) - 1;
		System.out.println("number="+number);
		// extracting digit from above calculated number
		// mod adjustment for converting -1 to last index
		char ansDigit = String.valueOf(number).charAt((int) ((n % step - 1 + step) % step));

		// retriving int out of char
		return (int) (ansDigit - '0');
	}

	public static void main(String[] args) {
		IntegerNthDigit ins = new IntegerNthDigit();
		ins.findNthDigit(11);
		ins.findNthDigit(15);
		ins.findNthDigit(96);
		//ins.findNthDigit(101);
		//ins.findNthDigit(10100);
	}
}
