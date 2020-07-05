package interviewbit.Backtracking;

import interviewbit.LinkedList.ListNode;

public class ReverseLinkedListRecursion {
	public ListNode reverseList(ListNode node) {
		if (node == null || node.next == null) return node;
		ListNode reverse = reverseList(node.next);
		node.next.next = node;
		node.next = null;
		return reverse;
	}
}
