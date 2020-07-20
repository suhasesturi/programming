package interviewbit.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversalOfBinaryTree {
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		leftMost(A, 0);

		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(A, -minimum));
		while (!queue.isEmpty()) {
			Pair current = queue.poll();
			if (current.node == null) continue;
			while (result.size() <= current.column) {
				result.add(new ArrayList<>());
			}
			result.get(current.column).add(current.node.val);
			queue.add(new Pair(current.node.left, current.column - 1));
			queue.add(new Pair(current.node.right, current.column + 1));
		}
		return result;
	}

	static class Pair {
		TreeNode node;
		int column;

		Pair(TreeNode node, int column) {
			this.node = node;
			this.column = column;
		}
	}

	private int minimum = 0;

	private void leftMost(TreeNode node, int column) {
		if (node == null) return;
		minimum = Math.min(minimum, column);
		leftMost(node.left, column - 1);
		leftMost(node.right, column + 1);
	}
}
