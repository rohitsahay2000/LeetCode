/*
 * Maximal Square
Solution
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
 * 
 */

package com.rohit.dp;

public class MaximalSquare {

	public int maximalSquare(char[][] matrix) {

		if (matrix == null || (matrix.length == 0) || (matrix[0].length == 0))
			return 0;

		int arr[][] = new int[matrix.length][matrix[0].length];

		int maxSquareArea = 0;

		int row = 0;
		int col = 0;
		while (col < arr[0].length) {
			if (matrix[0][col] == '1') {
				arr[0][col] = 1;
				maxSquareArea = 1;
			}
			col++;
		}

		while (row < matrix.length) {
			if (matrix[row][0] == '1') {
				arr[row][0] = 1;
				maxSquareArea = 1;
			}
			row++;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {

				if (matrix[i][j] == '1') {
					arr[i][j] = min(arr[i - 1][j], arr[i][j - 1], arr[i - 1][j - 1]) + 1;
					if (arr[i][j] > maxSquareArea) {
						maxSquareArea = arr[i][j];
					}
				}

			}
		}

		return maxSquareArea * maxSquareArea;
	}

	private int min(int a, int b, int c) {

		if (a < b && a < c)
			return a;
		else if (b < c)
			return b;
		else
			return c;
	}

}
