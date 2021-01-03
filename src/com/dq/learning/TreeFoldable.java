package com.dq.learning;

//algorithm:
//  1) mirrow left
//  2) then check to see whether left and right are in same structure

public class TreeFoldable {
	
	static TreeNode mirror(TreeNode node) {  //mirror node
		if(node==null) return null;
		
		TreeNode left = mirror(node.left);
		TreeNode right = mirror(node.right);
		
		//switch left with right
		TreeNode temp = left;
		node.left = right;
		node.right = temp;
		
		return node;
	}
	
	
	static boolean isSameStructure(TreeNode a, TreeNode b) {
		if(a==null && b==null) return true;
		
		if(a!=null && b!=null) {
			if(isSameStructure(a.left, b.left) && isSameStructure(a.right, b.right))
				return true;
		}
		
		return false;
	}
	
	static boolean isFoldable(TreeNode root) {
		if(root==null) return true;
		
		TreeNode leftMirror = mirror(root.left);
		
		return isSameStructure(leftMirror, root.right);
	}
	
	
	static void inOrder(TreeNode node) {
		if(node==null) return;
		inOrder(node.left);
		System.out.println(node.val+",");
		inOrder(node.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
	    //TreeNode mirror = mirror(root);
	    //inOrder(mirror);
		inOrder(root);
	   
	    System.out.println(isFoldable(root));
	    
		
	}

}
