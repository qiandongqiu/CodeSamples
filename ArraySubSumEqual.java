package test;

import java.util.HashMap;

//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

public class ArraySubSumEqual {

	public static int subarraySum(int[] nums, int k) {
		 int n = nums.length;
	        HashMap<Integer, Integer> prevSum = new HashMap<>();
	 
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
	                prevSum.put(currsum, 1);
	            else
	                prevSum.put(currsum, count + 1);
	        }
	 
	        return res;
	}

	public static void main(String[] args) {
		int[] nums= {1,2,5,2,1,3};
		System.out.println(subarraySum(nums,7));  //expect 2
		System.out.println(subarraySum(nums,11));  //expect 2

	}
}
