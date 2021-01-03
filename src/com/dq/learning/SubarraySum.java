package com.dq.learning;

public class SubarraySum {
	
	static void subArraySum(int[] data, int expectedSum) {
		int length = data.length;
		
		int start=0, end=0;
		int sum=0;
		for(int i=0; i<length; i++) {
			sum += data[i];
			end=i;
			if(sum<expectedSum) {
			} else if(sum==expectedSum) {
				System.out.println("start="+start+", end="+end);
				return;
			} else {
				//sum is too large, no, move start until sum is less than expectedSum
				while(sum>expectedSum) {
					sum -= data[start];
					start++;
					if(sum==expectedSum) {
				        System.out.println("start="+start+", end="+end);
				        return;
					}
				}
				System.out.println("start value="+data[start]);
			}
		}
		
		System.out.println("not found");
	}
	
	public static void main(String[] args) {
		int[] data= {1,2 ,3,4,5,6,7,8,9};
		subArraySum(data, 18);
	}

}
