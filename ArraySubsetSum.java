package test;

//https://www.geeksforgeeks.org/subset-sum-problem-dp-25/
/*
 Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
Example:

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.
 */

public class ArraySubsetSum {
	
	// stupid way:  count last item in or not
	public static boolean subsetSum(int[] arr, int n, int sum) {
		if(sum==0) return true;
		
		if(n==0) return false;   //no numbers left, but sum is not 0
		
		if(arr[n-1]>sum) {
			//then, the answer is in the items without n-1 item
			return subsetSum(arr, n-1, sum);
		} else {
			return  subsetSum(arr, n-1, sum-arr[n-1]) || subsetSum(arr, n-1, sum);  //either last one is used in the sum, or not used in the sum
		}
		
	}
	
	//DP way:
	//  we have 2-D array, 1 dimension is items, another dimension is the 0...sum
	//  Result[i][j] means:  for 0...i items, the sum is j or not.
	//     for set[] = {3, 34, 4, 12, 5, 2}, sum = 9
	//        0  1  2 3  4  5  6  7  8  9
	//   0    T  f  f f  f  f  f  f  f  f
 	//   3    f  f  f T  f  f  f  f  f  f
	//  34    f  f  f T  f  f  f  f  f  f
	//   4    f  f  f T  T  f  f  T  f  f
	//  12
	//   5
	//   2
	
	public static boolean subsetSumDP(int[] arr, int n, int sum) {
		//result[i][j] means: from 0...i items, whether a solution for sum==j exists or not
		boolean[][] result=new boolean[n+1][sum+1];
		for(int i=0; i<=n; i++) {
			result[i][0] = true;  //when: sum is 0, return true
		}
		
		for(int i=1; i<=sum; i++) {
			result[0][i] = false; // item is 0 (non-left), but sum is not 0, return false;
		}
		
		for(int i=1; i<=n; i++) {
			for(int s=1; s<=sum; s++) {
				     result[i][s]=result[i-1][s];
				     if(s >= arr[i-1]) {
				         result[i][s] = result[i][s] || result[i-1][s-arr[i-1]];
				     }
			}
		}
		
		printOutNumbers(arr, result, n, sum);
		
		return result[n][sum];
	}
	
	
	//dq's note: added way to figure out the detailed numbers
	public static void printOutNumbers(int[] arr, boolean[][] result, int x, int sum) {  //x: item, y : sum
		if(x<=0) return;
		
		if(result[x][sum]) {
		   if(result[x-1][sum]) {  //means this item does not count, sum comes from other items
			   printOutNumbers(arr, result, x-1, sum);
		   } else {
		      System.out.println(arr[x-1]);
		       printOutNumbers(arr, result, x-1, sum-arr[x-1]);
		   }
		} 
	}
	
	
	public static void main(String[] args ) {
		int arr[] = {3, 34, 4, 12, 5, 2};
		
		
		System.out.println(subsetSum(arr,6,30));
		//System.out.println(subsetSumDP(arr,6,38));
	}
	

}
