package com.rohit.extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
	
	public static void main(String[] args) {
		
		int arr[] = {1,2,4,-3,-5,1,2,-3};
		new ThreeSum().threeSum1(arr);
		
	}
	
	
	
    public List<List<Integer>> threeSum(int[] nums) {
        
		Arrays.sort(nums);
		List<List<Integer>> myArrayList = new ArrayList<>();

		int start = 0;
		int end = nums.length - 1;

		while (start < end) {

			int start1 = start + 1;
			int end1 =  end;
		
			while (start1 < end1) {

				if ((nums[start] + nums[start1] + nums[end1]) == 0) {
					ArrayList<Integer> tempArrayList = new ArrayList<>();
					tempArrayList.add(nums[start]);
					tempArrayList.add(nums[start1]);
					tempArrayList.add(nums[end1]);
					if(!myArrayList.contains(tempArrayList))
						myArrayList.add(tempArrayList);
					start1++;
				} else if ((nums[start] + nums[start1] + nums[end1]) < 0) {
					start1++;
				} else if ((nums[start] + nums[start1] + nums[end1]) > 0) {
					end1--;
				}

			}
			start++;

		}
		return myArrayList;       
    }
    
    
 public List<List<Integer>> threeSum1(int[] nums) {
        
	    Arrays.sort(nums);
		List<List<Integer>> myArrayList = new ArrayList<>();		  
        for (int i = 0; i < nums.length-1; i++)  
        { 
            HashSet<Integer> s = new HashSet<Integer>(); 
            for (int j = i + 1; j < nums.length; j++)  
            { 
                int x = -(nums[i] + nums[j]); 
                if (s.contains(x))  
                { 
                    ArrayList<Integer> mList = new ArrayList<>();
                    mList.add(x);
                    mList.add(nums[i]);
                    mList.add(nums[j]);
                	if(!myArrayList.contains(mList))
						myArrayList.add(mList);
                	s.clear();
                }  
                else 
                { 
                    s.add(nums[j]); 
                } 
            } 
        } 
		return myArrayList;       
    }

}
