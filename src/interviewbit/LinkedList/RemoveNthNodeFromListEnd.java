package interviewbit.LinkedList;

public class RemoveNthNodeFromListEnd {
	public ListNode removeNthFromEnd(ListNode A, int B) {
		if (A == null || B <= 0) return A;
		int n = size(A) - B;
		ListNode previous = null, current = A;
		for (int i = 0; i < n; i++) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			return current.next;
		} else {
			previous.next = current.next;
		}
		return A;
	}

	private int size(ListNode node) {
		int count = 0;
		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}
}
