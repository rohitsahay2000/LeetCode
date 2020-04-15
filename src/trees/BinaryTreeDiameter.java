/*
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 * 
 */

package com.rohit.trees;

public class BinaryTreeDiameter {
	
	private int maxDiameter=0;
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.left = node1;
		root.right = node2;
		node1.left= new TreeNode(4);
		node1.right= new TreeNode(5);
		
		System.out.println(new BinaryTreeDiameter().diameterOfBinaryTree(root));
		
	}
	
    public int diameterOfBinaryTree(TreeNode root) {
    	
    	if(root==null)
    		return 0;
    	
    	int lDepth = getDepth(root.left);
    	int rDepth = getDepth(root.right);
    	
    	if(lDepth+rDepth+1> maxDiameter) {
    		maxDiameter = lDepth+rDepth;
    	}
    	
    	diameterOfBinaryTree(root.left);
    	diameterOfBinaryTree(root.right);
    	
    	return maxDiameter;
        
    }
    
    
    private int getDepth(TreeNode node) {
    	
    	if(node==null)
    		return 0;
    	
    	int lDepth = getDepth(node.left);
    	int rDepth = getDepth(node.right);
    	
    	return lDepth>rDepth?lDepth+1:rDepth+1;
    	
    }

}
