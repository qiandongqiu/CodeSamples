package com.dq.learning;

public class TreeLongestZigZagPath {
	/*  
	//this is a working version
	public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        
        return Math.max(root.left != null ? performZigZag(root.left, 1, true) : 0, 
                        root.right != null ? performZigZag(root.right, 1, false) : 0);
        
    }
    
    public int performZigZag(TreeNode node, int count, boolean prevLeft) {           
        if (node.left == null && node.right == null) {
            return count;
        }
        
        return Math.max(count, Math.max(
            node.left != null ? performZigZag(node.left, prevLeft ? 1 : count + 1, true) : 0, 
            node.right != null ? performZigZag(node.right, prevLeft ? count + 1 : 1, false) : 0));
    }
    */
	
	
	public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        return Math.max(root.left != null ? dfs(root.left, 1, true) : 0, 
                        root.right != null ? dfs(root.right, 1, false) : 0);

	}
	
	public int dfs(TreeNode node, int sumSoFar,  boolean previousLeft) {
		if(node.left==null && node.right==null)
			return sumSoFar;
		
		int left=0, right=0;
		if(node.left!=null) {
			if(previousLeft)
				left = dfs(node.left, 1, true);
			else
				left = dfs(node.left, sumSoFar+1, true);
		}
		
		if(node.right!=null) {
			if(previousLeft)
				right = dfs(node.right, sumSoFar+1, false);
			else
				right = dfs(node.right, 1, false);
		}
		
		int localMax = Math.max(left, right);
		return Math.max(localMax, sumSoFar);
	    	
	}
	
	
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	// [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
    	//expects 3  ( from root, get 2; but from the 2rd node, we get 3 here!!! NOTE!!!!
        root.right=new TreeNode(1);
        root.right.left=new TreeNode(1);
        root.right.right=new TreeNode(1);
        root.right.right.left=new TreeNode(1);
        root.right.right.right=new TreeNode(1);
        root.right.right.left.right=new TreeNode(1);
        root.right.right.left.right.right=new TreeNode(1);
        
        TreeLongestZigZagPath ins = new TreeLongestZigZagPath();
        int k=ins.longestZigZag(root);
    	System.out.println("expected 3 here: k="+k);  //expected 3
    	
    	//[1,1,1,null,1,null,null,1,1,null,1]  //expected 4
    	TreeNode root1 = new TreeNode(1);
    	root1.left = new TreeNode(1);
    	root1.right = new TreeNode(1);
    	
    	root1.left.right = new TreeNode(1);
    	root1.left.right.left = new TreeNode(1);
    	root1.left.right.right = new TreeNode(1);
    	
    	root1.left.right.left.right = new TreeNode(1);
    	int k1=ins.longestZigZag(root1);
    	System.out.println("expected 4 here,k1="+k1);
    }

}
