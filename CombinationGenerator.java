package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

//https://www.geeksforgeeks.org/count-distinct-subsequences/?ref=lbp
public class CombinationGenerator {

	// brutal force way: generate all sub-sequnces of src, and print it out
	private void helper(List<int[]> combinations, int data[], int start, int end, int index) {
		if (index == data.length) {
			int[] combination = data.clone();
			combinations.add(combination);
		} else if (start <= end) {
			data[index] = start;
			helper(combinations, data, start + 1, end, index + 1); //include the item at start, and doing the next one
			helper(combinations, data, start + 1, end, index);  // do not include the item at start, and doing the next one
		}
	}

	public List<int[]> generate(int n, int r) {
		List<int[]> combinations = new ArrayList<>();
		helper(combinations, new int[r], 0, n - 1, 0);
		return combinations;
	}

	public static void main(String[] args) {
		CombinationGenerator ins = new CombinationGenerator();
		int N = 5; //total numbers
		int S = 4; //select how many
		for (int i = 1; i <= N; i++) {
			List<int[]> combinations = ins.generate(N, i);
			for (int[] combination : combinations) {
				System.out.println(Arrays.toString(combination));
			}
		}
	}

}
