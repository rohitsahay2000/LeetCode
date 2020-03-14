package com.rohit.extras;

import java.util.LinkedList;
import java.util.Queue;

public class PalindromeNumber {
	
	public static void main(String[] args) {
		
		System.out.println(new PalindromeNumber().isPalindrome(0));
		
		
	}
	
	

	public boolean isPalindrome(int x) {

		if (x < 0)
			return false;
		
		int temp_x =x;
		Queue<Integer> mQueue = new LinkedList<Integer>();
		
		while(temp_x >0) {
			int digit = temp_x%10;
			mQueue.add(digit);
			temp_x = temp_x/10;		
		}
		
		int num=0;
		while(!mQueue.isEmpty()) {
			int digit = mQueue.poll();
			num=num*10+digit;		
		}
		
		if(num==x)
			return true;

		return false;
	}

}
