/*
 * Binary Tree Zigzag Level Order Traversal
Medium

1624

85

Add to List

Share
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 * 
 */

package com.rohit.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOrderTraversal {

	public static void main(String[] args) {

		TreeNode node = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(6);
		TreeNode node6 = new TreeNode(7);

		node.left = node1;
		node.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;

		new ZigZagOrderTraversal().zigzagLevelOrder(node);

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		// return list of list
		List<List<Integer>> res = new ArrayList<>();

		if (root == null)
			return res;

		// declare queue
		Queue<TreeNode> queue = new LinkedList<>();

		// add root to queue
		queue.offer(root);

		// declare zig zag var
		boolean zigzag = false;
		// while q is not empty
		while (!queue.isEmpty()) {
			// declare level list and size from q
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			int i = 0;
			while (i < size) {
				// poll from q
				TreeNode node = queue.poll();
				if (zigzag) {
					level.add(0, node.val);

				} else {
					level.add(node.val);
				}

				// check if left not null add to queue
				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
				i++;
			}
			res.add(level);
			zigzag = !zigzag;
		}
		return res;

	}

}
