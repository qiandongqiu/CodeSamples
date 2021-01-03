package com.dq.learning.sort;

public class BubbleSort {
	public static void bubbleSort(int[] data) {
		int N=data.length;
		
		for(int i=0;i<N-1;i++) {
			for(int j=0; j<N-i-1;j++) {  //for every i, the maximum number is already at the end; so we do N-i
				if(data[j]>data[j+1]) {
					//switch j and j+1
					int tmp=data[j+1];
					data[j+1]=data[j];
					data[j]=tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] data= {10,12,8,20,4,7,1,30};
		bubbleSort(data);
		for(int k:data) {
			System.out.print(k+",");
		}
	}

}
