package com.dq.learning;

//https://leetcode.com/problems/interleaving-string/
/*
 Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.
 */
/*
 * DQs note: 
 */
public class StringInterleave {

	public boolean isInterleave(String s1, String s2, String s3) {
		if(s1.length()+s2.length()!=s3.length())
			return false;
		Boolean[][] cache = new Boolean[s1.length()+1][s3.length()+1];
		return isInterLeaveHelper(s1, s2, s3, 0, 0, cache);
	}
	    
	boolean isInterLeaveHelper(String s1, String s2, String s3, int i, int j, Boolean[][] cache){
		int k = i+j;
		if(cache[i][j]!=null){
			return cache[i][j];
		}

		if(k== s3.length())
			return true;

		if(i<s1.length() && s1.charAt(i) == s3.charAt(k)){
			cache[i][j] = isInterLeaveHelper(s1, s2, s3, i+1, j, cache);
			if(cache[i][j])
				return true;
		}

		if(j<s2.length() && s2.charAt(j) == s3.charAt(k)){
			cache[i][j]  = isInterLeaveHelper(s1, s2, s3, i, j+1, cache);
			return cache[i][j];
		}

		cache[i][j] = false;
		return false;
	}
	
	public static void main(String[] args) {
		 String s1 = "xy", s2 = "abc", s3 = "axbyc";
		 //String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		// String s1 = "", s2 = "", s3 = "";

		// The following over time limit:
		//String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		//String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		//String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		StringInterleave ins = new StringInterleave();
		System.out.println(ins.isInterleave(s1, s2, s3));
	}
}
