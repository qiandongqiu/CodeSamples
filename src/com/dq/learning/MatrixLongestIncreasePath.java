package com.dq.learning;

import java.util.Arrays;

/*
 https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 */
/*
 Algo:  from every node, do a DFS. But, DFS is slow, we have to use DP to remember it.
        Also, there is no need to use Visited array, since we go up on value, there is no way to go from big number to small number.
 */

public class MatrixLongestIncreasePath {
	private boolean[][] copy2dArray(boolean[][] src) {
		boolean[][] dst = new boolean[src.length][];
		for (int i = 0; i < src.length; i++) {
			dst[i] = Arrays.copyOf(src[i], src[i].length);
		}
		return dst;
	}

	private int DFS(int[][] matrix, boolean[][] visited, int sr, int sc) {
		if (sr < 0 || sc < 0)
			return 0;
		int ROW = matrix.length;
		int COL = matrix[0].length;
		if (sr > ROW)
			return 0;
		if (sc > COL)
			return 0;

		// from (sr,sc), there are 4 ways to do.
		// left: sr, sc-1
		visited[sr][sc] = true;
		boolean[][] visitedTmp = copy2dArray(visited);
		int rightMax = 0;
		if ((sc - 1) >= 0) {
			if (matrix[sr][sc - 1] > matrix[sr][sc])
				rightMax = DFS(matrix, visitedTmp, sr, sc - 1);
		}

		// top: sr-1, sc
		visitedTmp = copy2dArray(visited);
		int topMax = 0;
		if ((sr - 1) >= 0) {
			if (matrix[sr - 1][sc] > matrix[sr][sc])
				topMax = DFS(matrix, visitedTmp, sr - 1, sc);
		}
		// right: sr, sc+1
		visitedTmp = copy2dArray(visited);
		int leftMax = 0;
		if ((sc + 1) < COL) {
			if (matrix[sr][sc + 1] > matrix[sr][sc])
				leftMax = DFS(matrix, visitedTmp, sr, sc + 1);
		}
		// bottom: sr+1, sc
		visitedTmp = copy2dArray(visited);
		int bottomMax = 0;
		if ((sr + 1) < ROW) {
			if (matrix[sr + 1][sc] > matrix[sr][sc])
				bottomMax = DFS(matrix, visitedTmp, sr + 1, sc);
		}

		int result = Math.max(Math.max(rightMax, topMax), Math.max(leftMax, bottomMax));
		return result + 1; // plus one, for this item itself
	}
	
	private int DFS_no_visited(int[][] matrix, int r, int c, int[][] DP) {
		int ROW = matrix.length;
		int COL = ROW>=0? matrix[0].length: 0;
		
		if(DP[r][c]!=-1) return DP[r][c];
		
		
		int[] rowplus = {0,-1,0,1};
		int[] colplus = {-1,0,1,0};
		
		int result=0;
		for(int k=0; k<4; k++) {
			int x = r+rowplus[k];
			int y = c+colplus[k];
			if(x<0 || x>=ROW) continue;
			if(y<0 || y>=COL) continue;
			int innerCount=0;
			if(matrix[x][y] > matrix[r][c])
				innerCount = DFS_no_visited(matrix,x,y, DP);
			
			result = Math.max(result,innerCount);
		}
		DP[r][c] = result+1;
		return result + 1;
	}

	public int longestIncreasingPath(int[][] matrix) {
		int ROW = matrix.length;
		int COL = ROW>0?matrix[0].length:0;
		
		//DP memory
		int[][] DP = new int[ROW][COL];
		for(int i=0; i<ROW; i++) {
			for(int j=0;j<COL; j++) {
				DP[i][j]=-1;
			}
		}
		
		
		int result = 0;
		for (int r = 0; r < ROW; r++) {
			for (int c = 0; c < COL; c++) {
				//boolean[][] visited = new boolean[ROW][COL];
				//int tmp = DFS(matrix, visited, r, c);
				int tmp = DFS_no_visited(matrix, r, c, DP);
				if (tmp > result)
					result = tmp;
			}
		}

		return result;

	}

	public static void main(String[] args) {
		//int[][] nums = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };  //expected 4, ( starting with 1)
		//int[][] nums = {{}};
		int[][] nums = {{1,2}};	

		MatrixLongestIncreasePath ins = new MatrixLongestIncreasePath();
		int r = ins.longestIncreasingPath(nums);
		System.out.println(r);
	}
}
