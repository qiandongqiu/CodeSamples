package test;

//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3314/
//https://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/
/*
1. Node only
2. Max path through Left Child + Node
3. Max path through Right Child + Node
4. Max path through Left Child + Node + Max path through Right Child
*/
public class TreePathMaxSum {
	static int result=Integer.MIN_VALUE;
	
	public static int maxPathSum(Node root) {
		 maxPathSumUtil(root);
		 return result;
	}
	public static int maxPathSumUtil(Node root) {
		// either the left, the right, or the parent itself
        //or path left+parent+right
        if(root==null) return 0;
        
        int l = maxPathSumUtil(root.left);
        int r = maxPathSumUtil(root.right);
        //System.out.println("root="+root.value+"; l="+l+"; r="+r);
        
        int max1 = Math.max( Math.max(l,r)+root.value, root.value); //max of: left/right+root or root itself
        int max2 = Math.max( l+r+root.value, max1); //left+right+root (go through root node) vs max1;  so max1 is the max value at this root
        
        result = Math.max(result, max2);
        
        //System.out.println("root="+root.value+"; l="+l+"; r="+r +" max1="+max1+", max2="+max2+"; result="+result);
        
        return max1;    // 
                        //<----- THIS is the KEY!!! when it returns, which means ROOT node is counted in there!!!!
                       // either root+left, root+right, or root itself
                       //there is no way to go through left+root+right

	}
	
	public static Node makeTree1() {
		// [-10,9,20,null,null,15,7]  //expect 42
				Node root = new Node(-10);
				root.left = new Node(9);
				root.right = new Node(20);
				root.right.left = new Node(15);
				root.right.right = new Node(7);
				return root;
	}
	
	public static Node makeTree2() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		return root;
	}

	public static Node makeTree3() {
		Node root = new Node(-3);
		return root;
	}
	
	public static Node makeTree4() {
		// [-10,9,20,null,null,15,7]  //expect 48
				Node root = new Node(5);
				root.left = new Node(4);
				root.right = new Node(8);
				root.right.left = new Node(11);
				    root.right.left.left = new Node(7);
				    root.right.left.right = new Node(2);

				root.left.left = new Node(13);
				root.left.right = new Node(4);
				root.left.right.right = new Node(1);
				return root;
	}
	
	
	public static void main(String[] args) {
		Node root = makeTree1();
		int sum =maxPathSum(root);
		System.out.println(sum==42);
		
		result = Integer.MIN_VALUE;
		root=makeTree2();
		sum =maxPathSum(root);
		System.out.println(sum==6);

		result = Integer.MIN_VALUE;
		root=makeTree3();
		sum =maxPathSum(root);
		System.out.println(sum==-3);

		result = Integer.MIN_VALUE;
		root=makeTree4();
		sum =maxPathSum(root);
		System.out.println(sum==48);
		
		
	}
}
