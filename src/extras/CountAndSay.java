/*
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.

Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.

Note: Each term of the sequence of integers will be represented as a string.

 
 * 
 * 
 */


package com.rohit.extras;

public class CountAndSay {

	public static void main(String[] args) {

		System.out.println(new CountAndSay().countAndSay(10));

	}

	private String countAndSay(int n) {

		if (n == 1)
			return "1";

		if (n == 2)
			return "11";

		String str1 = "11";

		StringBuilder strBuilder = null;
		for (int m = 2; m < n; m++) {
			Character temp_char = str1.charAt(0);
			int count = 1;
			strBuilder = new StringBuilder();
			for (int i = 1; i < str1.length(); i++) {
				if (str1.charAt(i) != temp_char) {
					strBuilder.append(count);
					strBuilder.append(temp_char);
					temp_char = str1.charAt(i);
					count = 1;
				} else {
					count++;
				}

			}
			strBuilder.append(count);
			strBuilder.append(temp_char);
			str1=strBuilder.toString();
		}

		return strBuilder.toString();

	}
}
