package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MAXSPPROD {
	public static void main(String[] args) {
		System.out.println(new MAXSPPROD().maxSpecialProduct(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 3, 6))));
	}

	private static final int MOD = 1000000007;

	public int maxSpecialProduct(ArrayList<Integer> list) {
		long[] prods = new long[list.size()];
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		for (int i = 1; i < list.size(); i++) {
			while (!stack.isEmpty() && (list.get(stack.peek()) <= list.get(i))) stack.pop();

			if (!stack.isEmpty()) {
				prods[i] = stack.peek();
			}
			stack.push(i);
		}

		stack.clear();
		for (int i = list.size() - 1; i >= 0; i--) {
			while (!stack.isEmpty() && (list.get(stack.peek()) <= list.get(i))) stack.pop();

			if (!stack.isEmpty()) {
				prods[i] = stack.peek() * prods[i];
			} else {
				prods[i] = 0;
			}
			stack.push(i);
		}

		long result = 0;
		for (long prod : prods) {
			result = Math.max(result, prod);
		}
		return (int) (result % MOD);
	}
}
