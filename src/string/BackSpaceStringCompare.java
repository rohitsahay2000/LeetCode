/*
 * Backspace String Compare
Solution
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
 * 
 * 
 */


package com.rohit.strings;

public class BackSpaceStringCompare {

	public boolean backspaceCompare(String S, String T) {

		StringBuilder res1 = new StringBuilder();

		int i = S.length() - 1;
		int count = 0;
		while (i >= 0) {

			if (S.charAt(i) == '#')
				count++;
			else if (count != 0)
				count--;
			else
				res1.append(S.charAt(i));
			i--;
		}

		StringBuilder res2 = new StringBuilder();
		int j = T.length() - 1;
		count = 0;
		while (j >= 0) {

			if (T.charAt(j) == '#')
				count++;
			else if (count != 0)
				count--;
			else
				res2.append(T.charAt(j));
			j--;
		}

		return res1.toString().equals(res2.toString());
	}

}
