package com.dq.learning;

import java.util.TreeSet;

import javafx.util.Pair;

// https://leetcode.com/problems/count-of-range-sum/
/*
 Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:

Input: nums = [-2,5,-1], lower = -2, upper = 2,
Output: 3 
Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 */
/*
 Algorithm:
    i go from 0...N-1, 
       let sum += nums[i]
       if sum is in range, add it to result;
       now, caculating how many sums we have seen so far which lies inbetween (sum-upper) and (sum-lower+1), add it to the result too.
       Here, we use TreeSet to store the sums we have seen before, so that we can create/retrieve it in nlog(n) time.
 */
/*
 sum[i]表示前n项和，任意区间[i，j]的和可以通过sum[j+1]-sum[i]
在O(1)得到，sum[0]=0,sum[i+1]表示区间[0,i]的累计和，要找到满足需求的区间，
需要符合：lower <= sum[i + 1] - x <= upper，推导可得sum[i + 1] - upper <= x
<= sum[i + 1] - lower,对于二分查找树而言，计算上界和下界的时间复杂度都是O(nlogn)，
所以该算法的时间复杂度是O(nlogn)，而空间复杂度则是O(n)：
 */

public class ArrayCountRangeSum {
	  public int countRangeSum(int[] nums, int lower, int upper) {
	        int res = 0;
	        long sum = 0;
	        //Using TreeSet to store <Sum,Index-to-this-sum>, the reason that we need the index is that we may have same sums at different indexes. 
	        // With index, we keep the duplicated Sums in the Set.  TreeSet uses O(log(N)) for basic operations.
            TreeSet<Pair<Long, Integer>> set = new TreeSet<Pair<Long, Integer>>((a,b)->(a.getKey() > b.getKey() ? 1 : -1));

	        for(int i=0; i<nums.length; i++){
	            sum+=nums[i];
	            if(sum >= lower && sum <= upper)
	                res++;
	            
	            if(set.size()>0){
	                res+=set.subSet(new Pair<Long, Integer>(sum-upper,i), new Pair<Long, Integer>(sum-lower+1,i)).size();
	            }
	            set.add(new Pair<Long, Integer>(sum,i));
	        }
	        return res;
	    }
	  
	  public static void main(String[] args) {
		   int[] nums = {-2,5,-1};
		  ArrayCountRangeSum ins = new ArrayCountRangeSum();
		  System.out.println(ins.countRangeSum(nums, -2, 2));
	  }

}
