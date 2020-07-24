package interviewbit.Trees;

public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode A) {
        return maxDepth1(A, 1);
    }

    private int maxDepth1(TreeNode a, int depth) {
        if (a == null) return depth - 1;
        return Math.max(maxDepth1(a.left, depth + 1), maxDepth1(a.right, depth + 1));
    }
}
