package interviewbit.Trees;

import java.util.ArrayList;


public class PathToGivenNode {
	public ArrayList<Integer> solve(TreeNode root, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		solve2(root, k, result);
		for (int i = 0, j = result.size() - 1; i < j; i++, j--) {
			result.set(i, result.set(j, result.get(i)));
		}
		return result;
	}

	private boolean solve2(TreeNode root, int k, ArrayList<Integer> result) {
		if (root == null) return false;
		if (root.val == k || solve2(root.left, k, result) || solve2(root.right, k, result)) {
			result.add(root.val);
			return true;
		}
		return false;
	}
}
