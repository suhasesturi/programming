package interviewbit.LinkedList;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode previous = new ListNode(0);
		ListNode head = previous;
		while (a != null && b != null) {
			if (a.val < b.val) {
				previous.next = a;
				a = a.next;
			} else {
				previous.next = b;
				b = b.next;
			}
			previous = previous.next;
		}
		if (a == null) {
			previous.next = b;
		} else {
			previous.next = a;
		}

		return head.next;
	}
}
