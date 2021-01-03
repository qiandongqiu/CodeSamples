package com.dq.learning;
//https://leetcode.com/problems/elimination-game/

/*
 There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number 
 afterward until you reach the end of the list. 
Repeat the previous step again, but this time from right to left, remove the right most number and every other number 
from the remaining numbers.
We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
Find the last number that remains starting with a list of length n.
Example:

Input:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

Output:
6
 */

/*
 * Algorithm: this is the one that I found online that is easily understood:
 *   1) it starts to delete the first one (left-to-right), and use a variable firstNum to remember what the current value is for the first number.
 *   2) it uses a diff to remember what the numbers are apart: originally it is 1; after delete 1, then it is 2; then after another delete, it is 4.... 
 *   3) eventually it only has one left: the value is in firstNum.
 *  */

public class EliminateNumber {
	public static int lastRemaining(int n) { // delete 1st, 3rd,....
		// 数组中的首位元素
		int firstNum = 1;
		int diff = 1;// 间隔
		boolean isLeft = true;// 是否从左侧开始删除
		while (n > 1) {
			// 首元素被删除
			// 如果是左起删除，或者右起当前数组长度为奇数时，
			if (isLeft || n % 2 == 1) {
				firstNum += diff;
			}
			// 每次删除后n减半
			n /= 2;
			// diff增加2倍
			diff *= 2;
			// 更换删除方向
			isLeft = !isLeft;
		}
		// 返回剩下的首元素
		return firstNum;
	}

	public static void main(String[] args) {
		System.out.println(lastRemaining(14));
		System.out.println(lastRemaining(12));
	}
}
