package com.dq.learning;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/sliding-window-maximum/
/*
Algo:
      
*/

public class ArrayMaxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
		int N=nums.length;
		int[] result = new int[N-k+1];
		
		Queue<Integer> q =  new PriorityQueue<Integer>(Collections.reverseOrder());
		int i=0;
		for(i=0; i<k; i++) {
			q.add(nums[i]);
		}

		
		for(; i<=N-k; i++) {
			q.remove(nums[i-k]);  //remove the first one in the previous window
			
			q.add(nums[i]);   //add next one
			
			result[i]=q.peek();
		}

       return result;
	}
	
	public void printArray(int[] data) {
		for(int i:data) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayMaxSlidingWindow ins = new ArrayMaxSlidingWindow();
		//int[] data= {1,3,2,4,8,2,3,5};
		int[] data = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int[] result = ins.maxSlidingWindow(data, 3);
		ins.printArray(result);
	}
}