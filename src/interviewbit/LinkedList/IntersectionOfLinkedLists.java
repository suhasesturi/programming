package interviewbit.LinkedList;

public class IntersectionOfLinkedLists {
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		int aSize = size(a);
		int bSize = size(b);
		if (aSize > bSize) {
			for (int i = 0; i < aSize - bSize; i++) a = a.next;
		} else {
			for (int i = 0; i < bSize - aSize; i++) b = b.next;
		}

		while (a != null && b != null) {
			if (a == b) return a;
			a = a.next;
			b = b.next;
		}
		return null;
	}

	private int size(ListNode A) {
		int count = 0;
		ListNode current = A;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
}
