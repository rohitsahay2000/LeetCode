package com.rohit.arrays;

public class ReverseString {

	public static void main(String[] args) {

		new ReverseString().reverseString("a".toCharArray());

	}

	public void reverseString(char[] s) {
		if(s==null)
			return;
		helper(s, 0);
		System.out.println(s);
	}

	private void helper(char s[], int i) {

		if (s == null || i >= s.length) {
			return;
		}
		helper(s, i + 1);
		swap(i, s.length-i-1, s);

	}

	private void swap(int i, int j, char[] s) {
		if (i > j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		} else
			return;
	}

}
