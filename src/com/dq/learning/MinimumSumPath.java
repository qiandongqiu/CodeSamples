package com.dq.learning;

import java.util.Arrays;
//DQ: this is easy, DP problem
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

/*
 DQ: this is a DP? 
     1) DP[i][j] to contains shortest path from [0,0] to [i,j]
        set DP[0][0]=grid[0][0]
     2) DP[i][j] = MIN ( RIGHT, BOTTOM )
 */

public class MinimumSumPath {
	public static int minPathSum(int[][] grid) {
		int M = grid.length;
		int N = grid[0].length;

		int[][] DP=new int[M][N];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				DP[i][j]=Integer.MAX_VALUE;
			}
		}
		
		DP[0][0]=grid[0][0];
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(i==0 && j==0) continue;
				
				//find min from Left
				int left=Integer.MAX_VALUE;
				if(i-1>=0) {
					left = DP[i-1][j];
				}
				//find min from top
				int top=Integer.MAX_VALUE;
				if(j-1>=0) {
				    top = DP[i][j-1];
				}
				DP[i][j] = Math.min(left, top) + grid[i][j];
			}
		}
		
		return DP[M-1][N-1];

	} //function end
	
	
	
	public static void main(String[] args) {
		int[][] grid={
		              {1,3,1},
		              {1,5,1},
		              {4,2,1}
		            };
		
		int dist =  minPathSum(grid);
		System.out.println(dist);
		
	}

}
