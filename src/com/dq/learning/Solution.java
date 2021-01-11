package com.dq.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {

	public static int[] intersection(int[] nums1, int[] nums2) {
		int N1 = nums1.length;
		int N2 = nums2.length;

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		Set<Integer> result = new HashSet<>();

		int i = 0;
		int j = 0;
		while (i < N1 && j < N2) {
			if (nums1[i] == nums2[j]) {
				result.add(nums1[i]);
				i++;
				j++;
			} else {
				if (nums1[i] < nums2[j])
					i++;
				else
					j++;
			}
		}

		// turn result into array and return
		int[] b = new int[result.size()];
		int count = 0;
		for (int k : result) {
			b[count++] = k;
		}
		return b;

	}

	public static void kthLargetNumber(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
			return b - a;
		});
		for (int i = 0; i < nums.length; i++) { // total time: N*log(N)
			pq.add(nums[i]); // log(N) for add
		}

		while (!pq.isEmpty() && k > 0) {
			System.out.print(pq.remove() + ",");
			k--;
		}

	}

	static void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

	// try quick sort partition
	static int partition(int[] nums, int l, int r) {
		int x = nums[r]; // pivot
		int i = l;
		for (int j = l; j < r; j++) {
			if (nums[j] < x) {
				swap(nums, j, i);
				i++;
			}
		}
		swap(nums, i, r);
		return i;
	}

	static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + ",");

		System.out.println();
	}

	class Point implements Comparable<Point> {
		int i;
		int j;
		int value;

		Point(int i, int j, int value) {
			this.i = i;
			this.j = j;
			this.value = value;
		}

		public int compareTo(Point b) {
			return this.value - b.value;
		}
	}

	public static int maxRotateFunction(int[] A) {
		int N = A.length;
		long max = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) { // rotate i times
			int localMax = 0;
			for (int j = 0; j < N; j++) {
				// new index for item j rotated i times
				int index = (i + j + N) % N;
				localMax += j * A[index];
			}
			if (localMax > max)
				max = localMax;
		}
		return (int) max;

	}

	public static int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 1;

		Queue<String> q = new LinkedList<>();
		for (int i = 1; i <= 9; i++)
			q.add("" + i);

		int count = 1;
		while (!q.isEmpty()) {
			String cur = q.remove();
			System.out.print(cur + ",");
			count++;

			if (cur.length() >= n)
				continue;

			boolean isDigitGood;
			for (int j = 0; j < 10; j++) {
				isDigitGood = true;
				// make sure j is not in the cur already
				for (int x = 0; x < cur.length(); x++) {
					if (cur.charAt(x) - '0' == j) {
						isDigitGood = false;
						break;
					}
				}
				if (isDigitGood) {
					q.add(cur + j);
				}
			}
		} // while
		return count;
	}

	static class Pair<T extends Number, V> implements Comparable<Pair<T,V>> {
		T key;
		V value;

		Pair(T k, V v) {
			this.key = k;
			this.value = v;
		}

		public T getKey() {
			return this.key;
		}

		public V getValue() {
			return value;
		}
		
		public int compareTo(Pair<T,V> other) {
			int a = (int)this.key;
			int b = (int)other.getKey();
			return a-b;
		}
	}

	public static void testTreeSet() {
		TreeSet<Pair<Integer,Integer>> set = new TreeSet<>();
		set.add(new Pair<Integer,Integer>(2,20));
		set.add(new Pair<Integer,Integer>(4,40));
		set.add(new Pair<Integer,Integer>(6,60));
		set.add(new Pair<Integer,Integer>(8,80));

		SortedSet<Pair<Integer,Integer>> subSet = set.subSet(new Pair<Integer,Integer>(2,10), new Pair<Integer,Integer>(6,50));

		Iterator<Pair<Integer,Integer>> ite = subSet.iterator();
		while(ite.hasNext()) {
			Pair<Integer,Integer> one = ite.next();
			System.out.print(one.getKey()+",");
		}
		System.out.println();
		
		Pair<Integer,Integer> higher = set.higher(new Pair<Integer,Integer>(2,20));
		System.out.println("higher="+higher.getKey());
		Pair<Integer,Integer> floor = set.floor(new Pair<Integer,Integer>(2,20));
		System.out.println("floor="+floor.getKey());

	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };
		// int [] nums1 = {1,2,2,1}, nums2 = {2,2};

		int[] result = intersection(nums1, nums2);

		for (int k : result)
			System.out.print(k + ",");

		System.out.println("------------------");

		int[] kthNums = { 1, 90, 8, 80, 23, 15, 9 };
		kthLargetNumber(kthNums, 4);
		System.out.println("------------------");

		int k = partition(kthNums, 0, kthNums.length - 1);
		printArray(kthNums);
		System.out.println("pivot i=" + k);

		List<Integer> list = new LinkedList<>();
		list.add(2);
		list.add(20);
		System.out.println(list.get(1));

		// test TreeMap
		TreeMap<Integer, Character> map = new TreeMap<>();
		map.put(1, 'a');
		map.put(2, 'b');
		map.put(3, 'c');
		map.put(4, 'd');

		// Map.Entry<Integer, Character> one = map.ceilingEntry(3);
		// System.out.println(one.getKey()+" ----> " + one.getValue());
		SortedMap<Integer, Character> head = map.headMap(3);
		Set<Integer> keys = head.keySet();
		for (Integer key : keys) {
			System.out.println(k + "==>" + head.get(key));
		}

		SortedMap<Integer, Character> subMap = map.subMap(3, 4);
		Set<Integer> subKeys = subMap.keySet();
		for (Integer key2 : subKeys)
			System.out.println(key2 + "===" + subMap.get(key2));

		int[] data = { 4, 3, 2, 6 };
		int max = maxRotateFunction(data);
		System.out.println("max=" + max);

		// test
		int t = Integer.MIN_VALUE;
		System.out.println(t);
		t = t - 1;
		System.out.println(t);

		byte b = Byte.MIN_VALUE;
		System.out.println(b);
		for (int a = 7; a >= 0; a--) {
			int v = 1 << a;
			if ((b & v) > 0)
				System.out.print('1');
			else
				System.out.print('0');
		}
		System.out.println();

		int xy = countNumbersWithUniqueDigits(2);
		System.out.println();
		System.out.println("xy=" + xy);
		
		System.out.println("--- test tree set----");
		testTreeSet();

	}
}
