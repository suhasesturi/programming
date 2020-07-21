package interviewbit.Trees;

public class IdenticalBinaryTrees {
	public int isSameTree(TreeNode A, TreeNode B) {
		return helper(A, B) ? 1 : 0;
	}

	private boolean helper(TreeNode a, TreeNode b) {
		if (a == null && b == null) return true;
		if (a == null) return false;
		if (b == null) return false;
		if (a.val != b.val) return false;
		return helper(a.left, b.left) && helper(a.right, b.right);
	}
}
