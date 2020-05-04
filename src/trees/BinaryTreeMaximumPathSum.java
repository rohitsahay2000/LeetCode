/*
 * Binary Tree Maximum Path Sum
Solution
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
 * 
 */

package com.rohit.trees;

public class BinaryTreeMaximumPathSum {

	private int maxPathSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {

		maxPathSumHelper(root);
		return maxPathSum;

	}

	private int maxPathSumHelper(TreeNode root) {

		if (root == null)
			return 0;

		int left = Math.max(0, maxPathSumHelper(root.left));
		int right = Math.max(0, maxPathSumHelper(root.right));

		maxPathSum = Math.max(maxPathSum, left + right + root.val);

		return Math.max(left, right) + root.val;
	}

}
