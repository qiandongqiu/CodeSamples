package test;

import java.util.HashSet;
import java.util.Vector;

//https://www.geeksforgeeks.org/find-the-k-th-permutation-sequence-of-first-n-natural-numbers/
//NOTE: the answer (code on geeksforgeeks seem to be wrong too: 3,5 return 331?? double 3s here.
	//https://leetcode.com/problems/permutation-sequence/
/*
 The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 */
public class PermutationSequence {
	 // 1st position: n
	 // 2nd position: n-1
	 // 3rd position: n-2
	 // looks like that it is: n-index
	// Function to find the index of
	// number at first position of
	// kth sequence of set of size n
	static int findFirstNumIndex(int k, int n)
	{
	  if (n == 1)
	    return 0;
	  n--;
	 
	  int first_num_index;
	   
	  // n_actual_fact = n!
	  int n_partial_fact = n;
	 
	  while (k >= n_partial_fact && n > 1) 
	  {
	    n_partial_fact = n_partial_fact * 
	                     (n - 1);
	    n--;
	  }
	 
	  // First position of the
	  // kth sequence will be
	  // occupied by the number present
	  // at index = k / (n-1)!
	  first_num_index = k / n_partial_fact;
	 
	  k = k % n_partial_fact;
	  return first_num_index;
	}
	 
	// Function to find the
	// kth permutation of n numbers
	static String findKthPermutation(int n, 
	                                 int k)
	{
	  // Store final answer
	  String ans = "";
	 
	  HashSet<Integer> s = new HashSet<>();
	 
	  // Insert all natural number
	  // upto n in set
	  for (int i = 1; i <= n; i++)
	    s.add(i);
	 
	  Vector<Integer> v = new Vector<>();
	  v.addAll(s);
	 
	  // Mark the first position
	  int itr = v.elementAt(0);
	   
	  // Subtract 1 to 
	  // get 0 based 
	  // indexing
	  k = k - 1;
	 
	  for (int i = 0; i < n; i++) 
	  {
	    int index = findFirstNumIndex(k, 
	                                  n - i);
	     
	    // itr now points to the
	    // number at index in set s
	    if(index < v.size()) 
	    {
	      ans += ((v.elementAt(index).toString()));
	      v.remove(index);
	    }
	    else
	      ans += String.valueOf(itr + 2);
	 
	    // Remove current number 
	    // from the set
	    itr = v.elementAt(0);
	  }
	  return ans;
	}
	 
	// Driver code
	public static void main(String[] args)
	{
	  //int n = 8, k = 10; //WRONG ANSWER HERE
		int n=3, k=5;
	  String kth_perm_seq = findKthPermutation(n, k);
	  System.out.print(kth_perm_seq + "\n");
	}

}
