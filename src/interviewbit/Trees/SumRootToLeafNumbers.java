package interviewbit.Trees;

public class SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
        return sumTotal(root, 0);
	}

	private int sumTotal(TreeNode root, int sum) {
		if (root == null) return 0;
		sum = (sum * 10 + root.val) % 1003;
		if (root.left == null && root.right == null) return sum;
		return (sumTotal(root.left, sum) + sumTotal(root.right, sum)) % 1003;
	}
}
