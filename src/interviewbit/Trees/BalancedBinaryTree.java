package interviewbit.Trees;

public class BalancedBinaryTree {
	public int isBalanced(TreeNode A) {
		return solve(A, 0)[1];
	}

	private int[] solve(TreeNode root, int height) {
		if (root == null) return new int[]{height - 1, 1};
		int[] left = solve(root.left, height + 1);
		int[] right = solve(root.right, height + 1);
		if (left[1] == 1 && right[1] == 1 && Math.abs(left[0] - right[0]) <= 1) {
			return new int[]{Math.max(left[0], right[0]), 1};
		} else {
			return new int[]{Math.max(left[0], right[0]), 0};
		}
	}
}
