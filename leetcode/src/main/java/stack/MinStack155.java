package stack;

import java.util.Stack;

/**
 * Created by matt on 5/17/16.
 */
public class MinStack155 {
	Stack<Integer> stack = new Stack();
	Stack<Integer> minStack = new Stack();

	public void push(int x) {
		stack.push(x);
		int min;
		if (minStack.empty()) {
			min = Integer.MAX_VALUE;
		} else {
			min = minStack.peek();
		}
		min = Math.min(min, x);
		minStack.push(min);
	}

	public void pop() {
		stack.pop();
		minStack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}
}
