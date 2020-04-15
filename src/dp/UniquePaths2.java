/*
 * 63. Unique Paths II
Medium

1417

221

Add to List

Share
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?



An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
 * 
 */


package com.rohit.dp;

public class UniquePaths2 {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		int arr[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
		if (obstacleGrid[0][0] == 1)
			return 0;
		arr[0][0] = 1;
		int col = 0;
		while (col < arr[0].length) {
			if (obstacleGrid[0][col] == 1)
				break;
			arr[0][col] = 1;
			col++;
		}

		int row = 0;
		while (row < arr.length) {
			if (obstacleGrid[row][0] == 1)
				break;
			arr[row][0] = 1;
			row++;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[0].length; j++) {
				if (obstacleGrid[i][j] == 1)
					arr[i][j] = 0;
				else
					arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}

		}

		return arr[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

}
