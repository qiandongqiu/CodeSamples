package com.dq.learning;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// Find the minimum value of it.
//e.g.  [2,3,3,3,5,0,1] =>>> 0

//Algorithm:  
//  1) we could go through every one of them, and find it. O(n)
//  2) a better way is to use divider/conquer: find left/right, using middle to see where we go next.

public class ArrayRotatedMinumimValue {

	 public int findMin(int[] nums) {
		 int min=nums[0];
		 for(int i=0;i<nums.length; i++)
			 if(nums[i]<min) min=nums[i];
		 
		 return min;
	 }
	 
	 public int findMinBetter(int[] nums) {
		 int l=0, r = nums.length-1;
		 
		 while(l<r) {
			 int mid = (l+r) / 2;
			 if(nums[l] < nums[mid]) {    //we just compare l to mid:  l>mid, l<mid, or l==mid
				 l = mid;
			 } else if(nums[l] > nums[mid]) {
				 r=mid;
			 } else {
				 l++; 
			 }
		 }
		 return nums[l];
	 }
	 
	
	 public static void main(String[] args) {
		 //int[] nums= {3,4,5,6,0,1,2};
		 int[] nums= {3,4,5,6,7,0,1,2,3};
		 ArrayRotatedMinumimValue ins = new ArrayRotatedMinumimValue();
		 System.out.println(ins.findMinBetter(nums));
	 }
	
}
