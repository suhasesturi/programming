package interviewbit.Trees;

import java.util.Stack;

public class RemoveHalfNodes {
	public TreeNode solve(TreeNode root) {
		if (root == null) return null;
		TreeNode left  = solve(root.left);
		TreeNode right = solve(root.right);

		if ((left != null && right != null) || (left == null && right == null)) {
			root.left = left;
			root.right = right;
			return root;
		} else if (root.left != null) {
			return left;
		} else {
			return right;
		}
	}
}
