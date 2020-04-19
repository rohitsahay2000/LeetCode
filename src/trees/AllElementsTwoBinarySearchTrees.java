/*
 * 1305. All Elements in Two Binary Search Trees
Medium

229

10

Add to List

Share
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

 

Example 1:


Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]
Example 2:

Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]
Example 3:

Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]
Example 4:

Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
Example 5:


Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]
 

Constraints:

Each tree has at most 5000 nodes.
Each node's value is between [-10^5, 10^5].
 * 
 */

package com.rohit.trees;

import java.util.ArrayList;
import java.util.List;

public class AllElementsTwoBinarySearchTrees {

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

		List<Integer> result1 = new ArrayList<>();
		List<Integer> result2 = new ArrayList<>();

		traverseTree(root1, result1);
		traverseTree(root2, result2);

		List<Integer> result3 = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < result1.size() && j < result2.size()) {

			if (result1.get(i) < result2.get(j)) {
				result3.add(result1.get(i));
				i++;
			} else {
				result3.add(result2.get(j));
				j++;
			}
		}

		if (i < result1.size()) {
			while (i < result1.size()) {
				result3.add(result1.get(i));
				i++;
			}
		}

		if (j < result2.size()) {
			while (j < result2.size()) {
				result3.add(result2.get(j));
				j++;
			}
		}

		return result3;
	}

	private void traverseTree(TreeNode root, List<Integer> result) {

		if (root == null)
			return;
		traverseTree(root.left, result);
		result.add(root.val);
		traverseTree(root.right, result);
	}

}
