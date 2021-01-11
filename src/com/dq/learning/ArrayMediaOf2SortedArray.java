package com.dq.learning;

//find Median of 2 sorted arrays
//Algo:  find the MIDDLE number of the total number of items: we go from 2 arrays, smaller number first, iterator through both array, until we get to the middle number
public class ArrayMediaOf2SortedArray {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int totalCount = m + n;

		int middle = 0;
		boolean isOdd = (totalCount % 2 != 0);
		System.out.println("isOdd=" + isOdd);
	

		middle = totalCount / 2; // ( 3/2=1; 4/2=2)
		System.out.println("middle=" + middle);

		int mi = 0, ni = 0;
		int currentIndex = 0;
		int previousNumber = 0;
		int currentNumber = 0;
		// : 0,1,3
		// : 2,4
		do {
			if (mi < m && ni < n) {

				if (nums1[mi] < nums2[ni]) {
					previousNumber = currentNumber;
					currentNumber = nums1[mi];
					mi++;
				} else {
					previousNumber = currentNumber;
					currentNumber = nums2[ni];
					ni++;
				}
			} else {
				if(mi<m) {
					previousNumber = currentNumber;
					currentNumber = nums1[mi];
					mi++;
				}
				
				if(ni<n) { 
					previousNumber = currentNumber;
					currentNumber = nums2[ni];
					ni++;
				}
				
			}
			currentIndex = mi + ni;
		} while (currentIndex <= middle);

		if (isOdd) {
			return (double) currentNumber;
		} else {
			return (currentNumber + previousNumber) / 2.0;
		}
	}

	public static void main(String[] args) {
		 int[] nums1= {0,0};
		 int[] nums2 = {0};
		//int[] nums1 = { 1, 2 };
		//int[] nums2 = { 3, 4 };
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
