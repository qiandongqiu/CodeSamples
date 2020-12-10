package test;

import java.util.ArrayList;
import java.util.Collections;

//https://www.geeksforgeeks.org/find-the-k-th-permutation-sequence-of-first-n-natural-numbers/
//Try to solve the problem by get all the permutations, then sort them, then get the right one.
// but this failed too: it took too long!!!  
public class PermutationSequnceDQ {
	static ArrayList<String> allPermutations = new ArrayList<>();
	
	//stupid way: get all permutations
	static void swap(int[] data, int a, int b) {
		int tmp=data[a];
		data[a]=data[b];
		data[b]=tmp;
	}
	static void print(int[] data) {
		System.out.println(arrayToString(data));
	}
	
	static String arrayToString(int[] data) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<data.length; i++)
		  sb.append(data[i]);
		
		return sb.toString();
	}
	
	static String permutation(int[] data, int l, int r, int expectedIndex) {
		
		if(l==r) {
			allPermutations.add(arrayToString(data));
		}
		
		for(int i=l; i<=r; i++) {
			swap(data,l,i);
			permutation(data, l+1, r, expectedIndex);
			swap(data,l, i);
		}
		
		return null;
	}
	

	static String findKthPermutation(int n, int k) {
         int data[] = new int[n];
         for(int i=0; i<n; i++)
        	 data[i]=i+1;
         
         permutation(data, 0, n-1, k);
         Collections.sort(allPermutations);
         return allPermutations.get(k-1);
         
	}
	
	// Driver code
		public static void main(String[] args)
		{
		  int n = 9, k = 13596;
		  String kth_perm_seq = findKthPermutation(n, k);
		  System.out.print(kth_perm_seq + "\n");
		}
	
}

