/*
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 * 
 */


package com.rohit.extras;

import java.util.Comparator;
/*
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note:
You may assume k is always valid, 1 ≤ k ≤ n2.
 * 
 * 
 */


import java.util.PriorityQueue;

public class KthSmallestElementSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {

		int m = matrix.length;
		int n = matrix[0].length;

		PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pQueue.size() <= 3) {
					pQueue.add(matrix[i][j]);
				}

				else {

					if (matrix[i][j] > pQueue.peek()) {
						pQueue.poll();
						pQueue.add(matrix[i][j]);

					}

				}

			}
		}
		
		
		return pQueue.peek();
	}
}
