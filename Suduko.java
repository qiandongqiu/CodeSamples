package test;

import java.util.Arrays;

public class Suduko {
	public static final int N=9;
	
	public static int totalCount = 0;
	
	static boolean isSafe(int[][] grid, int row, int col, int num) { //whether num is safe to put on (row,col)
		//1: check whether row is safe
		for(int i=0; i<N; i++) {
			if(grid[row][i]==num) return false;
		}
		//2: check whether col is safe
		for(int i=0; i<N; i++) {
			if(grid[i][col] == num) return false;
		}
		
		//3: check whether the small 3x3 grid is safe
		int startRow = row - row % 3;
		int startCol = col - col % 3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(grid[startRow+i][startCol+j] == num) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static boolean solve(int[][] grid) {

		//step 1: find first value need to be filled (value is still 0)
		boolean foundEmpty=false;
		int row=-1, col=-1;
		for(int i=0;i<N; i++)  {
			for(int j=0; j<N; j++) {
                if(grid[i][j]==0) {
                	foundEmpty=true;
                	row=i;
                	col=j;
                	break;
                }
			}
			if(foundEmpty) {
				break;
			}
		}
		
		if(!foundEmpty) {
	        printGrid(grid);
	        System.out.println("-------------------------------- " + totalCount++);
			//return true; //all values are filled, and they are good, since we check before we put any value
	        return false; //TEST:keep going to find all good ones?
		}
		
		
		for(int num=1;num<=9;num++) {
			if(isSafe(grid,row,col,num)) {
				grid[row][col] = num;
				if(solve(grid)) return true;
				
				grid[row][col]=0;
			}
		}
		
		return false;
	}
	
	public static void printGrid(int[][] grid) {
		for(int r=0; r<N; r++) {
			System.out.print("{");
			for(int c=0; c<N; c++) {
               System.out.print(grid[r][c]+",");
				
			}
			System.out.print("},");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		 // 0 means unassigned cells 
		/*
		int[][] grid = new int[][] { 
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 } 
        }; 
        */
		int[][] grid = new int[][] { 
			{1,2,3,4,5,6,7,8,9},
			{4,5,6,7,8,9,1,2,3},
			{7,8,9,1,2,3,4,5,6},
			{2,1,4,3,6,5,8,9,7},
			{3,6,7,9,1,8,2,4,5},
			{8,9,5,2,4,7,6,3,1},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0}
		};
        
        //TEST 2
        //fill all 0, to see how many permutations are there: too huge, it runs never exiting
        //for(int r=0;r<N;r++) {
        //  Arrays.fill(grid[r], 0);
        //}

	    if (solve(grid) != true) 
	        System.out.println("No solution exists"); 
	    else {
	        System.out.println("solution exists"); 
	        //printGrid(grid);
	    }
	  
	    return; 
	}

}
