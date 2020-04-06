/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 * 
 */

package com.rohit.arrays;

public class FindMinimumRotatedSortedArray {
	
	  public int findMin(int[] nums) {
	        
			if (nums.length == 0 || nums == null) {
				return -1;
			}

			int start = 0;
			int end = nums.length - 1;

			if (nums[start] <= nums[end]) // array is sorted
				return nums[start];

			while (start <= end) {
				int mid = (start+end)/2;

				if(mid==0) {
					if(nums[mid]<nums[end])
						return nums[mid];
					else
						return nums[end];
				}
				if(mid==nums.length-1) {
					if(nums[mid]<nums[start])
						return nums[mid];
					else
						return nums[start];
				}
				
				// check if mid is pivot
				if (nums[mid+1] >= nums[mid] && nums[mid-1]>=nums[mid]) {
					return nums[mid];
				} else if (nums[mid] < nums[end]) {
					end = mid -1 ;
				} else {
					start = mid + 1;
				}
				
			}

			return nums[0];    
	    }

}
