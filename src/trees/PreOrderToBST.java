/*
 * Construct Binary Search Tree from Preorder Traversal
Solution
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)

 

Example 1:

Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

 

Note: 

1 <= preorder.length <= 100
The values of preorder are distinct.
 * 
 */

package com.rohit.trees;

public class PreOrderToBST {

	public static void main(String[] args) {

		int arr[] = { 8, 5, 13, 4, 6, 11, 15 };

		new PreOrderToBST().bstFromPreorder(arr);

	}

	public TreeNode bstFromPreorder(int[] preorder) {

		TreeNode node = null;
		for (int i = 0; i < preorder.length; i++) {

			node = bstFromPreorderHelper(node, preorder[i]);
		}

		return node;

	}

	TreeNode bstFromPreorderHelper(TreeNode node, int num) {

		if (node == null) {
			TreeNode root = new TreeNode(num);
			return root;
		}

		if (num < node.val) {
			if (node.left == null) {
				TreeNode temp = new TreeNode(num);
				node.left = temp;
			} else
				bstFromPreorderHelper(node.left, num);
		} else {

			if (node.right == null) {
				TreeNode temp = new TreeNode(num);
				node.right = temp;
			} else
				bstFromPreorderHelper(node.right, num);

		}

		return node;
	}

}
