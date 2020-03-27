/*
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
 */

package com.rohit.dp;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {

		int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));

	}

	public int lengthOfLIS(int[] nums) {
		
		if(nums==null || nums.length==0)
			return 0;

		int lisLength[] = new int[nums.length];

		for (int i = 0; i < lisLength.length; i++) {
			lisLength[i] = 1;
		}

		int maxLength=1;
		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
				}

			}
		}
		
		for(int i=0;i <lisLength.length ; i++) {
			if(lisLength[i]>maxLength) {
				maxLength=lisLength[i];
			}
		}
		
		return maxLength;

	}

}
