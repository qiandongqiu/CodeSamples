package test;
//https://www.geeksforgeeks.org/unique-paths-covering-every-non-obstacle-block-exactly-once-in-a-grid/?ref=lbp

/*
 Given a grid grid[][] with 4 types of blocks:

1 represents the starting block. There is exactly one starting block.
2 represents the ending block. There is exactly one ending block.
0 represents empty block we can walk over.
-1 represents obstacles that we cannot walk over.
The task is to count the number of paths from the starting block to the ending block such that every non-obstacle block is covered exactly once.

Examples:

Input: grid[][] = {
{1, 0, 0, 0},
{0, 0, 0, 0},
{0, 0, 2, -1} }
Output: 2
 */

public class UniquePathInGrid {
	/*algorithm:
	    1) do a dfs from first grid... count how many 0s we encounter, if they are the same as total 0s, we find a good path.
	 */
	static int pathCount=0;
	
	static void getPathUtil(int[][] grid, int currentRow, int currentCol, int zcount, int ztotal, boolean[][] visited) {
		visited[currentRow][currentCol]=true;

		if(grid[currentRow][currentCol]==0) {
			zcount++;
		}
		if(grid[currentRow][currentCol]==2) {
			//at the end, we find one path
			System.out.println("zcount="+zcount);
			if(zcount==ztotal)
				pathCount++;
			
		    visited[currentRow][currentCol]=false;
		    return;
		}
		
		int nextRow=-1, nextCol=-1;
		//up
		if(currentRow-1>=0) {
			nextRow=currentRow-1;
			nextCol=currentCol;
			if(!visited[nextRow][nextCol])
				getPathUtil(grid, nextRow, nextCol, zcount, ztotal, visited);
		}
		//right
		if(currentCol+1<grid[0].length) {
			nextCol=currentCol+1;
			nextRow = currentRow;
			if(!visited[nextRow][nextCol])
				getPathUtil(grid, nextRow, nextCol, zcount, ztotal, visited);
		}
		//bottom
		if(currentRow+1<grid.length) {
			nextRow=currentRow+1;
			nextCol=currentCol;
			if(!visited[nextRow][nextCol])
				getPathUtil(grid, nextRow, nextCol, zcount, ztotal, visited);
		}
		//left
		if(currentCol-1>=0) {
			nextRow=currentRow;
			nextCol=currentCol-1;
			if(!visited[nextRow][nextCol])
			   getPathUtil(grid, nextRow, nextCol, zcount, ztotal, visited);
		}
		
	    visited[currentRow][currentCol]=false;

	}
	
	static int getPath(int[][] grid) {
		int COL=grid[0].length;
		int ROW=grid.length;
		boolean[][] visited = new boolean[ROW][COL];
		
		int ztotal=9;
		getPathUtil(grid, 0,0, 0, 9, visited);
		
		return pathCount;
		
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		System.out.println(getPath(grid));
	}

}
