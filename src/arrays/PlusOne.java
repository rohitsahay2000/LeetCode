/**
 * Plus One
 *
 * Solution
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 *
 * Input: digits = [0]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 *
 *
 */


import java.util.LinkedList;
import java.util.List;

public class PlusOne {

    public static void main(String[] args) {

        int digits[] = {9,9,9};

        new PlusOne().plusOne(digits);

    }

    public int[] plusOne(int[] digits) {

        List<Integer> mList = new LinkedList<>();

        int i= digits.length-1;

        int sum = digits[digits.length-1] +1;
        int carry = sum/10;
        mList.add(0,sum%10);
        i--;

        while(i>=0) {
            sum= digits[i] + carry;
            carry = sum/10;
            mList.add(0,sum%10);
            i--;
        }

        if(carry>0) {
            mList.add(0,1);
        }

        int[] arr = mList.stream().mapToInt(j -> j).toArray();

        return arr;
    }


}
