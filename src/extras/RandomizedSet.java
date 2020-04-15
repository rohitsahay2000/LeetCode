/*
 * Insert Delete GetRandom O(1)
Solution
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * 
 */

package com.rohit.extras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

	private HashMap<Integer, Integer> mMap;
	private ArrayList<Integer> nodeList;

	public static void main(String[] args) {
		RandomizedSet randomizedSet = new RandomizedSet();
		randomizedSet.insert(1);
		randomizedSet.remove(2);
		randomizedSet.insert(2);
		System.out.println(randomizedSet.getRandom());
		randomizedSet.remove(1);
		randomizedSet.insert(2);
		System.out.println(randomizedSet.getRandom());

	}

	/** Initialize your data structure here. */
	public RandomizedSet() {
		mMap = new HashMap<>();
		nodeList = new ArrayList<>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (!mMap.containsKey(val)) {
			mMap.put(val, nodeList.size());
			nodeList.add(val);
			return true;
		}
		return false;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {

		if (mMap.containsKey(val)) {
			int index = mMap.get(val);
			int lastElement = nodeList.get(nodeList.size() - 1);
			nodeList.set(index, lastElement);
            mMap.put(lastElement, index);
			nodeList.remove(nodeList.size() - 1);
			mMap.remove(val);
			return true;
		}

		return false;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		Random random = new Random();
		return nodeList.get(random.nextInt(nodeList.size()));
	}

}

