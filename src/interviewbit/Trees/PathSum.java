package interviewbit.Trees;

public class PathSum {
    public int hasPathSum(TreeNode root, int B) {
        if (root == null) return 0;

        if (root.left == null && root.right == null && root.val == B) return 1;
        if (hasPathSum(root.left, B - root.val) == 1) return 1;
        if (hasPathSum(root.right, B - root.val) == 1) return 1;
        return 0;
    }
}
