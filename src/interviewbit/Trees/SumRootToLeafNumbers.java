package interviewbit.Trees;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return pathSum(root, 0);
    }

    private int pathSum(TreeNode root, int result) {
        if (root == null) return 0;

        result = (result * 10 + root.val) % 1003;

        if (root.left == null && root.right == null) return result;

        return (pathSum(root.left, result) + pathSum(root.right, result)) % 1003;
    }
}
