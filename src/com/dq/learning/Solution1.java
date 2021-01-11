package com.dq.learning;

import java.util.Arrays;

public class Solution1 {
	public static void combination(char[] arr, int start, int end, char[] result, int resultIndex, int combCount) { // end:
																													// lastIndex
		int N = arr.length;

		if (resultIndex == combCount) { // we have enough in result to be one of the combinations
			for (int k = 0; k < resultIndex; k++) {
				System.out.print(result[k]);
			}
			System.out.println();
			return;
		}

		for (int i = start; i <= end; i++) {
			result[resultIndex] = arr[i];
			combination(arr, i + 1, end, result, resultIndex + 1, combCount);
		}

	}

	private static void swap(char[] arr, int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	private static void printArray(char[] arr) {
		for (char ch : arr) {
			System.out.print(ch);
		}
		System.out.println();
	}

	public static void permutation(char[] arr, int start, int end) {
		if (start == end) {
			printArray(arr);
		}

		for (int i = start; i <= end; i++) {
			swap(arr, start, i);
			permutation(arr, start + 1, end);
			swap(arr, start, i);
		}
	}

	// find whether there is a repeated substring immediately following the previous
	// string: e.g. abcdbcd, 2nd bcd follows 1st bcd, it is true.
	public static boolean containRepeated(char[] str) {
		int N = str.length;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (str[i] == str[j]) { // 'abcdbcd', i is at first b, j is at 2nd b
					// now, if from i->j, every character is the same as the char after j, it has
					// repeated seq
					int substrLen = j - i;
					System.out.println(" substrLen=" + substrLen);
					boolean allSame = true;
					for (int k = 1; k < substrLen; k++) {
						if (j + k >= N) {
							allSame = false;
							break;
						}
						if (str[i + k] != str[j + k]) {
							allSame = false;
							break;
						}
					}
					if (allSame) // found one
						return true;
				}

			}
		}
		return false;
	}

	public static boolean checkpassword_type3(String password) {
		char[] cc = password.toCharArray();
		int m = cc.length;
		int n = m / 2;
	
		for (int i = 1; i <= n; i++) { //for all possible repeated sequence length
			for (int j = 0; j < m + 1 - 2 * i; j++) {
				String str1 = password.substring(j, j + i);
				String str2 = password.substring(j + i, j + 2 * i);
				System.out.println("i="+i+";j="+j+",   " +str1 + "===" + str2);
				if (str1.equals(str2)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int combCount = 4; // could be 1,2,,3,4...
		char[] result = new char[combCount];
		String str = "abcd";
		int N = str.length();
		//combination(str.toCharArray(), 0, N - 1, result, 0, combCount);

		System.out.println("---------");
		//permutation(str.toCharArray(), 0, N - 1);

		System.out.println("---- test str repeated----");
		str = "abcdbcd";
		//System.out.println(str + " contains repeated " + containRepeated(str.toCharArray()));
		//System.out.println(str + " contains repeated " + checkpassword_type3(str));
		//str = "abcdabcdx";
		//System.out.println(str + " contains repeated " + containRepeated(str.toCharArray()));
		//System.out.println(str + " contains repeated " + checkpassword_type3(str));
		//str = "abcdxabxabc";
		
		str="xabcdabcdex";
		//System.out.println(str + " contains repeated " + containRepeated(str.toCharArray()));
		System.out.println(str + " contains repeated " + checkpassword_type3(str));
	}

}
