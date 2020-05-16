/*
 * Remove K Digits
Solution
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * 
 */



package com.rohit.greedy;

import java.util.Stack;

public class RemoveKDigits {

	public static void main(String[] args) {

		System.out.println(new RemoveKDigits().removeKdigits("10211103", 7));

	}

	public String removeKdigits(String num, int k) {

		if (k >= num.length())
			return "0";

		Stack<Character> mStack = new Stack<>();

		int i = 0;
		Character prevChar = null;
		while (i < num.length()) {

			Character currentChar = num.charAt(i);
			if (prevChar == null)
				prevChar = currentChar;
			else if (currentChar < prevChar && k > 0) {
				while (!mStack.isEmpty() && currentChar< mStack.peek()  && k>0) {
					mStack.pop();
					k--;
				}
			}

			mStack.push(currentChar);
			prevChar = currentChar;
			i++;
		} 
		
		while(k>0)
		{
			mStack.pop();
			k--;
		}

		boolean firstNonZeroCharacterEncountered = false;
		StringBuilder strBuilder = new StringBuilder();

		for (Character character : mStack) {

			if (firstNonZeroCharacterEncountered == true) {
				strBuilder.append(character);
				continue;
			}

			else if (character != '0' && firstNonZeroCharacterEncountered == false) {
				firstNonZeroCharacterEncountered = true;
				strBuilder.append(character);
			} else {
				continue;
			}
		}
		
		if(strBuilder.toString().isEmpty())
			return "0";
		
		return strBuilder.toString();
	}

}
