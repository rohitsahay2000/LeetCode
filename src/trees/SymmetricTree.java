package com.rohit.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SymmetricTree {

	TreeNode levelChangeNode = new TreeNode(Integer.MAX_VALUE);

	public boolean isSymmetric(TreeNode root) {

		List<List<Integer>> nodeListbyLevel = getNodesByLevel(root);

		for (List<Integer> nodeList : nodeListbyLevel) {
			if (checkIfSymmetricLevel(nodeList) == false)
				return false;
		}

		return false;
	}

	private List<List<Integer>> getNodesByLevel(TreeNode root) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> mQueue = new LinkedList<TreeNode>();
		mQueue.add(root);
		mQueue.add(levelChangeNode);
		List<Integer> tempList = new ArrayList<>();
		while (!mQueue.isEmpty()) {
			TreeNode node = mQueue.poll();
			if (node == levelChangeNode) {
				if (tempList.size() > 0) {
					result.add(tempList);
				}
				tempList = new ArrayList<>();
				if (!mQueue.isEmpty())
					mQueue.add(levelChangeNode);
			} else {

				if (node == null) {
					tempList.add(null);
				}

				else if (node != null) {
					tempList.add(node.val);
					mQueue.add(node.left);
					mQueue.add(node.right);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> mList = new ArrayList<>();
		mList.add(2);

		System.out.println(new SymmetricTree().checkIfSymmetricLevel(mList));
	}

	private boolean checkIfSymmetricLevel(List<Integer> nodeLevel) {

		int i = 0;
		int j = nodeLevel.size() - 1;

		while (i < j) {
			if (nodeLevel.get(i) != nodeLevel.get(j))
				return false;
			i++;
			j--;
		}

		return true;
	}

}
