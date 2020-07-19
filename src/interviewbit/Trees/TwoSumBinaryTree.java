package interviewbit.Trees;

import java.util.Stack;

public class TwoSumBinaryTree {
	public static void main(String[] args) {
		TreeNode one = new TreeNode(10);
		one.left = new TreeNode(9);
		one.right = new TreeNode(20);
		System.out.println(new TwoSumBinaryTree().t2Sum(one, 40));
	}

	public int t2Sum(TreeNode root, int k) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();

		TreeNode current1 = root, current2 = root;
		int val1 = -1, val2 = -1;
		boolean done1 = false, done2 = false;
		while (true) {
			while (!done1) {
				if (current1 != null) {
					s1.push(current1);
					current1 = current1.left;
				} else {
					if (s1.isEmpty()) done1 = true;
					else {
						TreeNode temp = s1.pop();
						val1 = temp.val;
						current1 = temp.right;
						done1 = true;
					}
				}
			}

			while (!done2) {
				if (current2 != null) {
					s2.push(current2);
					current2 = current2.right;
				} else {
					if (s2.isEmpty()) done2 = true;
					else {
						TreeNode temp = s2.pop();
						val2 = temp.val;
						current2 = temp.left;
						done2 = true;
					}
				}
			}
			if (val1 >= val2) return 0;
			if (val1 + val2 == k) return 1;
			if (val1 + val2 < k) done1 = false;
			else if (val1 + val2 > k) done2 = false;
		}
	}
}
 