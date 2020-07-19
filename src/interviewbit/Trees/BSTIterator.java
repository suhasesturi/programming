package interviewbit.Trees;

import java.util.Stack;

public class BSTIterator {
	private final Stack<TreeNode> stack;
	private TreeNode root;

	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		this.root = root;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return root != null || !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		TreeNode temp = stack.pop();
		root = temp.right;
		return temp.val;
	}
}
