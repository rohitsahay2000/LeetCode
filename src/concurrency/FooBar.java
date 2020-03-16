/*
 * Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.

 

Example 1:

Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
Example 2:

Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.
 * 
 * 
 */


package com.rohit.concurrency;

public class FooBar {

	private int n;
	
	private volatile boolean isFoo=true;

	public FooBar(int n) {
		this.n = n;
	}

	public void foo(Runnable printFoo) throws InterruptedException {

		for (int i = 0; i < n; i++) {

			// printFoo.run() outputs "foo". Do not change or remove this line.
			while(!isFoo) {
				Thread.yield(); // just added this line to which 
				               // basically means that the thread is not doing anything particularly important 
				               // and if any other threads or processes need to be run, they should run. 
				               // Otherwise, the current thread will continue to run.
			}
			
			printFoo.run();
			isFoo=false;
		}
	}

	public void bar(Runnable printBar) throws InterruptedException {

		for (int i = 0; i < n; i++) {

			// printBar.run() outputs "bar". Do not change or remove this line.
			while(isFoo) {
				Thread.yield();
			}			
			printBar.run();
			isFoo=true;
		}
	}

}
