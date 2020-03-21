/*
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

 

Follow up:

You may only use constant extra space.
Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 * 
 */


package com.rohit.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNode {
	
	   public Node connect(Node root) {
	        
	        if(root==null)
	            return null;
	        	 
			Queue<Node> mQueue = new LinkedList<Node>();

			mQueue.add(root);

			while (!mQueue.isEmpty()) {

					int i = 0;
					int size = mQueue.size();
					
					Node prevNode = null;

					
					for(Node node: mQueue) {
						
						if(prevNode==null) {
							prevNode = node;
						}
						
						else {
							prevNode.next = node;
							prevNode=node;
						}
						
					}

					while (i < size) {
						Node node = mQueue.poll();
						if (node.right != null) {
							mQueue.add(node.left);
						}
						if (node.left != null) {
							mQueue.add(node.right);
						}
						i++;
					}

				}
		        
				return root;   
	        
	    }

}
