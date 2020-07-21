package interviewbit.Trees;

public class SymmetricBinaryTree {
	public int isSymmetric(TreeNode A) {
		if (A == null) return 1;
		return helper(A.left, A.right) ? 1 : 0;
	}

	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null || right == null || left.val != right.val) return false;
		return helper(left.left, right.right) && helper(left.right, right.left);
	}
}
