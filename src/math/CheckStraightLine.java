/*
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

 

 

Example 1:



Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:



Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
 * 
 */


package com.rohit.math;

public class CheckStraightLine {

	public boolean checkStraightLine(int[][] coordinates) {

		double x1 = coordinates[0][0];
		double y1 = coordinates[0][1];

		double x2 = coordinates[1][0];
		double y2 = coordinates[1][1];

		double slope = (y2 - y1) / (x2 - x1);

		for (int i = 2; i < coordinates.length; i++) {
			double tmpSlope = (double) (coordinates[i][1] - coordinates[i - 1][1])
					/ (coordinates[i][0] - coordinates[i - 1][0]);
			if (tmpSlope != slope)
				return false;
		}
		return true;
	}

}
