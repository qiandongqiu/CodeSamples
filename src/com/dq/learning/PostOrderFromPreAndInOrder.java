package com.dq.learning;
//https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/?ref=lbp
import java.util.Arrays;

public class PostOrderFromPreAndInOrder {
	
	
	static int preIndex = 0; 
    void printPost(int[] in, int[] pre, int inStrt, int inEnd) 
    { 
        if (inStrt > inEnd)  
            return;         
  
        // Find index of next item in preorder traversal in 
        // inorder. 
        int nextRootIndex = search(in, inStrt, inEnd, pre[preIndex++]); 
  
        // traverse left tree 
        printPost(in, pre, inStrt, nextRootIndex - 1); 
  
        // traverse right tree 
        printPost(in, pre, nextRootIndex + 1, inEnd); 
  
        // print root node at the end of traversal 
        System.out.print(in[nextRootIndex] + " "); 
    } 
  
    int search(int[] in, int startIn, int endIn, int data) 
    { 
        int i = 0; 
        for (i = startIn; i < endIn; i++)  
            if (in[i] == data)  
                return i;             
        return i; 
    } 
  
	
	// Driver code  
    public static void main(String ars[])  
    {  
        int in[] = { 4, 2, 5, 1, 3, 6 };  
        int pre[] = { 1, 2, 4, 5, 3, 6 };  
        PostOrderFromPreAndInOrder tree = new PostOrderFromPreAndInOrder();  
        tree.printPost(in, pre, 0, in.length-1);  
    }  

}
