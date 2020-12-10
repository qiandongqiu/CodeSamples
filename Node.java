package test;

public class Node {
	Node left;
	Node right;
	int value;
	
	Node(int value) {
		this.value = value;
		left=right=null;
	}
	
	public String toString() {
		return String.valueOf(value);
	}
	
	public void print() {
		System.out.println(value);
	}
}
