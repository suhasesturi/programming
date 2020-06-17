package interviewbit.StacksAndQueues;

import java.util.Stack;

public class MinStack {
	private final Stack<Integer> elements = new Stack<>();
	private final Stack<Integer> minimum = new Stack<>();

	public void push(int x) {
		if (minimum.isEmpty() || x <= minimum.peek()) {
			minimum.push(x);
		}
		elements.push(x);
	}

	public void pop() {
		if (!elements.isEmpty()) {
			Integer pop = elements.pop();
			if (!minimum.isEmpty() && minimum.peek().equals(pop)) {
				minimum.pop();
			}
		}
	}

	public int top() {
		return elements.isEmpty() ? -1 : elements.peek();
	}

	public int getMin() {
		return minimum.isEmpty() ? -1 : minimum.peek();
	}
}
