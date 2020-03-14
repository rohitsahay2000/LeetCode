package com.rohit.arrays;

public class TrappingRainWater {

	public static void main(String[] args) {

		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(new TrappingRainWater().trap(arr));

	}

	public int trap(int[] height) {

		if (height == null || height.length == 0)
			return 0;

		int lheight[] = height.clone();
		int rheight[] = height.clone();

		for (int i = 1; i < height.length; i++) {
			if (lheight[i] < lheight[i - 1]) {
				lheight[i] = lheight[i - 1];
			}
		}

		rheight[rheight.length - 1] = height[height.length - 1];
		for (int i = rheight.length - 2; i >= 0; i--) {
			if (rheight[i] < rheight[i + 1]) {
				rheight[i] = rheight[i + 1];
			}
		}

		int maxTrappedWater = 0;

		for (int i = 0; i < height.length; i++) {

			if (lheight[i] < rheight[i]) {
				if (lheight[i] - height[i] > 0)
					maxTrappedWater += lheight[i] - height[i];
			} else {
				if (rheight[i] - height[i] > 0)
					maxTrappedWater += rheight[i] - height[i];
			}

		}

		return maxTrappedWater;
	}

}
