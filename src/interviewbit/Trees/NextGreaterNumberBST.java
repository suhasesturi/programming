package interviewbit.Trees;

public class NextGreaterNumberBST {
	public TreeNode getSuccessor(TreeNode root, int b) {
		TreeNode current = find(root, b);
		if (current == null) return null;

		if (current.right != null) {
			return minimum(current.right);
		} else {
			 TreeNode successor = null, ancestor = root;
			 while (ancestor != current) {
			 	if (current.val < ancestor.val) {
			 		successor = ancestor;
			 		ancestor = ancestor.left;
				} else {
			 		ancestor = ancestor.right;
				}
			 }
			 return successor;
		}
	}

	private TreeNode minimum(TreeNode node) {
		if (node == null) return null;
		while (node.left != null) node = node.left;
		return node;
	}

	private TreeNode find(TreeNode node, int val) {
		if (node == null || node.val == val) return node;
		if (val < node.val) return find(node.left, val);
		return find(node.right, val);
	}
}
