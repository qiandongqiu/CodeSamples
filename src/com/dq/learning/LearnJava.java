package com.dq.learning;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LearnJava {
	enum COLOR {
		RED, GREEN, BLUE
	};

	public static void swap(String[] words, int a, int b) {
		System.out.println("     Swap:" + words[a] + " with " + words[b]);
		//System.out.println();
		String tmp = words[b];
		words[b] = words[a];
		words[a] = tmp;
		//printWords(words);

	}

	public static void printWords(String[] words) {
		for (String one : words) {
			System.out.print(one + ", ");
		}
		System.out.println();
	}

	public static void sentencePermutation(String[] words, int l, int r) {
		//System.out.println( "- l="+l +", r="+r);
		if (l == r) {
			printWords(words);
		} 

			for (int i = l; i <=r; i++) {
				swap(words, l, i);
				sentencePermutation(words, l + 1, r);
				swap(words, l, i);
			}

	}

	public static void main(String[] args) {
		String a = "1243";
		int x = 0;
		int len = a.length();
		int result = 0;
		while (x < len) {
			int calculate = a.charAt(x) - '0';
			result = result + calculate;
			x++;
		}
		System.out.println(result);

		;
		System.out.println(COLOR.RED);

		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<Integer> evens = values.stream().filter(v -> v % 2 == 0).collect(Collectors.toList());
		for (int one : evens) {
			System.out.println(one);
		}
		evens.forEach(System.out::println);

		List<Integer> doubled = values.stream().map(v -> v * 2).collect(Collectors.toList());
		doubled.forEach(System.out::println);

		String[] words = new String[] { "I", "work", "hard"};

		sentencePermutation(words, 0, words.length - 1);

	}

}
