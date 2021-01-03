package com.dq.learning;

import java.util.Stack;

public class TreeInOrderWithoutRecursion {

	// when use preOrder
	// recursive to left: pushed left to stack
	// print
	// then recursive to right

	public static void preOrderNoRecursion(TreeNode node) {
		Stack<TreeNode> s = new Stack<>();

		TreeNode current = node;

		while (current != null || !s.isEmpty() ) {

			while (current!=null) {
				s.push(current);
				current = current.left;
			}

			// all left children are in stack
			// now, pop up one and print
			current = s.pop();
			System.out.print(current.val + ",");

			current = current.right;
		}

	}
	
	
	 

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(5);
		
	    preOrderNoRecursion(root);
		
	}

}
