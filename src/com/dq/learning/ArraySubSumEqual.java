package com.dq.learning;

import java.util.HashMap;

//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

public class ArraySubSumEqual {

	//this is good way: O(n)
	// the trick is: we remember how many ways we can get to a sum in hashmap (sum, count).
	//               when we get to a current sum from 0..i, if  currSum == target, then we add 1 to the counter; 
	//               also, if (currSum-k) was seen before, then we add counter on (currSum-k) to the result.
	public static int subarraySum(int[] nums, int k) {
		 int n = nums.length;
	        HashMap<Integer, Integer> prevSum = new HashMap<>(); //contains (sum, count) map, the summary of "sum" has been seen "count" times so far
	 
	        int res = 0;
	 
	        // Sum of elements so far.
	        int currsum = 0;
	 
	        for (int i = 0; i < n; i++) {
	 
	            // Add current element to sum so far.
	            currsum += nums[i];
	 
	         
	            if (currsum == k)
	                res++;
	 
	           
	            if (prevSum.containsKey(currsum - k))
	                res += prevSum.get(currsum - k);  // the point here: if sum is 10, k is 7, and there is a sum of 3 encounter, then add result at sum 3 to it
	 
	            Integer count = prevSum.get(currsum);
	            if (count == null)
	                prevSum.put(currsum, 1); // seen this currsum for first time, add 1 in the map
	            else
	                prevSum.put(currsum, count + 1);
	        }
	 
	        return res;
	}
	
	
	
	//This is a slow way: O(nxn)
	public static int subarraySumSlow(int[] nums, int k) {
		int N = nums.length;
		int count=0;
		for(int i=0; i<N; i++) {
			int sum = nums[i];
			for(int j=i+1;j<N; j++) {
				sum += nums[j];
				if(sum==k) count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums= {1,2,5,2,1,3};
		System.out.println(subarraySum(nums,7));  //expect 2
		System.out.println(subarraySum(nums,11));  //expect 2
		
		System.out.println(subarraySumSlow(nums,7));  //expect 2
		System.out.println(subarraySumSlow(nums,11));  //expect 2
		

	}
}
