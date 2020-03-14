package com.rohit.arrays;

/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * 
 * 
 */

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		
		int arr[] = {1,1};
		
		System.out.println(new RemoveDuplicates().removeDuplicates(arr));
		
		
	}

	public int removeDuplicates(int[] nums) {

		if (nums == null) {
			return 0;
		}
		if (nums.length == 1)
			return 1;

		int i = 0;
		int j = i + 1;
		int duplicateCount = 0;
		while (i < nums.length && j < nums.length) {
			while (j < nums.length && nums[i] == nums[j]) {
				nums[j]=Integer.MAX_VALUE;
				duplicateCount++;
				j++;
			}
			i = j;
			if (j < nums.length) {
				j++;
			}

		}
		correctArray(nums);
		
		return nums.length-duplicateCount;

	}
	
	private void correctArray(int arr[]) {
		
		int i=0;		
		while (i<arr.length) {		
			if(arr[i]==Integer.MAX_VALUE) {
				int j=i;
				while(j<arr.length && arr[j]==Integer.MAX_VALUE) {
					j++;
				}
				if(j<arr.length)
					swapNum(i,j,arr);
			}
			i++;		
		}	
	}
	
	void swapNum(int i, int j, int arr[]) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
	}

}
