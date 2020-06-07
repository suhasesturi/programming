package leetcode.june2020;

public class InvertBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4,
				new TreeNode(2, new TreeNode(1), new TreeNode(3)),
				new TreeNode(7, new TreeNode(6), new TreeNode(9)));
		new InvertBinaryTree().invertTree(root);
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) return null;
		TreeNode leftReverse = invertTree(root.right);
		TreeNode rightReverse = invertTree(root.left);
		root.left = leftReverse;
		root.right = rightReverse;
		return root;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
