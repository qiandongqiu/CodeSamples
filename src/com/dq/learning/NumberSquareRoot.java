package com.dq.learning;

//found sqrt of an integer number (floor)

public class NumberSquareRoot {
	
	public static int squareRoot(int number) {
		
		int n=1;
		while(n*n<=number) {
			n++;
		}
		
		return n-1;
		
	}
	
	
	public static double sqrt2(int number, int precision) {
		int bigPart = squareRoot(number);
		
		
		double s=1;
		double result=bigPart;
		
		int precisionIte=0;
		
		while(precisionIte++<precision) {
			s = s / 10;
			
			result+=s;
			while(result*result <= number) 
				result+=s;
			
			result-=s;
		}
		
		return result;
	}
	
	
	
	
	public static void main(String[] args ) {
		System.out.println(squareRoot(10));
		System.out.println(squareRoot(145));
		
		System.out.println("ok");
		System.out.println(sqrt2(10,3));
		System.out.println(sqrt2(145,3));
	}

}
