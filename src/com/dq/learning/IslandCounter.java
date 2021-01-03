package com.dq.learning;
/*
 Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


 */

public class IslandCounter {
	
	public void markNeighbors(char[][] grid, int i, int j) {
		grid[i][j]='0';
         int COL=grid[0].length;
         int ROW=grid.length;
         if(i<0 || j<0 || i>=ROW || j>=COL) return;
		//upper
		if( (i-1)>=0 && grid[i-1][j]=='1') {
			grid[i-1][j]='0';
			markNeighbors(grid, i-1, j);
		}
		//bottom
		if(i+1<ROW && grid[i+1][j]=='1') {
			grid[i+1][j]='0';
			markNeighbors(grid, i+1, j);
		}
		
		//left
		if(j-1>=0 && grid[i][j-1]=='1') {
			grid[i][j-1]='0';
			markNeighbors(grid, i, j-1);
		}
		
		//right
		if(j+1<COL && grid[i][j+1]=='1') {
			grid[i][j+1]='0';
			markNeighbors(grid, i, j+1);
		}
	}

	public int numIslands(char[][] grid) {
         int COL=grid[0].length;
         int ROW=grid.length;
         
         int islandCount = 0;
         
         for(int i=0; i<ROW; i++) {
        	 for(int j=0; j<COL; j++) {
        		 if(grid[i][j]=='1') {
        			 islandCount++;
        			 markNeighbors(grid, i, j);
        		 }
        	 }
         }
         
         return islandCount;
		
	}
	
	
	public static void main(String[] args) {
		char[][] grid = {
		        {'1','1','0','0','0'},
		        {'1','1','0','0','0'},
		        {'0','0','1','0','0'},
		        {'0','0','0','1','1'}
		      };
		
		IslandCounter ins = new IslandCounter();
		System.out.println(ins.numIslands(grid));
	}
}
