package com.dq.learning;

public class CountOnes {

	public static int countOnes(int number) {
		int bit=1;
		int count=0;
		int result=0;
		while(count<32) {
			if( (number & bit) > 0) result++;
			bit = bit << 1;
			count++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(countOnes(7));
		System.out.println(countOnes(8));
	}
}
