package com.rohit.arrays;

public class MoveZeroes {

	public static void main(String[] args) {

		int nums[] = { 0,0,0 };
		new MoveZeroes().moveZeroes(nums);

	}

	public void moveZeroes(int[] nums) {

		int i = 0, j = 1;

		while (i < nums.length && j < nums.length) {
			if (nums[i] == 0 && nums[j] != 0) {
				swap(i, j, nums);
				i++;
				j++;
			} else if (nums[i] == 0 && nums[j] == 0) {
				j++;
			} else {
				i++;
				j++;
			}

		}
	}

	private void swap(int i, int j, int nums[]) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
