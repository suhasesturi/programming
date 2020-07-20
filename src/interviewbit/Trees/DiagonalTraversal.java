package interviewbit.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {
	public ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(A);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			while (current != null) {
				result.add(current.val);
				if (current.left != null) {
					queue.add(current.left);
				}
				current = current.right;
			}
		}

		return result;
	}
}
