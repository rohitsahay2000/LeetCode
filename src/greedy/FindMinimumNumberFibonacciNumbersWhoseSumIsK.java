/*
 * Given the number k, return the minimum number of Fibonacci numbers whose sum is equal to k, whether a Fibonacci number could be used multiple times.

The Fibonacci numbers are defined as:

F1 = 1
F2 = 1
Fn = Fn-1 + Fn-2 , for n > 2.
It is guaranteed that for the given constraints we can always find such fibonacci numbers that sum k.
 

Example 1:

Input: k = 7
Output: 2 
Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ... 
For k = 7 we can use 2 + 5 = 7.
Example 2:

Input: k = 10
Output: 2 
Explanation: For k = 10 we can use 2 + 8 = 10.
Example 3:

Input: k = 19
Output: 3 
Explanation: For k = 19 we can use 1 + 5 + 13 = 19.
 

Constraints:

1 <= k <= 10^9
 * 
 */

package com.rohit.greedy;

import java.util.ArrayList;
import java.util.List;

public class FindMinimumNumberFibonacciNumbersWhoseSumIsK {
	
	
	 public int findMinFibonacciNumbers(int k) {
	        
	        List<Integer> fibList = new ArrayList<>();
	        fibList.add(1);
	        fibList.add(1);
	        
	        int num =1;
	        int i=2;
	        while(num<=k) {
	            num = fibList.get(i-1) + fibList.get(i-2);
	            fibList.add(num);
	            i++;
	        }
	        
	        int count=0;
	        int index = fibList.size()-1;
	        while(index>=0) {
	            if(k>=fibList.get(index)) {
	                k=k-fibList.get(index);
	                count++;
	            }
	            index--;
	        }
	        
	        return count;
	    }

}
