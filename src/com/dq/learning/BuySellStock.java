package com.dq.learning;
//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3287/
/*
 Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 */

public class BuySellStock {
    /*
       algorithm:
          1) int maxProfit=0
          2) while arr[i-1] <= arr[i] (numbers are going up)
             when found first arr[i-1]>arr[i], maxprofit += arr[i-1] - min 
          3) apply the same logic from arr[i] and up   
          
       
     */
    public static int maxProfit(int[] prices) {
    	int maxProfit=0;
    	int currentMin = prices[0];
    	for(int i=1; i<prices.length; i++) {
    	   if(prices[i]>=prices[i-1]) { 
    		   continue;
    	   }
    	   //now, we have a drop on price
    	   maxProfit += prices[i-1] - currentMin;
    	   currentMin = prices[i];
    	}
    	if(prices[prices.length-1] - currentMin >0)
    	   maxProfit += prices[prices.length -1] - currentMin;


    	
    	return maxProfit;

    }
    
    
    public static void main(String[] args) {
    	int [] prices= {7,1,5,3,6,4};  //7
    	//int [] prices= {1,7,1,7};  //12
    	System.out.println(maxProfit(prices));
    }
    
}
