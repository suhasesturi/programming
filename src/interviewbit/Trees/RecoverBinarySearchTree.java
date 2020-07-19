package interviewbit.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RecoverBinarySearchTree {
	public ArrayList<Integer> recoverTree(TreeNode root) {
		TreeNode predecessor, pred = null, x = null, y = null;
		while (root != null) {
			if (root.left != null) {
				predecessor = root.left;
				while (predecessor.right != null && predecessor.right != root) {
					predecessor = predecessor.right;
				}
				if (predecessor.right == null) {
					predecessor.right = root;
					root = root.left;
				} else {
					if (pred != null && pred.val > root.val) {
						y = root;
						if (x == null) x = pred;
					}
					pred = root;
					predecessor.right = null;
					root = root.right;
				}
			} else {
				if (pred != null && pred.val > root.val) {
					y = root;
					if (x == null) x = pred;
				}
				pred = root;
				root = root.right;
			}
		}

		ArrayList<Integer> result = new ArrayList<>(Arrays.asList(x.val, y.val));
		Collections.sort(result);
		return result;
	}
}
