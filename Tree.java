package test;
import java.util.LinkedList;
import java.util.Queue;

import test.Node; 

public class Tree {
   Node root;
	
	private Node insert(Node node, int value) {
		if(node == null) {
			return new Node(value);
		}
		
		if(node.value > value) {  //insert to left side
			node.left = insert (node.left, value);
		} if (node.value< value) {
			node.right = insert (node.right, value);
		} else { //equal 
			return node;
		}
		
		return node;
	}
	
	public void add(int value) {
		root = insert(root, value);
	}
	
	
	public void print() {
		print(root);
	}
	
	private void print(Node node) {
		if(node==null) return;
		print(node.left);
		
		node.print();
		
		print(node.right);
	}
	
	public void BFS() {
		BFS(root);
	}
	
	private void BFS(Node node) {
		Queue<Node> nodes = new LinkedList();
		nodes.add(root);
		
		while(!nodes.isEmpty()) {
			Node current = nodes.remove();
			current.print();
			
			if(current.left!=null) nodes.add(current.left);
			if(current.right!=null) nodes.add(current.right);
			
		}
		
	}
	
	public int height() {
		return height(root);
	}
	private int height(Node node) {
		if(node==null) return 0;
		
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		
		return 1+ Math.max(rightHeight, leftHeight);
	}
	
	
	
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.add(25);
		tree.add(15);
		tree.add(30);
		tree.add(28);
		tree.add(16);
		tree.add(17);
		tree.add(14);
		
		tree.print();
		System.out.println();
		
		tree.BFS();
		
		System.out.println(" Tree height is:" + tree.height());
	}
	
}
