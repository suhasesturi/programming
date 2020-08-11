package interviewbit.Graphs;

import interviewbit.LinkedList.ListNode;
import interviewbit.Trees.TreeNode;

public class ConvertSortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		ListNode middle = getMiddle(head);
		if (middle.next == null) {
			return new TreeNode(middle.val);
		}

		TreeNode node = new TreeNode(middle.next.val);
		node.right = sortedListToBST(middle.next.next);
		middle.next = null;
		node.left = sortedListToBST(head);
		return node;
	}

	private ListNode getMiddle(ListNode head) {
		ListNode slow = head, fast = head, previous = head;
		while (fast != null && fast.next != null) {
			previous = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return previous;
	}
}
