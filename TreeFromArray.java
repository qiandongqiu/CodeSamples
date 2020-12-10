package test;

import java.util.Vector;

//https://www.geeksforgeeks.org/find-all-possible-trees-with-given-inorder-traversal/?ref=lbp
//Array: [4,5,7]
//output: all possible binary tree
public class TreeFromArray {
	
	
	
	
	//algorithm: 
	//  find a number on index i in the array, use it as the root node
	//     using [0, i-1] to construct all the left trees
	//     using [i+1, end] to construct all the right trees
	//     combine all the trees together

	
	//function: create a new tree with root as Root using items from l to r only.
	static Vector<Node> treeFromArray(int[] arr, int l, int r) {  //root >=l and root<=r
		
		Vector<Node> trees = new Vector<>();
		
		if(l>r) {
			trees.add(null);
			return trees;
		}
		
		//for every item in the array, use it as the root
		for(int i=l; i<=r; i++) {
			Vector<Node> leftTrees = treeFromArray(arr,l,i-1);
			Vector<Node> rightTrees = treeFromArray(arr,i+1,r);
			
			//now, combine every left tree with every right tree, using node i as root
			for( int m=0; m<leftTrees.size(); m++) 
				for( int n=0; n<rightTrees.size(); n++) {
					Node tree = new Node(arr[i]);
					tree.left = leftTrees.get(m);
					tree.right = rightTrees.get(n);
					trees.add(tree);
				}
			
		}
		
		
		
		return trees;
		
	}
	
	
	static void preOrder(Node root) {
		if(root==null) return;
		System.out.print(root.value);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main(String[] args) {
		int arr[]= {4,5,7};
		Vector<Node> trees = treeFromArray(arr, 0, 2);
		for(Node tree:trees) {
			preOrder(tree);
			System.out.println();
		}
	}

}
