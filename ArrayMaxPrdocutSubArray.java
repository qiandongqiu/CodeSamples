package test;

import java.util.Stack;

//https://www.geeksforgeeks.org/maximize-product-of-subarray-sum-with-its-minimum-element/?ref=lbp0i

/*
 Given an array arr[] consisting of N positive integers, the task is to find the maximum product of subarray sum with the minimum element of that subarray.

Examples:

Input: arr[] = {3, 1, 6, 4, 5, 2}
Output: 60
Explanation:
The required maximum product can be obtained using subarray {6, 4, 5}
Therefore, maximum product = (6 + 4 + 5) * (4) = 60

Input: arr[] = {4, 1, 2, 9, 3}
Output: 81
Explanation:
The required maximum product can be obtained using subarray {9}
Maximum product = (9)* (9) = 81
 */

public class ArrayMaxPrdocutSubArray {
	
	private static int calculate(int[] arr, int start, int end) {
		int min=Integer.MAX_VALUE;
		
		int sum=0;
		for(int i=start; i<end; i++) {
			sum+=arr[i];
			if(arr[i]<min) min=arr[i];
		}
		
		return sum * min;
		
	}
	
	//brute force way: find all the sub array, then calculate the value using the function above
	static int maxProductSubArray(int[] arr) {
		int n=arr.length;
		
		int maxValue=0;
		for(int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if(j>=i) {
					int value = calculate(arr, i, j);
					if(value>maxValue) maxValue=value;
				}
			}
		}
		
		return maxValue;
	}
	
	
	//O(n) way
	
	public static void
    maxValue(int[] a, int n)
    {
 
        // Stores prefix sum
        int[] presum = new int[n];
 
        presum[0] = a[0];
 
        // Find the prefix sum array
        for (int i = 1; i < n; i++) {
 
            presum[i] = presum[i - 1] + a[i];
        }
 
        // l[] and r[] stores index of
        // nearest smaller elements on
        // left and right respectively
        int[] l = new int[n], r = new int[n];
 
        Stack<Integer> st = new Stack<>();
 
        // Find all left index
        for (int i = 1; i < n; i++) {
 
            // Until stack is non-empty
            // & top element is greater
            // than the current element
            while (!st.isEmpty()
                   && a[st.peek()] >= a[i])
                st.pop();
 
            // If stack is empty
            if (!st.isEmpty())
                l[i] = st.peek() + 1;
            else
                l[i] = 0;
 
            // Push the current index i
            st.push(i);
        }
 
        // Reset stack
        st.clear();
 
        // Find all right index
        for (int i = n - 1; i >= 0; i--) {
 
            // Until stack is non-empty
            // & top element is greater
            // than the current element
            while (!st.isEmpty()
                   && a[st.peek()] >= a[i])
                st.pop();
 
            if (!st.isEmpty())
                r[i] = st.peek() - 1;
            else
                r[i] = n - 1;
 
            // Push the current index i
            st.push(i);
        }
        
        for(int left:l) {
        	System.out.print(left+",");
        }
        System.out.println();
        for(int left:r) {
        	System.out.print(left+",");
        }
        System.out.println();
        for(int left:presum) {
        	System.out.print(left+",");
        }
        System.out.println();
 
        // Stores the maximum product
        int maxProduct = 0;
 
        int tempProduct;
 
        // Iterate over the range [0, n)
        for (int i = 0; i < n; i++) {
 
            // Calculate the product
            tempProduct
                = a[i]
                  * (presum[r[i]]
                     - (l[i] == 0 ? 0
                                  : presum[l[i] - 1]));
            
            System.out.println("i="+i+",  product="+tempProduct + "     ;   presumr[i]"+presum[r[i]] + " , presum[li]"+(l[i] == 0 ? 0
                    : presum[l[i] - 1]));
 
            // Update the maximum product
            maxProduct
                = Math.max(maxProduct,
                           tempProduct);
        }
 
        // Return the maximum product
        System.out.println(maxProduct);
    }
	
	
	
	public static void main(String[] args) {
		//int arr[] = {4, 1, 2, 9, 3};
		int arr[] = {3, 1, 6, 4, 5, 2};
		System.out.println(maxProductSubArray(arr));
		
	     maxValue(arr,6);
	}

}
