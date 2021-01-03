package com.dq.learning;

public class LongestPalindromic {
	
	
	
	//brutal force
	static int longestPlin(char[] data, int start, int end) {
		
		if(start==end) return 1;
		if(start>end) return 0;
		
		if(data[start]==data[end]) {
			return 2+longestPlin(data, start+1, end-1);
		} else {
			 int inlcudedFirst = longestPlin(data, start, end-1);
			 int notIncluded  = longestPlin(data, start+1, end);
			 return Math.max(inlcudedFirst, notIncluded);
		}
	}
	
	
	//DP: memory way
	static int longestPlin_remember(char[] data, int start, int end, int[][] memory) {
		
		if(start==end) return 1;
		if(start>end) return 0;

		if(memory[start][end]!=0) return memory[start][end];
		
		
		if(data[start]==data[end]) {
			int result= 2+longestPlin(data, start+1, end-1);
			memory[start][end]=result;
			return result;
		} else {
			 int inlcudedFirst = longestPlin(data, start, end-1);
			 int notIncluded  = longestPlin(data, start+1, end);
			 int result= Math.max(inlcudedFirst, notIncluded);
			 memory[start][end]=result;
			 return result;
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		String data="geeksforgeeks";
		System.out.println(longestPlin(data.toCharArray(), 0, data.length()-1 ));
		
		//new memory way
		int N = data.length();
		int[][] memory = new int[N][N];
		for(int i=0;i<N;i++) 
			for(int j=0; j<N; j++) {
				if(i==j) memory[i][j]=0;
				else
					memory[i][j]=0;
			}
		
		
		System.out.println(longestPlin_remember(data.toCharArray(),0,data.length()-1,memory));
	}

}
