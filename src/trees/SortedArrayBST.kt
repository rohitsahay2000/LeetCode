package src.trees

/**
 * Convert Sorted Array to Binary Search Tree

Solution
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

0
/ \
-3   9
/   /
-10  5
 *
 */

fun sortedArrayToBST(nums: IntArray): TreeNode? {

    return helperSortedArrayToBST(nums,0,nums.size-1)
}

fun helperSortedArrayToBST(arr: IntArray, l: Int, r: Int) : TreeNode? {
    if (l > r)
        return null
    val mid = (l + r) / 2
    val root = TreeNode(arr[mid])
    root.left = helperSortedArrayToBST(arr, l, mid - 1)
    root.right = helperSortedArrayToBST(arr, mid + 1, r)

     return root
}