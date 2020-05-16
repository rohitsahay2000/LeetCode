package com.rohit.arrays;

import java.util.ArrayList;
import java.util.HashSet;
/*
 * Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

Push: Read a new element from the beginning list, and push it in the array.
Pop: delete the last element of the array.
If the target array is already built, stop reading more elements.
You are guaranteed that the target array is strictly increasing, only containing numbers between 1 to n inclusive.

Return the operations to build the target array.

You are guaranteed that the answer is unique.

 

Example 1:

Input: target = [1,3], n = 3
Output: ["Push","Push","Pop","Push"]
Explanation: 
Read number 1 and automatically push in the array -> [1]
Read number 2 and automatically push in the array then Pop it -> [1]
Read number 3 and automatically push in the array -> [1,3]
Example 2:

Input: target = [1,2,3], n = 3
Output: ["Push","Push","Push"]
Example 3:

Input: target = [1,2], n = 4
Output: ["Push","Push"]
Explanation: You only need to read the first 2 numbers and stop.
Example 4:

Input: target = [2,3,4], n = 4
Output: ["Push","Pop","Push","Push","Push"]
 

Constraints:

1 <= target.length <= 100
1 <= target[i] <= 100
1 <= n <= 100
target is strictly increasing.
 * 
 */

import java.util.List;

public class BuildArrayStackOperations {

	public List<String> buildArray(int[] target, int n) {

		HashSet<Integer> mSet = new HashSet<>();
		List<String> result = new ArrayList<>();

		for (int i = 0; i < target.length; i++) {
			mSet.add(target[i]);
		}
		int max = target[target.length - 1];

		for (int i = 1; i <= n; i++) {

			if (i > max)
				break;

			if (!mSet.contains(i)) {
				result.add("Push");
				result.add("Pop");
			}

			else {
				result.add("Push");
			}

		}

		return result;
	}
}
