package com.rohit.extras;

import java.util.HashMap;

public class TwoSum {
	
	
	public static void main(String[] args) {
		int arr[] = {2,7,11,15};
		System.out.println(new TwoSum().twoSum(arr, 9));
	}

	public int[] twoSum(int[] nums, int target) {

		int result[] = new int[2];
		HashMap<Integer,Integer> mMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (mMap.containsKey(nums[i])) {
				result[0] = mMap.get(nums[i]);
				result[1] = i;
				return result;
			}
			mMap.put(target - nums[i],i);
		}

		return result;

	}

}
