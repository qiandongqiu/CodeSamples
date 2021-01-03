package com.dq.learning;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSerialization {
	 // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        TreeNode lastNotNullNode=null;
        
        while(!q.isEmpty()) {
            TreeNode current = q.remove();
            if(current!=null) {
              result.add(current.val);
              if(current!=lastNotNullNode) {
              q.add(current.left);
              q.add(current.right);
              lastNotNullNode=current;
              } else {
            	  break;
              }
            } else {
            	result.add(null);
            }
        }
        
        
        
        StringBuilder sb=new StringBuilder();
        for(Integer i : result) {
        	sb.append(i);
        	sb.append(",");
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	TreeSerialization ins=new TreeSerialization();
    	
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.right.left = new TreeNode(4);
    	root.right.right = new TreeNode(5);
    	
    	String s = ins.serialize(root);
    	System.out.println(s);
    	
    }

}
