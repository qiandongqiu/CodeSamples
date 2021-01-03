package com.dq.learning;

import java.util.Stack;

//https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
//Given an array of integers, find the nearest smaller number for every element such that the smaller element is on left side.
/*Algorithm:
   1) using a Stack, to track every number from begin. If the number is bigger than the one on top of stack, pop it; 
      otherwise the nearest smaller number is the one on the top of the stack.
 * */
public class ArrayNearestSmallerNumberOnTheLeft {
	
	static int[] nearestSmallerOnTheLeft(int[] arr) {
		int N =  arr.length;
		int[] result = new int[N];
		Stack<Integer> s = new Stack<>();  //store the index of numbers
		
		for(int i=0; i<N; i++) {
			while(!s.isEmpty() && arr[s.peek()]>=arr[i])   //NOTICE: use while here, not if!!
				s.pop();  //remove the one bigger > current
			
			if(!s.isEmpty()) {  //top of stack is smaller than current
				result[i] = s.peek();
			} else {
				result[i] = -1;
			}
			
			s.push(i);
		}
		
		
		return result;
	}

	
	public static void main(String[] args) {
		 //int arr[] = {1, 6, 4, 10, 2, 5}; //result: -1,1,1,4,1,2
		//int arr[] = {5,2,3,9,4}; //-,-1,1,2,2
		int arr[] = {1, 3, 0, 2, 5};
	     int [] result=nearestSmallerOnTheLeft(arr);
	     for(int one:result)
	       System.out.print(one+",");
	     
	     System.out.println();
	     
	     for(int one:result) {
	    	 if (one>=0) {
	            System.out.print(arr[one]+",");
	    	 }
	    	 else {
	            System.out.print(one+",");
	    	 }
	     }
	     
	}
}
