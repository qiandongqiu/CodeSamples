package com.dq.learning;
//https://www.geeksforgeeks.org/find-a-rotation-with-maximum-hamming-distance/?ref=lbp
public class ArrayRotationMaxHammerDistance {
	
	public static int maxHammerDist(int[] data) {
		int N = data.length;
		int maxSum=0;
		for(int i=0;i<N; i++) {
		   int sum=0;	
		   //System.out.println("i="+i+";  ");
		   for(int j=0; j<N; j++) {
			   int k=(i+j) % N;         //the index used as the index in rotated array
			   //System.out.print(data[k]+",");
			   if(data[j]!=data[k])
				   sum++;
		   }
		   if(sum>maxSum) maxSum = sum;
		   System.out.println();
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] data= {1,4,1};  //result: 2
		//int[] data= {2,4,8,0}; //result: 4
		System.out.println(maxHammerDist(data));
	}

}
