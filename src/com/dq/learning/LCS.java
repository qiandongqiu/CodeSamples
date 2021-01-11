package com.dq.learning;

public class LCS {
	
	//: LCS(A[m], B[n]) =  
	//     if A[m-1]==B[n-1], then =1+ LCS(A[m-1], B[n-1])
    //     else   = max ( LCS(A[m-1],B[n]), LCS(A[m], B[n-1))
	
	static int getLCS(char[] A, char[] B, int m, int n) {
		if(m==0 || n==0) {
			return 0;
		}
		if(A[m-1]==B[n-1]) {
			return 1+getLCS(A,B, m-1, n-1);
		} else {
			return Math.max(getLCS(A,B,m-1,n), getLCS(A,B,m,n-1));
		}
		
	}
	
	//DP way:  L[m+1][n+1] is the LCS for [0...m][0...n]
	//         L[ either m==0][or m==0] =0
	//         [m-1]==[n-1], L[m][n]= 1 + L[m-1][n-1]
	//          else       L[m][n] = max(L[m-1][n], L[m][n-1]
	
	static int dpLCS(char[] A, char[] B, int m, int n) {
		int[][] L = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				} else {
					if (A[i - 1] == B[j - 1]) {
						L[i][j] = 1 + L[i - 1][j - 1];
					} else {
						L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
					}
				}
			}
		}

		return L[m][n];
	}
	
	
	public static void main(String[] args) {
		char[] A= {'a','x','b','e','Z'};
		char[] B= {'z','a','x','e','Z'};
		System.out.println(getLCS(A,B,A.length,B.length));
		System.out.println(dpLCS(A,B,A.length,B.length));
	}

}
