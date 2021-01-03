package com.dq.learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
/*
 You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:

Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:

Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */
/*
 algorithm:
     using PriorityQueue to store every pair of (sum, i, j), and sorted by sum only.
     we remove from begin(which is the smallest sum); then adding (i+1,j) or (i,j+1). until we find all k items.
 */

public class ArraySmallestPairs {
	class Point implements Comparable<Point> {
		int sum;
		int i;
		int j;
		Point(int a, int b, int c) {
			sum=a;
			i=b;
			j=c;
		}
		
		public int compareTo(Point p) {
			return this.sum - p.sum;
		}
		
	}
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> result = new ArrayList<>();

		int M = nums1.length;
		int N = nums2.length;

		int i = 0, j = 0;
		int count = 0;
		
		Queue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(nums1[0]+nums2[0], 0,0));
		
		Set<String> used = new HashSet<String>();  // "i|j"
		used.add("0|0");
		
		while (!pq.isEmpty() && count < k) {
			//remove the head, add it in output
			Point p = pq.remove();
			List<Integer>  list = new ArrayList<>();
			list.add(nums1[p.i]);
			list.add(nums2[p.j]);
			result.add(list);
			
			//now, since last one is in p.i, and p.j; we try the possbile one next (i+1, j) or (i, j+1)
			// but there is a problem here, (i+1,j) / (i,j+1) may get added already; need check
			if(p.i<M-1) {
				String key = (p.i+1)+"|"+p.j;
				if(!used.contains(key)) {
				   pq.add(new Point(nums1[p.i+1]+nums2[p.j], p.i+1, p.j));
				   used.add(key);
				}
			}
			if(p.j<N-1) {
				String key = p.i+"|"+(p.j+1);
				if(!used.contains(key)) {
				   pq.add(new Point(nums1[p.i]+nums2[p.j+1], p.i, p.j+1));
				   used.add(key);
				}
			}
		}

		return result;

	}

	public static void main(String[] args) {
		ArraySmallestPairs ins = new ArraySmallestPairs();
		// int[] nums1 = { 1, 1, 2 }, nums2 = { 1, 2, 3 };
		// int k = 2;
		// int[] nums1 = { 1, 7, 11 }, nums2 = { 2, 4, 6 };
		// int k = 3;
		int[] nums1 = { 1, 1, 2 }, nums2 = { 1, 2, 3 };
		int k = 10;
		List<List<Integer>> result = ins.kSmallestPairs(nums1, nums2, k);
		for (List<Integer> o : result) {
			System.out.println(o);
		}
	}

}
