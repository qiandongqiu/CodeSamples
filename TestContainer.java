package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class TestContainer {

	static void TestSet() {
		Set<String> data = new HashSet<>();
		data.add("xx");
		data.add("aa");
		data.add("cc");
		data.add("ff");
		data.add("xx");
		data.add("aa");

		for (String one : data) {
			System.out.println(one);
		}
		System.out.println("--------");
		Iterator<String> ite = data.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
	}
	
	static void TestMap() {
		Map<String, Integer> data = new HashMap<>();
		data.put("aa",10);
		data.put("bb",20);
		data.put("cc",30);
		data.put(null, 40);
		
		System.out.println("----map----");
		Iterator<String> ite  = data.keySet().iterator();
		while(ite.hasNext()) {
			String key = ite.next();
			Integer value = data.get(key);
			System.out.println(key+" === " + value);
		}
	}
	
	
	static void testQueue() {
		Queue<Integer> data = new LinkedList<>();
		data.add(2);
		data.add(4);
		data.add(6);
		
		System.out.println("----queue----");
		while(!data.isEmpty()) {
			Integer v = data.remove();
			System.out.println(v);
		}
		
		
	}
	
	

	public static void main(String[] args) {
		TestSet();
		TestMap();
		testQueue();
	}

}
