package com.dq.learning;

public class RotateArray {

	static void reverseArray(int arr[], int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	// Function to right rotate
	// arr[] of size n by d
	static void rightRotate(int arr[], int d, int n) {
		reverseArray(arr, 0, n - 1);
		//printArray(arr, arr.length);
		reverseArray(arr, 0, d - 1);
		//printArray(arr, arr.length);
		reverseArray(arr, d, n - 1);
	}

	// Function to print an array
	static void printArray(int arr[], int size) {
		for (int i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int n = arr.length;
		int k = 3;

		rightRotate(arr, k, n);
		printArray(arr, n);

	}
}
