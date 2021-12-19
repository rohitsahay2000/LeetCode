/*
Minimum Window Substring

Solution
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?





*/

class Solution {
    public String minWindow(String s, String t) {
           
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character,Integer> tMap = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i),0)+1);
        }
        int reqSize = tMap.size();

        int l=0;
        int r=0;
        int formedSize=0;

        HashMap<Character,Integer> windowsMap = new HashMap<>();
        int[] ans = {-1, 0, 0};

        while(r<s.length()) {
            windowsMap.put(s.charAt(r), windowsMap.getOrDefault(s.charAt(r),0)+1);
            if(tMap.containsKey(s.charAt(r)) && tMap.get(s.charAt(r)).intValue()==windowsMap.get(s.charAt(r)).intValue()) {
                formedSize++;
            }

            while(l<=r && formedSize==reqSize) {
                if(ans[0]==-1 || r-l+1 < ans[0]) {
                    ans[0]=r-l+1;
                    ans[1]=l;
                    ans[2]=r;
                }
                windowsMap.put(s.charAt(l),windowsMap.get(s.charAt(l))-1);
                if(tMap.containsKey(s.charAt(l)) && windowsMap.get(s.charAt(l)).intValue()<tMap.get(s.charAt(l)).intValue()) {
                    formedSize--;
                }
                l++;
            }
            r++;
        }

        return ans[0]==-1 ? "":s.substring(ans[1],ans[2]+1);
        
    }
}
