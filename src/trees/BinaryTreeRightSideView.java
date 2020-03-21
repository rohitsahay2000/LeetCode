/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
 * 
 */


package com.rohit.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(Node root) {

		List<Integer> resultList = new ArrayList<Integer>();

		Queue<Node> mQueue = new LinkedList<Node>();

		mQueue.add(root);

		while (!mQueue.isEmpty()) {

			int i = 0;
			int size = mQueue.size();

			while (i < size) {
				Node node = mQueue.poll();
				if (i == 0) {
					resultList.add(node.val);
				}
				if (node.right != null) {
					mQueue.add(node.right);
				}
				if (node.left != null) {
					mQueue.add(node.left);
				}
				i++;
			}

		}

		return resultList;

	}

}

class Node {
	int val;
	Node left;
	Node right;

	Node(int x) {
		val = x;
	}
}
