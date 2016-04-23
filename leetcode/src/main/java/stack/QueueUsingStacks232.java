package stack;

import java.util.Stack;

/**
 * Created by matt on 4/23/16.
 */
public class QueueUsingStacks232 {
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		QueueUsingStacks232 queue = new QueueUsingStacks232();
		queue.push(1);
		queue.push(2);
		System.out.println(stack.empty());
	}

	public void push(int x) {
		stack1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		peek();
		stack2.pop();
	}

	// Get the front element.
	public int peek() {
		if (stack2.empty()) {
			while (!stack1.empty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack1.empty() && stack2.empty();
	}
}
