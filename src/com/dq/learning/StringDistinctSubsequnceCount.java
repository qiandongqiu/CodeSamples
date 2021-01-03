package com.dq.learning;
//https://leetcode.com/problems/distinct-subsequences/
//Algorithm:
//    the sub-problem: find first matched char, then run it recursively for left overs in both strings.
//    using DP 

/*
 Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It's guaranteed the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
 */
import java.util.Arrays;

public class StringDistinctSubsequnceCount {

	private int numDistinct(char[] sa, char[] ta, int sstart, int tstart, int[][] DP) {
		
		if(DP[sstart][tstart]!=-1) return DP[sstart][tstart];
		
		if (ta.length == tstart) {
  		    System.out.println(sstart+","+tstart+" = 1");
			return 1; // at the end of the matching string, all characters found!
		}

		int result = 0;
		char matchChar = ta[tstart];
		for (int i = sstart; i < sa.length; i++) {
			if (sa[i] == matchChar) {
				result += numDistinct(sa, ta, i + 1, tstart + 1, DP);
			}
		}
		DP[sstart][tstart]=result;

		System.out.println(sstart+","+tstart+" = " +result);
		
		return result;
	}

	public int numDistinct(String s, String t) {
		char[] sa = s.toCharArray();
		char[] ta = t.toCharArray();

		int[][] DP = new int[sa.length + 1][ta.length + 1];
		for (int i = 0; i <= sa.length; i++)
			Arrays.fill(DP[i], -1);

		return numDistinct(sa, ta, 0, 0, DP);
	}
	
	//top to bottom approach
	public int numDistinct_FROM_WEB(String s, String t) {
        int[][]dp = new int[t.length()+1][s.length()+1];
        for(int i=0;i<s.length();i++){
            dp[0][i] = 1;
        }
        for(int i=0;i<t.length();i++){
            for(int j=0;j<s.length();j++){
                dp[i+1][j+1] = dp[i+1][j];
                if(t.charAt(i) == s.charAt(j)){
                    dp[i+1][j+1] += dp[i][j];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

	public static void main(String[] args) {
		// String s = "rabbbit", t = "rabbit"; //3
		 String s = "acac", t = "ac";
		 //String s="babgbag", t="bag";

		// this one over time limit without memorization
//String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
//		String t = "bcddceeeebecbc";
		StringDistinctSubsequnceCount ins = new StringDistinctSubsequnceCount();
		System.out.println(ins.numDistinct(s, t));
	}
}
