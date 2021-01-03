package com.dq.learning;

public class HowManyOnes {
	
	public static int countOnes(long value) {
		long mask=0x01;
		int count=0;
		
		int size=Long.SIZE * 8;
		
		int i=0;
		do {
			if((value & mask) != 0) {
				count++;
			}
			mask = mask << 1;
			
			i++;
		} while(i<size);

		return count;
	}
	
	public static void main(String[] args) {
		long value=1516789908927777799L;
		System.out.println(countOnes(value));
		System.out.println(Long.bitCount(value));
	}

}
