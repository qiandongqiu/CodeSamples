package test;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestOne {
	
	private static void printMap(HashMap<String, Integer> data) {
		System.out.println("==========================");
        Iterator<String> ite = data.keySet().iterator();
        while(ite.hasNext()) {
        	String key = ite.next();
        	System.out.println(key + "===" + data.get(key));
        }
	}
	
	public static void main(String[] args) {
        HashMap<String, Integer> data= new HashMap<String, Integer>();
        data.put("one", 1);
        data.put("two", 2);
        data.put("three", 3);
        
        Set<Map.Entry<String, Integer>> entrySet = data.entrySet();
        for( Map.Entry<String, Integer> entry: entrySet) {
        	 String key = entry.getKey();
        	 Integer value = entry.getValue();
        	 System.out.println(key+":"+value);
        }
		
        
        printMap(data);
        Iterator<String> ite = data.keySet().iterator();
        while(ite.hasNext()) {
        	String key = ite.next();
        	if(data.get(key)==2) {
        		ite.remove();
        	} 
        }
        
        printMap(data);
        
        
        
        IntStream numbers  = IntStream.range(1,11);
        
         //List<Integer> l = numbers.filter( n -> n % 2==0).collect(0, s,n->s+n, s1+s2);
        //List<Integer> l = numbers.collect(toList());
        
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd", "bb");
        /*
        List<String> result = givenList.stream().map(s->s.concat("1")).collect(toList());
        for(String one : result) {
           System.out.println(one);	
        }
        */
        System.out.println("---joining----");
        //String res = givenList.stream().collect(Collectors.joining(", ","[","]"));
        //String res = givenList.stream().collect(Collectors.joining());
        String res = givenList.stream().collect(Collectors.joining(", ","[","]"));
        System.out.println(res);
        
        
        Set<String> sets = givenList.stream().collect(Collectors.toSet());
        Map<String, Integer> result = sets.stream()
        		  .collect(toMap(Function.identity(), String::length));
        for(Map.Entry<String, Integer> entry : result.entrySet()) {
        	System.out.println(entry.getKey()+ "===" + entry.getValue());
        }
        
        
        Map<Integer, List<String>> groupBy = givenList.stream().collect(Collectors.groupingBy(String::length, toList()));
        for(Map.Entry<Integer, List<String>> entry : groupBy.entrySet()) {
        	System.out.println(entry.getKey() + "==>" + entry.getValue());
        }

        
        
        List<Integer> numbers2 = Arrays.asList(42, 4, 2, 24);
        Optional<Integer> min = numbers2.stream().collect(Collectors.minBy(Integer::compareTo));
        Optional<Integer> max = numbers2.stream().collect(Collectors.maxBy(Integer::compareTo));
        
        if(min.isPresent())  System.out.println(min.get());

        
	}

}

