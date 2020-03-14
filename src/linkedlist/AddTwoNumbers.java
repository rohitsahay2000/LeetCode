package com.rohit.linkedlist;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		n1.next=n2;
		n2.next=n3;
		
		
		
		ListNode n11 = new ListNode(5);
		ListNode n12 = new ListNode(6);
		ListNode n13 = new ListNode(9);
		ListNode n14 = new ListNode(9);
		n11.next=n12;
		n12.next=n13;
		n13.next=n14;
		
		new AddTwoNumbers().addTwoNumbers(n1, n11);
		
	}
	
	
	

	public ListNode addTwoNumbers(ListNode node1, ListNode node2) {

		if (node1 == null && node2 == null)
			return null;
		else if (node1 == null)
			return node2;
		else if (node2 == null)
			return node1;

		ListNode resultListHead = null;
		int carry = 0;
		ListNode tail = null;
		while (node1!= null && node2!= null) {

			int sum = node1.val + node2.val + carry;
			ListNode node = new ListNode(sum % 10);
			carry = sum / 10;

			if (resultListHead == null) {
				resultListHead = node;
			} else {
				tail.next = node;
			}
			tail = node;
			node1 = node1.next;
			node2 = node2.next;
		}

		if (node1 != null) {
			while (node1 != null) {
				int sum = node1.val + carry;
				ListNode node = new ListNode(sum % 10);
				carry = sum / 10;
				tail.next = node;
				tail = node;
				node1=node1.next;
			}
		}

		if (node2 != null) {
			while (node2 != null) {
				int sum = node2.val + carry;
				ListNode node = new ListNode(sum % 10);
				carry = sum / 10;
				tail.next = node;
				tail = node;
				node2=node2.next;
			}
		}

		if (carry != 0) {
			ListNode node = new ListNode(1);
			tail.next = node;
			tail = node;
		}

		return resultListHead;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
