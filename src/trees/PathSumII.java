/*
 * Path Sum II
Medium

1496

53

Add to List

Share
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
 * 
 * 
 */

package com.rohit.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSumII {

	List<List<Integer>> resultList = new ArrayList<>();

	public List<List<Integer>> pathSum(TreeNode root, int sum) {

		Deque<Integer> path = new LinkedList<Integer>();
		pathSumHelper(root, sum, path);

		return resultList;
	}

	private void pathSumHelper(TreeNode root, int sum, Deque<Integer> path) {

		if (root == null)
			return;

		sum = sum - root.val;
		path.add(root.val);

		if (sum == 0 && root.left == null && root.right == null) {

			List<Integer> result = new ArrayList<>();
			for (Integer val : path) {
				result.add(val);
			}
			resultList.add(result);
		}

		pathSumHelper(root.left, sum, path);
		pathSumHelper(root.right, sum, path);

		path.removeLast();

	}

}
