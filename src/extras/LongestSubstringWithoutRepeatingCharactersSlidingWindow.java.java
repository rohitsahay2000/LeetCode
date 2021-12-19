/*

Longest Substring Without Repeating Characters
Medium

19583

893

Add to List

Share
Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.



*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
     int maxLength = 0;
     int start=0;
     int r=0;
     HashMap<Character,Integer> map = new HashMap<>();   
     
     while(r<s.length()) {
         
         if(map.containsKey(s.charAt(r))) {
             if(map.get(s.charAt(r)) >= start) 
                start=map.get(s.charAt(r))+1;
         }
         map.put(s.charAt(r),r);
         
         if(r-start+1>maxLength) {
             maxLength=r-start+1;
         }
         r++;
     }   
                      
     return maxLength;                
  }
}
