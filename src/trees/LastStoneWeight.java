/*
 *  Last Stone Weight
Solution
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 * 
 */

package com.rohit.trees;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
	
	public static void main(String[] args) {
		
		int arr[] = {3,9};		
		System.out.println(new LastStoneWeight().lastStoneWeight(arr));		
	}

	
	  public int lastStoneWeight(int[] stones) {
	        
		  	PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2.compareTo(o1);
				}
			});
	  
		  	for(int i=0;i<stones.length ;i++) {
		  		pq.add(stones[i]);
		  	}
		  	
		  	while(pq.size()>1) {
		  		
		  		int firstElement = pq.poll();
		  		int secondElement = pq.poll();
		  		
		  		if(firstElement==secondElement)
		  			continue;
		  		else
		  			pq.add(firstElement-secondElement); 		
		  	}
		  	
		  	if(pq.isEmpty())
		  		return 0;
		  	return pq.poll();
	  
	  }
}
