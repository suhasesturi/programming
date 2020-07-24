package interviewbit.Trees;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        if (node.left == null && node.right == null) return 1;
        return Math.min(minDepth(node.left), minDepth(node.right)) + 1;
    }
}
