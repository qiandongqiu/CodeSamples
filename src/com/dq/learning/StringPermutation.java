package com.dq.learning;

public class StringPermutation {
	
	void swap(char[] str, int a, int b) {
		char tmp = str[b];
		str[b]=str[a];
		str[a]=tmp;
	}
	
	void permutation(char[] str, int l, int r) {
		if(l==r) {
			System.out.println(str);
		} else {
			for(int i=l; i<=r; i++) {
				swap(str, l, i);
				permutation(str, l+1, r);
				swap(str, l, i);
			}
		}
	}
	
	public static void main(String[] args) {
		StringPermutation sp = new StringPermutation();
		sp.permutation("dabc".toCharArray(), 0, 3);
	}

}
