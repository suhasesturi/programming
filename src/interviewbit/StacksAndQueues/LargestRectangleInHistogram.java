package interviewbit.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(ArrayList<Integer> A) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int result = 0;
		while (i < A.size()) {
			if (stack.isEmpty() || A.get(stack.peek()) <= A.get(i)) {
				stack.push(i);
			} else {
				int area = getArea(A, stack, i);
				result = Math.max(result, area);
			}
		}

		while (!stack.isEmpty()) {
			int area = getArea(A, stack, i);
			result = Math.max(result, area);
		}
		return result;
	}

	private int getArea(ArrayList<Integer> a, Stack<Integer> stack, int i) {
		int top = stack.pop();
		return a.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
	}
}
