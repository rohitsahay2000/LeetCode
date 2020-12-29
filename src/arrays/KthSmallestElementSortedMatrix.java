package com.rohit.extras;

import java.util.Comparator;


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
