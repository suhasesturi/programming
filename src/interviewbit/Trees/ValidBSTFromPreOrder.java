package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class ValidBSTFromPreOrder {
	public int solve(ArrayList<Integer> A) {
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MIN_VALUE;
		for (Integer integer : A) {
			if (root > integer) return 0;
			while (!stack.isEmpty() && stack.peek() < integer) {
				root = stack.pop();
			}
			stack.push(integer);
		}
		return 1;
	}
}
