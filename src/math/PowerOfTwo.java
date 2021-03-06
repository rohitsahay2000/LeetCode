/**
 *  Power of Two
 *
 * Solution
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 *
 */


public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(1024));
    }

    public boolean isPowerOfTwo(int n) {

        if(n<=0)
            return false;

        int num = n&(n-1);
        if(num == 0)
            return true;
        return false;

    }
}
