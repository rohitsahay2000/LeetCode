package com.rohit.binarysearch;

public class SingleElementInSortedArray {

	public int singleNonDuplicate(int[] nums) {

		if (nums.length == 1)
			return nums[0];

		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {

			int mid = (low + high) / 2;

			if (mid == 0 || mid == nums.length - 1)
				return nums[mid];

			if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
				return nums[mid];

			// even index, odd number of elements
			if (mid % 2 == 0) {

				if (nums[mid] == nums[mid - 1]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			// odd index, even number of elements
			else {
				if (nums[mid] == nums[mid - 1])
					low = mid + 1;
				else
					high = mid - 1;
			}

		}
		return -1;
	}

}
