/*
 * Fraction to Recurring Decimal
Medium

727

1604

Add to List

Share
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
 * 
 * 
 */

package com.rohit.extras;

import java.util.HashMap;


public class FractionToRecurringDecimal {

	public static void main(String[] args) {

		System.out.println(new FractionToRecurringDecimal().fractionToDecimal(22,7));
	}

	public String fractionToDecimal(int numerator, int denominator) {
		
		if(numerator==0)
			return "0";

		StringBuilder result = new StringBuilder();
		
		long num = Math.abs((long)numerator) ;
		long den =  Math.abs((long)denominator);
		
		result.append(num/den);
		if((numerator<0 && denominator>0) || (numerator>0 && denominator<0)) {
			result.insert(0, "-");
		}
		long remainder = num % den;

		if (remainder == 0)
			return result.toString();

		result.append(".");
		HashMap<Long, Integer> mMap = new HashMap<>();
		mMap.put(remainder, result.length());
		while (remainder != 0) {
			remainder = remainder * 10;
			long val = remainder / den;
			result.append(val);
			remainder = remainder % den;
			if (mMap.containsKey(remainder)) {
				int index = mMap.get(remainder);
				result.insert(index, "(");
				result.append(")");
				break;
			}	
			mMap.put(remainder, result.length());
		}
		return result.toString();
	}

}
