package com.dq.learning.sort;

public class QuickSort {
	public static void swap(int[] data, int a, int b) {
		int tmp=data[a];
		data[a]=data[b];
		data[b]=tmp;
	}
	
	public static int partition(int[] data, int l, int r) {
		int pivot = data[r];
		
		int i=l-1;
		
		for(int j=l;j<=r-1;j++) {
			if(data[j]<pivot) {
				i++;
				//put data j at i; do swap
				swap(data, i,j);
			}
		}
		swap(data,i+1, r);
		return i+1;
		
	}
	
	public static void quickSort(int[] data, int l, int r) {
		if(l<r) {
		   int p = partition(data, l, r);
		   quickSort(data,l,p-1);
		   quickSort(data,p+1,r);
		}
	}

	public static void main(String[] args) {
		int[] data= {10,12,8,20,4,7,1,30};
		quickSort(data,0,data.length-1);
		for(int k:data) {
			System.out.print(k+",");
		}
	}
}
