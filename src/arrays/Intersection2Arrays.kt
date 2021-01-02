package src.arrays

/**
 *  Intersection of Two Arrays II

Solution
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 *
 */

class Intersection2Arrays {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val mMap = HashMap<Int, Int>()
        val result = ArrayList<Int>()
        for (i in nums1.indices) {
            if (mMap.containsKey(nums1[i])) {
                mMap[nums1[i]] = mMap[nums1[i]]!! + 1
            } else mMap[nums1[i]] = 1
        }
        for (i in nums2.indices) {
            if (mMap.containsKey(nums2[i]) && mMap[nums2[i]]!! > 0) {
                result.add(nums2[i])
                mMap[nums2[i]] = mMap[nums2[i]]!! - 1
            }
        }
        val arr = IntArray(result.size)
        for (i in result.indices) {
            arr[i] = result[i]
        }
        return arr
    }
}