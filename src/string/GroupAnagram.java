/*
 * Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 * 
 */

package com.rohit.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class GroupAnagram {

	public static void main(String[] args) {

		String[] strs = new String[] { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(new GroupAnagram().groupAnagrams(strs));

	}

	public List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<>();
		
		if(strs==null || strs.length==0)
			return result;
		
		HashMap<String, List<String>> mMap = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char temp[] = strs[i].toCharArray();
			Arrays.sort(temp);
			String sortedString = String.valueOf(temp);

			if (!mMap.containsKey(sortedString)) {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				mMap.put(sortedString, list);
			}

			else {
				mMap.get(sortedString).add(strs[i]);
			}

		}

		for (Entry<String, List<String>> entry : mMap.entrySet()) {
			result.add(entry.getValue());
		}
		return result;
	}

}
