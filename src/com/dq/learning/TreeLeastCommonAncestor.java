package com.dq.learning;

import java.util.ArrayList;
import java.util.List;

/*
https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/?ref=leftbar-rightbar
Algorithm:
   1) findPath from root to a; and path from root to b
   2) then compare those 2 paths from root on, at the moment the path differ, that is the common ancestor
*/

public class TreeLeastCommonAncestor {
	Node root;
	
	public int findLCA(int a, int b) {
		ArrayList<Integer> pathA = new ArrayList<>();
		ArrayList<Integer> pathB = new ArrayList<>();
		
		getPath(root, a, pathA);
		getPath(root, b, pathB);
		
		int i=0;
		for(i=0; i<pathA.size() && i<pathB.size(); i++) {
			if(pathA.get(i)!=pathB.get(i))
				break;
		}
		
		return pathA.get(i-1);
	}
	
	public boolean getPath(Node node, int a, List<Integer> path) {  //find path , return true, find one; otherwise false
		if(node==null) 
			return false;
		
		path.add(node.value);  //add current node
		if(node.value == a) return true;
		
		//left
		if(node.left!=null) {
			//find it in the left
			if(getPath(node.left, a, path))
				return true;
		}
		
		//right
		if(node.right!=null) {
			if(getPath(node.right, a, path))
				return true;
		}
		
		//get there, not found under this node
		path.remove(path.size()-1); //remove the last one
		
		return false;
		
	}
	
	 // Driver code 
    public static void main(String[] args) 
    { 
    	TreeLeastCommonAncestor tree = new TreeLeastCommonAncestor(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
  
        System.out.println("LCA(4, 5): " + tree.findLCA(4,5)); 
        System.out.println("LCA(4, 6): " + tree.findLCA(4,6)); 
        System.out.println("LCA(3, 4): " + tree.findLCA(3,4)); 
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4)); 
      
    } 

}
