/*
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * 
 * 
 */


package com.rohit.arrays;

import java.util.HashMap;

public class SubarraySumEqualsK {
	
	public static void main(String[] args) {
		
		int nums[] ={1,1,1};
		System.out.println(new SubarraySumEqualsK().subarraySum(nums, 2));
		
	}
	
	
    public int subarraySum(int[] nums, int k) {
    	
        int sum=0;
        int count=0;
        HashMap<Integer,Integer> mMap = new HashMap<>();
        mMap.put(0,1);
        
        for(int i=0 ;i<nums.length; i++) {
            sum+=nums[i];
            if(mMap.containsKey(sum-k)) {
                count+=mMap.get(sum-k);
            }
            mMap.put(sum,mMap.getOrDefault(sum,0)+1);
        }
        return count;
    	
    	
    }

}
