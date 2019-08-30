package interviewbit.Trees;

public class InvertTheBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }

    private TreeNode invert(TreeNode root) {
        if (root == null) return null;

        TreeNode left = invert(root.right);
        TreeNode right = invert(root.left);

        root.left = left;
        root.right = right;
        return root;
    }
}
