/*
 * Flood Fill
Solution
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
Note:

The length of image and image[0] will be in the range [1, 50].
The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 * 
 */


package com.rohit.graph;

import java.util.Stack;

public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		boolean visited[][] = new boolean[image.length][image[0].length];
		int color = image[sr][sc];

		Stack<Pair> mStack = new Stack<Pair>();
		mStack.push(new Pair(sr, sc));
		visited[sr][sc] = true;
		image[sr][sc] = newColor;

		while (!mStack.isEmpty()) {

			Pair pair = mStack.pop();

			int currX = pair.x;
			int currY = pair.y;

			if (currX - 1 >= 0 && image[currX - 1][currY] == color && !visited[currX - 1][currY]) {
				mStack.push(new Pair(currX - 1, currY));
				image[currX - 1][currY] = newColor;
				visited[currX - 1][currY] = true;
			}

			if (currY - 1 >= 0 && image[currX][currY - 1] == color && !visited[currX][currY - 1]) {
				mStack.push(new Pair(currX, currY - 1));
				image[currX][currY - 1] = newColor;
				visited[currX][currY - 1] = true;
			}

			if (currX + 1 < image.length && image[currX + 1][currY] == color && !visited[currX + 1][currY]) {
				mStack.push(new Pair(currX + 1, currY));
				image[currX + 1][currY] = newColor;
				visited[currX + 1][currY] = true;
			}

			if (currY + 1 < image[0].length && image[currX][currY + 1] == color && !visited[currX][currY + 1]) {
				mStack.push(new Pair(currX, currY + 1));
				image[currX][currY + 1] = newColor;
				visited[currX][currY + 1] = true;
			}
		}
		return image;
	}
}

class Pair {

	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
