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

		while (!mQueue.isEmpty()) {

			int i = 0;
			int size = mQueue.size();
			List<Integer> tempList = new ArrayList<>();
			for (TreeNode tempNode : mQueue) {
				tempList.add(tempNode.val);
			}
			result.add(tempList);
			while (i < size) {

				TreeNode node = mQueue.poll();
				if (node.left != null) {
					mQueue.add(node.left);
				}
				if (node.right != null) {
					mQueue.add(node.right);
				}
				i++;
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
