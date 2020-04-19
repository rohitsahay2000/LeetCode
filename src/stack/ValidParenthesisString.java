/*
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
Example 1:
Input: "()"
Output: True
Example 2:
Input: "(*)"
Output: True
Example 3:
Input: "(*))"
Output: True
Note:
The string size will be in the range [1, 100].
 * 
 */

package com.rohit.stack;

import java.util.Stack;

public class ValidParenthesisString {

	public static void main(String[] args) {

		System.out.println(new ValidParenthesisString().checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
	}

	public boolean checkValidString(String s) {

		Stack<Integer> cStack1 = new Stack<>();
		Stack<Integer> cStack2 = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				cStack1.push(i);
			} else if (s.charAt(i) == ')') {
				if (!cStack1.isEmpty())
					cStack1.pop();
				else {
					if (!cStack2.isEmpty())
						cStack2.pop();
					else
						return false;
				}
			} else if (s.charAt(i) == '*') {
				cStack2.push(i);
			}
		}

		if (!cStack1.isEmpty() && !cStack2.isEmpty()) {
			while (!cStack1.isEmpty() && !cStack2.isEmpty()) {
				int index1 = cStack1.pop();
				int index2 = cStack2.pop();

				if (index2 < index1)
					return false;
			}
		}

		if (cStack1.isEmpty())
			return true;

		return false;
	}

}
