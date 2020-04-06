/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 */

package com.rohit.arrays;

public class MaximumSubarray {

	public int maxSubArray(int[] nums) {

		int max_so_far = nums[0];
		int current_max = nums[0];

		for (int i = 1; i < nums.length; i++) {
			current_max = Math.max(nums[i], current_max + nums[i]);
			max_so_far = Math.max(current_max, max_so_far);
		}

		return max_so_far;
	}

}
