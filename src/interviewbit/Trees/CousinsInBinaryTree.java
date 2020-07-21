package interviewbit.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CousinsInBinaryTree {
	public ArrayList<Integer> solve(TreeNode A, int B) {
		ArrayList<Integer> result = new ArrayList<>();
		if (A == null || A.val == B) return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(A);
		queue.add(null);
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			if (current == null) {
				if (!queue.isEmpty())
					queue.add(null);
				continue;
			}
			if ((current.left != null && current.left.val == B) ||
					(current.right != null && current.right.val == B)) {
				while (!queue.isEmpty() && queue.peek() != null) {
					current = queue.poll();
					if (current.left != null) {
						queue.add(current.left);
					}
					if (current.right != null) {
						queue.add(current.right);
					}
				}
				break;
			}
			if (current.left != null) {
				queue.add(current.left);
			}
			if (current.right != null) {
				queue.add(current.right);
			}
		}

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			if (current != null) result.add(current.val);
		}
		return result;
	}
}
