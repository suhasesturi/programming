package interviewbit.Graphs;

import interviewbit.Trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(A);
		queue.add(null);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (A == null) return result;
		ArrayList<Integer> row = new ArrayList<>();

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			if (current == null) {
				result.add(row);
				if (!queue.isEmpty()) queue.add(null);
				row = new ArrayList<>();
			} else {
				row.add(current.val);
				if (current.left != null) {
					queue.add(current.left);
				}
				if (current.right != null) {
					queue.add(current.right);
				}
			}
		}
		return result;
	}
}
