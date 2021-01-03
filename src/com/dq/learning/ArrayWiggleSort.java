package com.dq.learning;

import java.util.Arrays;

public class ArrayWiggleSort {
	public static void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int N=nums.length;

		for(int i=0; i<N; i+=2) {
			   int tmp=nums[i];
			   nums[i]=nums[i+1];
			   nums[i+1]=tmp;
		}
		
		for(int k:nums) {
			System.out.println(k+",");
		}

	}
	
	static void swap(int arr[], int a, int b) 
    { 
        int temp = arr[a]; 
        arr[a] = arr[b]; 
        arr[b] = temp; 
    } 
	
	// This function sorts arr[0..n-1] in wave form, i.e., 
    // arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4].... 
    static void sortInWave(int arr[], int n) 
    { 
        // Traverse all even elements 
        for (int i = 0; i < n; i+=2) 
        { 
            // If current even element is smaller 
            // than previous 
            if (i>0 && arr[i-1] > arr[i] ) 
                swap(arr, i-1, i); 
  
            // If current even element is smaller 
            // than next 
            if (i<n-1 && arr[i] < arr[i+1] ) 
                swap(arr, i, i + 1); 
        } 
    } 
    
    

	public static void main(String[] args)
	{
		//int[] nums={2,8,9,10,5,7,3};
		//int[] nums={2,8,9,10,5,7};
		int[] nums={14,8,10,9};
		//wiggleSort(nums);
		sortInWave(nums,nums.length);
		for(int k:nums) {
			System.out.print(k+",");
		}

	}
}
