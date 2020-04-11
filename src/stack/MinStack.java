/**
 * Min Stack
Solution
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 */

package com.rohit.stack;

import java.util.Stack;

public class MinStack {
	
	private Stack<Integer> mStack;
	private Stack<Integer> minStack;
	private int min_value;
	
	public static void main(String[] args) {
		MinStack test = new MinStack();
		test.push(2147483646);
		test.push(2147483646);
		test.push(2147483647);
		System.out.println(test.top());
		test.pop();
		System.out.println(test.getMin());
		test.pop();
		System.out.println(test.getMin());
		test.pop();
		test.push(2147483647);
		System.out.println(test.top());
		System.out.println(test.getMin());
		test.push(-2147483648);
		System.out.println(test.top());
		System.out.println(test.getMin());
		test.pop();
		System.out.println(test.getMin());
		
	}
	
    /** initialize your data structure here. */
    public MinStack() {
    	mStack = new Stack<>();
    	minStack= new Stack<>();
    }
    
    public void push(int x) {
        mStack.push(x);
        if(minStack.isEmpty() || x<=minStack.peek()) {
        	minStack.push(x);
        	min_value=x;
        }
    }
    
    public void pop() {
        int element = mStack.pop();
        if(element==minStack.peek()) {
        	minStack.pop();
        	if(!minStack.isEmpty())
        		min_value=minStack.peek();
        }	
    }
    
    public int top() {
        return mStack.peek();
    }
    
    public int getMin() {
        return min_value;
    }

}
