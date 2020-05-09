package com.rohit.math;
/*
 * Valid Perfect Square
Solution
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Output: true
Example 2:

Input: 14
Output: false
 * 
 */
public class ValidPerfectSquare {

	public boolean isPerfectSquare(int num) {

		if (num == 1)
			return true;

		long low = 2;

		long high = num / 2;

		while (low <= high) {

			long mid = (low + high) / 2;
			long result = mid * mid;
			if (result == num)
				return true;
			if (result < num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}

}
