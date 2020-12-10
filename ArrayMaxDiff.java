package test;
//https://practice.geeksforgeeks.org/problems/maximum-index3307/1

public class ArrayMaxDiff {

	public static int maxDiff(int[] arr, int n) {
		int lmin[] = new int[n];  //left min: min value of this item and items on its left
		int rmax[] = new int[n]; //right max: max value of this item and items on its right
		lmin[0] = arr[0];
		for (int i = 1; i < n; i++) {
			lmin[i] = Math.min(arr[i], lmin[i - 1]);
		}
		rmax[n - 1] = arr[n - 1];

		for (int i = n - 2; i >= 0; i--) {
			rmax[i] = Math.max(arr[i], rmax[i + 1]);
		}
		
		for(int k : lmin) {
			System.out.print(k+" ");
		}
		System.out.println();
		for(int k : rmax) {
			System.out.print(k+" ");
		}
		System.out.println();
		
		int i = 0;
		int j = 0;
		int maxDiff = -1;
		while (i < n && j < n) {
			if (rmax[j] >= lmin[i]) {
				maxDiff = Math.max(maxDiff, j - i);
				j = j + 1;
			} else {
				i = i + 1;
			}
		}
		if (maxDiff == -1) {
			return 0;
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		int arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println(maxDiff(arr,9));
	}
}
