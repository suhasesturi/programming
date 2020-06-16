package interviewbit.LinkedList;

public class SortList {
	public ListNode sortList(ListNode A) {
		if (A == null || A.next == null) return A;
		ListNode middle = getMiddle(A);
		ListNode middleNext = middle.next;
		middle.next = null;

		ListNode left = sortList(A);
		ListNode right = sortList(middleNext);
		return merge(left, right);
	}

	private ListNode merge(ListNode first, ListNode second) {
		ListNode head = new ListNode(0);
		ListNode prev = head;
		while (first != null && second != null) {
			if (first.val < second.val) {
				prev.next = first;
				first = first.next;
			} else {
				prev.next = second;
				second = second.next;
			}
			prev = prev.next;
		}
		if (first == null) prev.next = second;
		else prev.next = first;
		return head.next;
	}

	private ListNode getMiddle(ListNode head) {
		ListNode fast = head.next, slow = head;
        while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
		}
        return slow;
	}
}
