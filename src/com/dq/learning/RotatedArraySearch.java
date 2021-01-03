package com.dq.learning;
/*
 You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.


 */

public class RotatedArraySearch {
	public int searchUtil(int[] nums, int target, int m, int n) {
		System.out.println(m+","+n);
		if(m>n) return -1;
		if(m==n) {
			if(nums[m] == target)
				return m;
			else return -1;
		}
		if(n==m+1) {
			if(target==nums[m])
				return m;
			if(target==nums[n])
				return n;
			return -1;
			
		}
		int middle = (m+n) / 2;  //for m=0, n=1, middle is 0, so it could be (0,1) loop forever.

		//System.out.println("middle="+middle);
		
		if(nums[middle]==target) return middle;
		
		//from here on: there are 4 numbers: start, middle, end, and target
		//but all we care about is: where do the target fall in?
		//  if first part is sort: then...
		//  else
		//     2nd part has to be sorted
		if(nums[m]< nums[middle]) {
		  if(target >= nums[m] && target<=nums[middle]) {  //key is between those low/high
		       return searchUtil(nums, target, m, middle);	
		  } else {
			  //not in the sorted part, must be in the other half
			  return searchUtil(nums, target, middle, n);
		  }
		} //first part is sorted
		else  {  //second part is sorted
			if(target >=nums[middle] && target<=nums[n]) {
			  return searchUtil(nums, target, middle, n);
			} else {
			  return searchUtil(nums, target, m, middle);
			}
			
		}
	}
	public int search(int[] nums, int target) {
		int L = nums.length;
		if(L==0) return -1;
		
		return searchUtil(nums, target, 0, nums.length-1);
	}
	
	
	public static void main(String[] args) {
		//int[] nums={4,5,6,7,0,1,2};
		int[] nums={5,1,3};

		
		RotatedArraySearch ins = new RotatedArraySearch();
		int r = ins.search(nums, 5);
		System.out.println(r);
		
	}
}
