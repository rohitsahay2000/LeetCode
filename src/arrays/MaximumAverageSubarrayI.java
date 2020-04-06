/*
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

Example 1:

Input: [1,12,-5,-6,50,3], k = 4
Output: 12.75
Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 

Note:

1 <= k <= n <= 30,000.
Elements of the given array will be in the range [-10,000, 10,000].
 
 *
 */

package com.rohit.arrays;

public class MaximumAverageSubarrayI {
	
	public static void main(String[] args) {
		
		int arr[] = {-1};
		
		System.out.println(new MaximumAverageSubarrayI().findMaxAverage(arr, 1));
		
	}
	

	public double findMaxAverage(int[] nums, int k) {

		double sum = 0;
		double maxAvg = Integer.MIN_VALUE;
		int i = 0;
		int temp_i = 0;
		while (i < k && i< nums.length) {
			sum += nums[i];
			i++;
		}
		if ((sum / k) > maxAvg) {
			maxAvg = sum / k;
		}

		while (i < nums.length) {
			sum = sum - nums[temp_i];
			sum = sum + nums[i];

			if ((sum / k) > maxAvg) {
				maxAvg = sum / k;
			}
			i++;
			temp_i++;
		}

		return maxAvg;
	}

}
