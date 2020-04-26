/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?
 * 
 * 
 */

package com.rohit.extras;

import java.util.HashMap;

public class LRUCache {

	private int capacity;
	private Node first;
	private Node last;
	private HashMap<Integer, Node> mMap = new HashMap<>();
	private int currentSize = 0;

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(1 /* capacity */ );

		cache.put(2, 1);
		System.out.println(cache.get(2));
	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {

		if (!mMap.containsKey(key))
			return -1;

		else {
			Node existingNode = mMap.get(key);
			removeNode(existingNode);
			offerNode(existingNode);
			return existingNode.value;
		}

	}

	public void put(int key, int value) {

		Node tempNode = new Node(key, value);
		if (!mMap.containsKey(key)) {
			if (currentSize < capacity) {
				mMap.put(key, tempNode);
				offerNode(tempNode);
			} else {
				mMap.remove(last.key);
				removeNode(last);
				offerNode(tempNode);
				mMap.put(key, tempNode);
			}
		} else {
			Node existingNode = mMap.get(key);
			removeNode(existingNode);
			offerNode(existingNode);
			if (existingNode.value != value) {
				existingNode.value = value;
			}
		}

	}

	private void offerNode(Node node) {
		if (first == null && last == null) {
			first = node;
			last = node;
		} else {
			node.next = first;
			first.prev = node;
			first = node;
			first.prev = null;
		}
		currentSize++;
	}

	private void removeNode(Node node) {

		if (first == node && last == node) {
			first = null;
			last = null;
		}
		else if (first == node) {
			first = node.next;
			node.next = null;
		} else if (last == node) {
			last = node.prev;
			last.next = null;
		}

		else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
		}
		currentSize--;
	}

}

class Node {
	int key;
	int value;
	Node prev;
	Node next;

	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.prev = null;
		this.next = null;
	}
}
