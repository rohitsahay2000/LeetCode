package com.rohit.extras;

public class ValidPalindrome2 {

	public boolean validPalindrome(String s) {

		int i = 0;
		int j = s.length() - 1;

		while (i < j) {

			if (s.charAt(i) != s.charAt(j)) {
				return (isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1));
			}
			i++;
			j--;

		}

		return true;
	}

	private boolean isPalindrome(String str, int i, int j) {

		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

}
