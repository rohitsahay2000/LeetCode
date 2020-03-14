package com.rohit.extras;

import java.util.Stack;

public class NumberOfIslands {

	private boolean visited[][];
	
	
	public static void main(String[] args) {
		
		char arr[][] = new char [4][5];
		arr[0][0]=1;
		arr[0][1]=1;
		arr[0][2]=1;
		arr[0][3]=1;
		
		arr[1][0]=1;
		arr[1][1]=1;
		arr[1][3]=1;

		arr[2][0]=1;
		arr[2][1]=1;
		
	
		System.out.println(new NumberOfIslands().numIslands(arr));
		
	}


    
    public int numIslands(char[][] grid) {
    
		int count = 0;
		
		if(grid.length==0)
			return count;
		
		visited = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {

				if (visited[i][j] == false && (int)grid[i][j]==1) {
					count++;
					doDFS(new Pair(i, j), grid.length, grid[0].length,grid);

				}

			}

		}
		return count;    
    }
    
    	private void doDFS(Pair pair, int gridRowLength, int gridColumnLength, char grid[][]) {

		Stack<Pair> mStack = new Stack<>();
		mStack.push(pair);
		visited[pair.row][pair.column] = true;

		while (!mStack.isEmpty()) {

			Pair poppedPair = mStack.pop();

			int row = poppedPair.row;
			int column = poppedPair.column;

			if (row + 1 < gridRowLength && grid[row + 1][column]==1 && visited[row + 1][column] == false) {
				mStack.push(new Pair(row + 1, column));
				visited[row + 1][column] = true;
			}

			if (row - 1 >= 0 && grid[row - 1][column]==1 && visited[row - 1][column] == false) {
				mStack.push(new Pair(row - 1, column));
				visited[row - 1][column] = true;
			}

			if (column + 1 < gridColumnLength && grid[row][column+1]==1 && visited[row][column + 1] == false) {
				mStack.push(new Pair(row, column + 1));
				visited[row][column + 1] = true;
			}

			if (column - 1 >= 0 && grid[row][column-1]==1 && visited[row][column - 1] == false) {
				mStack.push(new Pair(row, column - 1));
				visited[row][column - 1] = true;
			}
		}

	}



}

class Pair {
	int row;
	int column;

	public Pair(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
