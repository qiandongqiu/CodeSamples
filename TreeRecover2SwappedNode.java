package test;

import java.util.ArrayList;
import java.util.List;

public class TreeRecover2SwappedNode {
	
	
	public static void recoverTree(TreeNode root) {
		ArrayList<Integer> data = new ArrayList<>();
		inOrder(root, data);

		for(int i:data) {
			System.out.print(i+",");
		}
		System.out.println();
				
    	int p1=-1, p2=-1;
		
    	//e.g.:  1, 3, 2,4, 
		for(int i=0; i<data.size()-1; i++) {
			if(data.get(i)>data.get(i+1)) {
                if(p1 == -1) {
				    p1=data.get(i);
				    p2=data.get(i+1);  //could be those 2 are next to each other
                }
                else {
                	//if we every find another one, that is for p2
                	p2=data.get(i+1);
                	break;
                }
			}
		} //for
		
		inOrderChange(root, p1, p2);
	}
	
	static void inOrderChange(TreeNode node, int v1, int v2) {
		if(node==null) return;
		inOrderChange(node.left,v1,v2);
		if(node.val==v1) {
			node.val=v2;
		} else {
		   if(node.val==v2) node.val=v1;
		}
		inOrderChange(node.right,v1,v2);
	}

	
	
	static void inOrder(TreeNode node) {
		if(node==null) return;
		inOrder(node.left);
		System.out.println(node.val);
		inOrder(node.right);
	}
	
	static void inOrder(TreeNode node, List<Integer> data) {
		if(node==null) return;
		inOrder(node.left, data);
		//System.out.println(node.val);
		data.add(node.val);
		inOrder(node.right,data);
	}
	
	
	public static void main(String[] args) {
		/*
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		*/
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(2);
		
		//inOrder(root);
		
		ArrayList<Integer> data = new ArrayList<>();
		inOrder(root, data);
		
		recoverTree(root);
		System.out.println("=====");
		inOrder(root);
				
	}

}
