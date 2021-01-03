package com.dq.learning;
import java.util.Arrays;

public class ArrayMaximumGap {
	
	    public int maximumGap(int[] nums) {
	    	Arrays.sort(nums);
	        int gap = Integer.MIN_VALUE;    
	    	for(int i=1; i<nums.length; i++) {
	    		int localGap = nums[i]-nums[i-1];
                if(localGap > gap )
                	gap = localGap;
	        	
	        }
	    	
	    	return gap;
	    }
	    
	  
	    
	    public static void main(String[] args) {
	    	int[] nums= {3,6,9,1};
	    	ArrayMaximumGap ins = new ArrayMaximumGap();
	    	System.out.println(ins.maximumGap(nums));
	    }

}
