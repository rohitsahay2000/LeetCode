/*
 * Kth Smallest Element in a BST
Solution
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * 
 */

package com.rohit.trees;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementBST {

	public int kthSmallest(TreeNode root, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		kthSmallestHelper(root, k, pq);
		return pq.peek();

	}

	private void kthSmallestHelper(TreeNode root, int k, PriorityQueue<Integer> pq) {

		if (root == null)
			return;

		kthSmallestHelper(root.left, k, pq);

		if (pq.size() >= k) {
			if (root.val < pq.peek()) {
				pq.poll();
				pq.add(root.val);
			}
		} else {
			pq.add(root.val);
		}

		kthSmallestHelper(root.right, k, pq);

	}

}
