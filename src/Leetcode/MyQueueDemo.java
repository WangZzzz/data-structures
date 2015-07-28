package Leetcode;

import java.util.LinkedList;

public class MyQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue myQueue = new MyQueue();
		myQueue.push(1);
		myQueue.push(2);
		System.out.println(myQueue.peek());

	}

	public static class MyQueue {
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		LinkedList<Integer> ll2 = new LinkedList<Integer>();

		public void push(int x) {
			ll1.offerFirst(x);
		}

		// Removes the element from in front of queue.
		public void pop() {
			if (ll2.isEmpty()) {
				while (!ll1.isEmpty()) {
					int tmp = ll1.pollFirst();
					ll2.offerFirst(tmp);
				}
			}

			if (ll2.size() == 0) {
				throw new RuntimeException();
			}

			ll2.pollFirst();
		}

		// Get the front element.
		public int peek() {
			if (ll2.isEmpty()) {
				while (!ll1.isEmpty()) {
					int tmp = ll1.pollFirst();
					ll2.offerFirst(tmp);
				}
			}

			if (ll2.size() == 0) {
				throw new RuntimeException();
			}

			return ll2.peekFirst();
		}

		// Return whether the queue is empty.
		public boolean empty() {
			return ll1.isEmpty() && ll2.isEmpty();
		}
	}
}
