package com.dq.learning;
//https://leetcode.com/problems/find-right-interval/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ArrayRightInterval {
	
	class MyComparator implements Comparator<int[]> {
	   public int compare(int[] a, int[] b) {
		   return a[0] - b[1];
	   }
	}
	
	public int[] findRightInterval(int[][] intervals) {
       int N = intervals.length;
       int[] result = new int[N];
       
       Map<Integer, Integer> index = new HashMap<>();
       for(int i=0;i<N;i++) {
    	   index.put(intervals[i][0], i);
       }
       
       Arrays.sort(intervals, new MyComparator() );
       for(int i=0;i<N;i++) {
    	   int originalIndex = index.get(intervals[i][0]);
    	   int k = i<N-1? index.get(intervals[i+1][0]) : -1;
    	   result[originalIndex] = k;
       }
       
       
       return result;
    }
	
	public static void main(String[] args) {
		int[][] nums={{3,4},{2,3},{1,2}};
		ArrayRightInterval ins = new ArrayRightInterval();
		int[] result = ins.findRightInterval(nums);
		for(int one:result) {
			System.out.print(one+",");
		}
	}
}
/*
 * You are given an array of intervals, where intervals[i] = [starti, endi] and
 * each starti is unique.
 * 
 * The right interval for an interval i is an interval j such that startj >=
 * endi and startj is minimized.
 * 
 * Return an array of right interval indices for each interval i. If no right
 * interval exists for interval i, then put -1 at index i.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,2]] Output: [-1] Explanation: There is only one
 * interval in the collection, so it outputs -1. Example 2:
 * 
 * Input: intervals = [[3,4],[2,3],[1,2]] Output: [-1,0,1] Explanation: There is
 * no right interval for [3,4]. The right interval for [2,3] is [3,4] since
 * start0 = 3 is the smallest start that is >= end1 = 3. The right interval for
 * [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
 * Example 3:
 * 
 * Input: intervals = [[1,4],[2,3],[3,4]] Output: [-1,2,-1] Explanation: There
 * is no right interval for [1,4] and [3,4]. The right interval for [2,3] is
 * [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
 * 
 */