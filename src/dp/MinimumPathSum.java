/*
 * 64. Minimum Path Sum
Medium

2311

50

Add to List

Share
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 */

package com.rohit.dp;

public class MinimumPathSum {
	
	   public int minPathSum(int[][] grid) {
	        
			int col = 1;
			while (col < grid[0].length) {
				grid[0][col] = grid[0][col] + grid[0][col-1];
				col++;
			}

			int row = 1;
			while (row < grid.length) {
				grid[row][0] = grid[row][0] + grid[row-1][0];
				row++;
			}

	        for (int i = 1; i < grid.length; i++) {
				for (int j = 1; j < grid[0].length; j++) {
					grid[i][j] = grid[i][j] + Math.min(grid[i][j-1],grid[i-1][j]); 
				}
			}
	        
	        return grid[grid.length-1][grid[0].length-1];
	    }

}
