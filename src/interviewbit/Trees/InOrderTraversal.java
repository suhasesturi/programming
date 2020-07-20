package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTraversal {
	public ArrayList<Integer> inorderTraversal(TreeNode current) {
		ArrayList<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || current != null) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			TreeNode temp = stack.pop();
			result.add(temp.val);
			current = temp.right;
		}
		return result;
	}
}
