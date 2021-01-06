package com.dq.learning;
//Convert a number to base7
// The key to remember is that: when number <0; then we do it on its abs value; then add "-" at the beginning!
public class Base7 {
	public static String convertToBase7(int num) {
		if (num == 0)
			return "0";

		StringBuilder sb = new StringBuilder();

		int tmp = Math.abs(num);
		while (tmp > 0) {
			int v = tmp % 7;
			sb.insert(0, v);
			tmp = tmp / 7;
		}

		if(num<0) sb.insert(0, '-');
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(convertToBase7(100));
		System.out.println(convertToBase7(-7));
	}

}
