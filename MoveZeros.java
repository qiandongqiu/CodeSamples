package test;

import java.util.Arrays;

//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
public class MoveZeros {
	// method using another array
	 public static void moveZeroes_2(int[] nums) {
		   int[] result=Arrays.copyOf(nums, nums.length);
		   int lastLocation=nums.length-1;
		   int firstLocation=0;
		   
		   for(int i=0; i< result.length; i++) {
			  if(result[i]!=0) {
				  nums[firstLocation++]=result[i];
			  } else {
				  nums[lastLocation--] = result[i];
			  }
		   }
	       return; 
	 }
	 
	 //method using in-place
	 //  algorithm:
	 //     1) init a counter to count how many non-zeros encountered
	 //     2) go over every item
	 //            if item is not zero, arr[counter++]=the value
	 //     3) for counter<n, init them to 0
	 public static void moveZeroes(int[] nums) {
		 int counter=0;
		 for(int i=0;i<nums.length; i++) {
			 if(nums[i]!=0) {
				 nums[counter++]=nums[i];
			 }
		 }
		 while(counter<nums.length)
			 nums[counter++]=0;
	 }

	 
	 public static void main(String[] args) {
		int[] nums =  {0,1,0,3,12,0,2,0}; 
		moveZeroes(nums);
		for(int one:nums) {
		   System.out.print(one+",");
		}
	 }
	 
}
