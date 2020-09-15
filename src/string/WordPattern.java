/**
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
 *
 *
 */

import java.util.HashMap;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba","dog cat cat dog"));
    }


    public boolean wordPattern(String pattern, String str) {

        String [] strings = str.split(" ");

        if(pattern.length() != strings.length)
            return false;

        char [] chars = pattern.toCharArray();

        HashMap<Character,String > mMap = new HashMap<>();
        for(int i=0; i<chars.length; i++) {
            if(mMap.containsKey(chars[i])) {
                String tempStr = mMap.get(chars[i]);
                if(!tempStr.equals(strings[i]))
                    return false;
            }
            else {
                if(mMap.containsValue(strings[i]))
                    return false;
            }
            mMap.put(chars[i],strings[i]);
        }
        return true;
    }
}
