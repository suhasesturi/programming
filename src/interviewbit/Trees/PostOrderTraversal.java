package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				if (root.right != null)
					stack.push(root.right);
				stack.push(root);
				root = root.left;
			}
			TreeNode current = stack.pop();
			if (!stack.isEmpty() && current.right == stack.peek()) {
				stack.pop();
				stack.push(current);
				root = current.right;
			} else {
				result.add(current.val);
			}
		}
		return result;
	}
}
