package com.rohit.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> mQueue = new LinkedList<TreeNode>();
		mQueue.add(root);
		mQueue.add(null);
		List<Integer> tempList = new ArrayList<>();
		while (!mQueue.isEmpty()) {
			TreeNode node = mQueue.poll();
			if (node == null) {
				if (tempList.size() > 0) {
					result.add(tempList);
				}
				tempList = new ArrayList<>();
				if (!mQueue.isEmpty())
					mQueue.add(null);
			} else {
				tempList.add(node.val);
				if (node.left != null) {
					mQueue.add(node.left);
				}
				if (node.right != null) {
					mQueue.add(node.right);
				}
			}

		}
		return result;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
