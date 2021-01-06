package com.dq.learning;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
/*
 * Input: arr = [0,1,2,3,4,5,6,7,8]
 *  Output: [0,1,2,4,8,3,5,6,7]
 */

public class SortByBits {

	class BitComparator implements Comparator<Integer> {
		public int compare(Integer a, Integer b) {
			int ba = Integer.bitCount(a);
			int bb = Integer.bitCount(b);
			if (ba != bb) {
				return ba - bb;
			} else {
				return a - b;
			}
		}
	}

	public int[] sortByBits(int[] arr) {

		Integer[] tmp = new Integer[arr.length];   //NOTE: the key here, we have to turn int[] into Integer[]; otherwise, Arrays.sort cannot be used on in[] below.
		for (int i = 0; i < arr.length; i++)
			tmp[i] = arr[i];

		Arrays.sort(tmp, new BitComparator());
		
		
		for(int k=0;k<tmp.length;k++) {
			arr[k] = tmp[k];
		}

        return arr;
	}
	
	
	public static void main(String[] args) {
		int[] data= {0,1,2,3,4,5,6,7,8};
		SortByBits ins = new SortByBits();
	    ins.sortByBits(data);
	    
	    for(int i=0;i<data.length;i++)
	    	System.out.print(data[i]+" ");
		
	}

}
