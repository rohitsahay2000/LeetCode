/*
 * You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
Example 4:

Input: s = "a(bcdefghijkl(mno)p)q"
Output: "apmnolkjihgfedcbq"
 

Constraints:

0 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It's guaranteed that all parentheses are balanced.
 * 
 */


package com.rohit.stack;

import java.util.Stack;

public class ReverseSubstringsBetweenEachPairofParentheses {
	
	public static void main(String[] args) {
		
		String str ="(ed(et(oc))el)";	
		System.out.println(new ReverseSubstringsBetweenEachPairofParentheses().reverseParentheses(str));
		
	}
	
	
	   public String reverseParentheses(String s) {
		   
		   if(s==null || s.length()==0) {
			   return s;
		   }
	        
		   Stack<Character> mStack = new Stack<>();
		   StringBuffer strBuff = null ;
		  
		   for(int i=0; i< s.length() ; i++) {
			   
			   if(s.charAt(i)==')') {
				   strBuff = new StringBuffer();
				   while(true) {
					   
					   Character c = mStack.pop();					   
					   if(c=='(') {
						   break;
					   }				   
					   strBuff.append(c);  
				   }
				   
				   for(int k=0; k< strBuff.length() ; k++) {
					   mStack.push(strBuff.charAt(k));
				   }
				   
			   }
			   else 
				   mStack.push(s.charAt(i));
			   	   
		   }
		   
		   StringBuffer result = new StringBuffer() ;
		   
		   for(Character c : mStack) {
			   result.append(c);
		   }
	   
		   return result.toString();
	   }

}
