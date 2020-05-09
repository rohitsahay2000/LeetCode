package com.rohit.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class CousinsBinaryTree {

	public boolean isCousins(TreeNode root, int x, int y) {

		Queue<TreeNode> mQueue = new LinkedList<>();
		mQueue.offer(root);

		while (!mQueue.isEmpty()) {

			int i = 0;
			int size = mQueue.size();
			boolean isFirst = false;
			boolean isSecond = false;

			while (i < size) {
				TreeNode node = mQueue.poll();

				if (node.left != null && node.right != null
						&& ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)))
					return false;

				if (node.val == x) {
					isFirst = true;
				}

				if (node.val == y) {
					isSecond = true;
				}

				if (isFirst && isSecond) {
					return true;
				}

				if (node.left != null) {
					mQueue.offer(node.left);
				}
				if (node.right != null) {
					mQueue.offer(node.right);
				}
				i++;
			}
		}
		return false;
	}

}
