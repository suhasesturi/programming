package interviewbit.Trees;

public class LeastCommonAncestor {
	public int lca(TreeNode A, int B, int C) {
		if (!find(A, B) || !find(A, C)) return -1;
		return helper(A, B, C).val;
	}

	private boolean find(TreeNode root, int x) {
		if (root == null) return false;
		if (root.val == x) return true;
		return find(root.left, x) || find(root.right, x);
	}

	private TreeNode helper(TreeNode root, int x, int y) {
		if (root == null) return null;
		if (root.val == x || root.val == y) return root;
		TreeNode left = helper(root.left, x, y);
		TreeNode right = helper(root.right, x, y);
		if (left != null && right != null) return root;
		return left == null ? right : left;
	}
}
