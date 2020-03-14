package com.rohit.extras;

import java.util.Stack;

public class ValidParentheses {
	
	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("()[]{}"));
	}
	
	

	public boolean isValid(String s) {
		
		if(s==null)
			return false;

		Stack<Character> mStack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				mStack.push(s.charAt(i));
			}
			else {
				if (s.charAt(i) == ')') {
					if (!mStack.isEmpty() && mStack.peek() == '(')
						mStack.pop();
					else return false;
				} else if (s.charAt(i) == '}') {
					if (!mStack.isEmpty() && mStack.peek() == '{')
						mStack.pop();
					else 
						return false;
						
				}
				else if (s.charAt(i) == ']') {
					if (!mStack.isEmpty()  && mStack.peek() == '[')
						mStack.pop();
					else
						return false;
				}
			}
		}
		
		if(mStack.isEmpty())
			return true;

		return false;

	}

}
