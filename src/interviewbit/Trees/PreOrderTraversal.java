package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode node) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				result.add(node.val);
				if (node.right != null) {
					stack.add(node.right);
				}
				node = node.left;
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
			}
		}
		return result;
	}
}
