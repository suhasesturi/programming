package interviewbit.Trees;

import java.util.ArrayList;

public class RightViewOfBinaryTree {
	public ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> result = new ArrayList<>();
		generate(A, result, 0);
		return result;
	}

	private void generate(TreeNode node, ArrayList<Integer> result, int height) {
		if (node == null) return;
		while (result.size() <= height) {
			result.add(0);
		}
		result.set(height, node.val);
		generate(node.left, result, height + 1);
		generate(node.right, result, height + 1);
	}

}
