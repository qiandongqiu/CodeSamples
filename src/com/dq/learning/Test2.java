package com.dq.learning;

public class Test2 {
	    int max = Integer.MIN_VALUE;
	    public int longestZigZag(TreeNode root) {
	        dfs(root,false);
	        return max;
	    }
	    
	    private int dfs(TreeNode root, boolean isLeft_previous_call){
	        
	        if(root==null)return 0;
	        
	        int left = dfs(root.left,true);
	        int right = dfs(root.right,false);
	        
	        //find maximum length zigzaged path : either from left side or from right side of root node
	        max = left>right? Math.max(max,left):Math.max(max,right);
	        
	        //if previous call was for left child, then return right zigzaged path length and 
	        //if previous call was for right child, then return left zigzaged path length.
	        return isLeft_previous_call?right+1:left+1; //+1 because of including root node
	    }
}
