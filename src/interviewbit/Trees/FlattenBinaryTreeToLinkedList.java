package interviewbit.Trees;

public class FlattenBinaryTreeToLinkedList {
	public TreeNode flatten(TreeNode root) {
		if (root == null) return null;
		return helper(root)[0];
	}

	public TreeNode[] helper(TreeNode root) {
		TreeNode[] result = new TreeNode[2];
		result[0] = root;
		if (root.left == null && root.right == null) result[1] = root;
		else if (root.left == null) result[1] = helper(root.right)[1];
		else if (root.right == null) {
			TreeNode[] left = helper(root.left);
			root.right = left[0];
			root.left = null;
			result[1] = left[1];
		} else {
			TreeNode[] left = helper(root.left);
			root.left = null;
			left[1].right = root.right;
			root.right = left[0];
			result[1] = helper(root.right)[1];
		}
		return result;
	}
}
