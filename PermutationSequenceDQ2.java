package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//This is my own algorithm:
//  figure out every position one by one: the Nth postion, first count how many (n-1)!  K can contain;

public class PermutationSequenceDQ2 {

	static Map<Integer, Integer> factorialMap = new HashMap<Integer, Integer>();

	static void fillFactorial(int n) {
		int fac = 1;
		for (int i = 1; i <= n; i++) {
			fac *= i;
			factorialMap.put(i, fac);
		}
	}

	static void findOneNumber(int n, int k, List<Integer> nums, List<Integer> result) {
		if (k == 0) {
			for (int i = n - 1; i >= 0; i--) {
				result.add(nums.get(i));
			}
			return;
		}

		int minusOneFac = factorialMap.get(n - 1);
		// position is used
		int index = 0;
		if (k % minusOneFac != 0)
			index = k / minusOneFac; // there are at least index * (n-1)!
		else
			index = k / minusOneFac - 1; // no left over, exact match

		result.add(nums.get(index));
		nums.remove(index);

		k = k % minusOneFac;
		findOneNumber(n - 1, k, nums, result);
	}

	static String listToString(List<Integer> result) {
		StringBuilder sb = new StringBuilder();
		for (Integer i : result) {
			sb.append(i);
		}
		return sb.toString();
	}

	static String findKthPermutation(int n, int k) {
		if(n==1) {
			return "1";
		}

		factorialMap.clear();
		fillFactorial(n);

		List<Integer> nums = new ArrayList<Integer>(); // list to store numbers that can be used: 1,2,3...n
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}

		List<Integer> result = new ArrayList<Integer>(); // list to store numbers that can be used: 1,2,3...n
		findOneNumber(n, k, nums, result);

		// result to string
		return listToString(result);

	}

	// Driver code
	public static void main(String[] args) {
		// int n = 9, k = 13596;
		// int n = 4, k = 9;
		int n = 1, k = 1;
		String kth_perm_seq = findKthPermutation(n, k);
		System.out.print(kth_perm_seq + "\n");
	}

}
