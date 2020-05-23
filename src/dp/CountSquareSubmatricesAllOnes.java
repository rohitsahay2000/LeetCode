/*
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
 * 
 */


package com.rohit.dp;

public class CountSquareSubmatricesAllOnes {

	public static void main(String[] args) {

	}

	public int countSquares(int[][] matrix) {

		int arr[][] = new int[matrix.length][matrix[0].length];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = matrix[i][0];
			count += arr[i][0];
		}

		for (int j = 1; j < arr[0].length; j++) {
			arr[0][j] = matrix[0][j];
			count += arr[0][j];
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (matrix[i][j] == 1) {
					arr[i][j] = min(arr[i - 1][j], arr[i - 1][j - 1], arr[i][j - 1]) + 1;
					count += arr[i][j];
				}

			}
		}

		return count;
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
