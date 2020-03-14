package com.rohit.arrays;

public class SearchRotatedSortedArray {
	
	
	public static void main(String[] args) {
		
		int arr[] = {4,5,6,7,0,1,2};
		
		System.out.println(new SearchRotatedSortedArray().search(arr, 2));
		
	}
	
	

	public int search(int[] nums, int target) {
		
		if(nums==null)
			return -1;

		int l = 0;
		int r = nums.length - 1;

		while (l <= r) {

			int mid = (l + r) / 2;
			if (nums[mid] == target) {
				return mid;
			}

			if (nums[l] <= nums[mid]) {
				
				if(target>=nums[l] && target <= nums[mid]) {
					r=mid-1;
				}
				else {
					l=mid+1;
				}
				
			}

			else if (nums[mid] <= nums[r]) {
				if(target>=nums[mid] && target <= nums[r])  {
					l=mid+1;
				}
				else {
					r=mid-1;
				}
				
			}

		}

		return -1;
	}

}
