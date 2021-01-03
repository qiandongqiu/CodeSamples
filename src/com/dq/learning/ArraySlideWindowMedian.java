package com.dq.learning;

import java.util.Arrays;

public class ArraySlideWindowMedian {
	 private double media(int[] arr) {
			Arrays.sort(arr);
		   int N=arr.length;
		   int middle=N/2;
		   if(N%2==1) return arr[middle];
		   else {
			   return (1.0d*arr[middle]+arr[middle-1])/2.0d; //NOTE: when value is MAX, overflow; that is why we need use 1.0d*number
		   }
		}

		public double[] medianSlidingWindow(int[] nums, int k) {
			int[] window = new int[k];

			int N = nums.length;
			double[] result = new double[N - k + 1];

			for (int j = 0; j < k; j++) {
				window[j]=nums[j];
			}
			result[0]=media(window);
			

			for (int i = 1; i <= N-k; i++) {
			   for (int j = i; j <i+k; j++) {
				   window[j-i]=nums[j];
			   }
				// now, find the middle in the pq;
				double d = media(window);
				result[i] = d;
			}

			return result;
		}
	public static void main(String[] args) {
		//System.out.println(5/3);
		ArraySlideWindowMedian ins = new ArraySlideWindowMedian();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 }; // result: [1,-1,-1,3,5,6].
		double[] res = ins.medianSlidingWindow(nums, 3);
		for (double d : res) {
			System.out.print(d + ",");
		}
	}

}
