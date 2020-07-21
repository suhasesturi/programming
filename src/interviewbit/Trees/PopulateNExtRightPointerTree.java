package interviewbit.Trees;

public class PopulateNExtRightPointerTree {
	public void connect(TreeLinkNode root) {
		while (root != null) {
			TreeLinkNode current = root;
			while (current != null) {
				if (current.left != null) {
					if (current.right != null)
						current.left.next = current.right;
					else
						current.left.next = findNextRight(current);
				}
				if (current.right != null) {
					current.right.next = findNextRight(current);
				}
				current = current.next;
			}
			if (root.left != null) root = root.left;
			else if (root.right != null) root = root.right;
			else root = findNextRight(root);
		}
	}

	private TreeLinkNode findNextRight(TreeLinkNode current) {
		current = current.next;
		while (current != null) {
			if (current.left != null) return current.left;
			if (current.right != null) return current.right;
			current = current.next;
		}
		return null;
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}