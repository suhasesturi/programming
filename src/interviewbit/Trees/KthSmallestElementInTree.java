package interviewbit.Trees;

import java.util.Stack;

public class KthSmallestElementInTree {
	public int kthsmallest(TreeNode A, int B) {
		Stack<TreeNode> stack = new Stack<>();
		while (A != null) {
			stack.push(A);
			A = A.left;
		}

		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			B--;
			if (B == 0) return current.val;
			if (current.right != null) {
				current = current.right;
				while (current != null) {
					stack.push(current);
					current = current.left;
				}
			}
		}

		return -1;
	}
}
