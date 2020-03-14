package com.rohit.extras;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {

		System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("AAB"));

	}

	public int lengthOfLongestSubstring(String s) {

		int maxLength = 0;

		HashSet<Character> cSet = new HashSet<>();

		for (int i = 0; i < s.length();i++) {
			cSet.add(s.charAt(i));
			for (int j = i + 1; j < s.length();j++) {
				if (cSet.add(s.charAt(j)) == false) {
					if (cSet.size() > maxLength) {
						maxLength = cSet.size();
						cSet.clear();
					}
					i=j-1;
					break;
				}
			}
			if(cSet.size()==s.length())
				break;
			if(cSet.size()>maxLength) {
				maxLength=cSet.size();
			}
			cSet.clear();
		}
		return maxLength > cSet.size() ? maxLength : cSet.size();
	}

}
