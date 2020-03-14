package com.rohit.arrays;

import java.util.HashSet;

public class ContainsDuplicate {

	public static void main(String[] args) {
		int nums[] = {1,1};
		System.out.println(new ContainsDuplicate().containsDuplicate(nums));
	}

	public boolean containsDuplicate(int[] nums) {

		HashSet<Integer> mSet = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			if (mSet.add(nums[i]) == false)
				return true;
		}

		return false;
	}

}
