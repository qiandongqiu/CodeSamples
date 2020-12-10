package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/count-distinct-subsequences/?ref=lbp
//Problem: given a string, "abc", count distinct sub-sequence it has: "a","b","c", "ab","ac","bc","abc";
//         if it is all distinct characters, it is fine, it is 2^n;  but when there are duplicates, then it is a problem: "aba", there are 2 'a's here.

//Algorithm:
//   we get first character, get the subsequnce count: for "abc", get first 'a', the count will be '','a', which is 2;
//   now, we get the next character 'b', there are 2 options here: adding b or not adding b, so the total will previousCount * 2;
//        but here, there is a catch, if the current character is seen before, we need to remove the previous Seen count before the previous same char. ( since previous*2, already includes the count for the same character once)
//        See line 38 below: NOTE: put DP[i-1] there; the reason is: for 'aba', when we get to 2nd 'a', we want to remove the count before we see first 'a': which is DP[0] for empty string;(not DP[1] for 'a' itself!!

public class ArrayCountSubSequnce {
	
	static Map<Character, Integer> seen = new HashMap<>();
	
	int countDistinct(char[] data) {
		int N = data.length;
		
		int[] DP = new int[N+1];
		
		DP[0]=1;  //empty string has one subSequcne: empty itself
		
		for(int i=1;i<=N; i++) {
			DP[i] = 2 * DP[i-1];  // adding one character at the end or not: adding it makes 1
			
			char currentCh = data[i-1];
			
			//now, if the ch is seen before, we have to remove the duplicate one; need a way to find out 
			if(seen.get(currentCh)!=null) {
				DP[i] -= seen.get(currentCh);
			}
			
			seen.put(currentCh, DP[i-1]);   //NOTE: put DP[i-1] there; the reason is: for 'aba', when we get to 2nd 'a', we want to remove the count before we see first 'a': which is DP[0] for empty string;(not DP[1] for 'a' itself!!
		}
		
		return DP[N];
	}

	
	
    
    private static void printArray(int[] data) {
    	for(int i : data) {
    		System.out.print(i+",");
    	}
    	System.out.println();
    }
    
    
    public static void main(String[] args) {
		ArrayCountSubSequnce ins= new ArrayCountSubSequnce();
		String data="aba"; //6
		//String data="gfg"; //7
		int count = ins.countDistinct(data.toCharArray());
		System.out.println(count);
		
		
	}

}
