/**
 *
 * Length of Last Word
 *
 * Solution
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 *
 *
 */

public class LengthofLastWord {

    public int lengthOfLastWord(String s) {

        if(s==null )
            return 0;

        String str = s.trim();

        if(str.length()==0)
            return 0;

        String [] words = str.split(" ");
        return words[words.length-1].length();
    }
}
