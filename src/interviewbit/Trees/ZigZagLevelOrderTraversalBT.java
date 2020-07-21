package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrderTraversalBT {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(A);
		while (!queue.isEmpty()) {
			int n = queue.size();
			ArrayList<Integer> row = new ArrayList<>();
			while (n-- > 0) {
				TreeNode current = queue.poll();
				row.add(current.val);
				if (current.left != null)
					queue.add(current.left);
				if (current.right != null)
					queue.add(current.right);
			}
			result.add(row);
		}
		for (int i = 0; i < result.size(); i++) {
			if (i % 2 == 1) Collections.reverse(result.get(i));
		}
		return result;
	}
}
