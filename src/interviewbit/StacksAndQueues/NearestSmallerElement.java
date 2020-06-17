package interviewbit.StacksAndQueues;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerElement {
	public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> result = new ArrayList<>();
		for (Integer integer : A) {
			while (!stack.isEmpty() && stack.peek() >= integer) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				result.add(-1);
			} else {
				result.add(stack.peek());
			}
			stack.push(integer);
		}
		return result;
	}
}
