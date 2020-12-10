package test;

/* BST from PreOrder array */
//DQ: trick is: since BST preorder is sorted, every item on the left < root; every item on the right > root.

/* The trick is to set a range {min .. max} for every node. Initialize the range as {INT_MIN .. INT_MAX}. 
 * The first node will definitely be in range, so create root node. To construct the left subtree, set the range as {INT_MIN …root->data}. 
 * If a values is in the range {INT_MIN .. root->data}, the values is part part of left subtree. To construct the right subtree, 
 * set the range as {root->data..max .. INT_MAX}. 
 */

public class TreeFromPreOrder {
	static int start=0;
	//public static TreeNode bstFromPreorderUtil(int[] preorder, Integer start, int min, int max) { //Integer is immutable, cannot do this
	public static TreeNode bstFromPreorderUtil(int[] preorder, int min, int max) {
		if (start >= preorder.length)
			return null;

		TreeNode node = null;
		if (preorder[start] > min && preorder[start] < max) {
			int currentRootValue = preorder[start];
			node = new TreeNode(currentRootValue);
			start++;
			if (start < preorder.length) {
				node.left = bstFromPreorderUtil(preorder,  min, currentRootValue);
				node.right = bstFromPreorderUtil(preorder, currentRootValue, max);
				//node.left = bstFromPreorderUtil(preorder, start, min, currentRootValue);
				//node.right = bstFromPreorderUtil(preorder, start, currentRootValue, max);
			}
		}

		return node;
	}

	public static TreeNode bstFromPreorder(int[] preorder) {
		TreeNode root = bstFromPreorderUtil(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
		//Integer index=0;
		//TreeNode root = bstFromPreorderUtil(preorder, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return root;
	}

	public static void print(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.val + ", ");
		print(node.left);
		print(node.right);
	}

	public static void main(String[] args) {
		int[] nums = { 8, 5, 1, 7, 10, 12 };
		TreeNode root = bstFromPreorder(nums);

		print(root);

	}

}
