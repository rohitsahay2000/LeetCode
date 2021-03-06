/*
 * Write an algorithm to determine if a number is "happy".

* A happy number is a number defined by the following process: Starting with any positive integer,
* replace the number by the sum of the squares of its digits, and repeat the process until the
* number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
* Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 * 
 * 
 * 
 */


package com.rohit.arrays;

public class HappyNumber {

	public boolean isHappy(int n) {

		if (n == 1)
			return true;

		int slow, fast;

		slow = fast = n;
		do {
			slow = func(slow);
			fast = func(func(fast));
		} while (slow != fast);

		return (slow == 1);

	}

	private int func(int n) {
		int squareSum = 0;
		while (n != 0) {
			squareSum += (n % 10) * (n % 10);
			n /= 10;
		}
		return squareSum;
	}

}
