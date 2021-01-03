package com.dq.learning;

import java.util.Arrays;

//https://leetcode.com/problems/bulb-switcher/
/*
 There are n bulbs that are initially off. You first turn on all the bulbs, then you turn off every second bulb.

On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.


Return the number of bulbs that are on after n rounds.

 */

public class BulbSwitch {
	private void printArray(boolean[] bulbs) {
		for (boolean b : bulbs) {
			System.out.print(b + ",");
		}
		System.out.println();
	}

	public int bulbSwitch(int n) {
		if(n==0) return 0;  //NOTE: this 2 special cases!!
		if(n==1) return 1;
		if(n==2) return 1;
		if(n==3) return 2;
		

		boolean[] bulbs = new boolean[n];
		Arrays.fill(bulbs, true);

		int round = 2; // round 1 is used to set every bulb to true
		for (round = 2; round < n; round++) {
			for (int i = 1; i < n; i++) { // since we do every 2,3,4..., the first one is untouched
				if ((i + 1) >= round && (i + 1) % round == 0) //every other 3: we have to do i+1 here!!!!!
					bulbs[i] = !bulbs[i];
			}
		}
		// printArray(bulbs);

		// last round, only toggle last one
		bulbs[n - 1] = !bulbs[n - 1];
		// now, count how many are on
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (bulbs[i])
				count++;

		}

		return count;
	}
	
	 public int bulbSwitchMathWay(int n) {
	        
	        // brute force
	        int total = 0;
	        for (int i = 1; i < n + 1; i++) {
	            
	            boolean on = false;
	            for (int j = 1; j < n + 1; j++) {
	                if (i % j == 0)
	                    on = !on;
	            }
	            
	            total += on ? 1 : 0;
	        }
	        
	        return total;
	    }

	public static void main(String[] args) {
		BulbSwitch bs = new BulbSwitch();
		System.out.println(bs.bulbSwitch(0));
		System.out.println(bs.bulbSwitch(1));
		System.out.println(bs.bulbSwitch(3));
		//System.out.println(bs.bulbSwitch(99999)); //timeout
		System.out.println(bs.bulbSwitchMathWay(99999)); //timeout
	}
}
