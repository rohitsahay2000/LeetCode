package com.rohit.arrays;

public class RotateArray {
	
	
	public static void main(String[] args) {
		
		int arr[]={1};
		new RotateArray().rotate(arr, 3);
		
	}

	public void rotate(int[] nums, int k) {
		
		while(k>0) {
			int temp = nums[nums.length-1];
			int i = nums.length-1;
			
			while(i>0) {
				nums[i]=nums[i-1];
				i--;
			}
			nums[0] = temp;		
			k--;
		}
	}

}
