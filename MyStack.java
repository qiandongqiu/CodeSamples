package test;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {
	
	List<T> values = null;
	
	public MyStack() {
		values = new ArrayList<T>();
	}
	
	public void push(T value) {
		values.add(value);
	}
	
	public T pop() {
		return values.remove(values.size()-1);
	}
	
	public boolean empty() {
		return values.isEmpty(); 
	}
	
	
	public static void main(String[] args) {
		MyStack<Integer> stack = new MyStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		
	}

}
