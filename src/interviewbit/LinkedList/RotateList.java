package interviewbit.LinkedList;

public class RotateList {
	public ListNode rotateRight(ListNode A, int B) {
		if (A == null) return A;

		int n = size(A);
		B %= n;
		if (B == 0) return A;

		ListNode previous = null, current = A;
		for (int i = 0; i < n - B; i++) {
			previous = current;
			current = current.next;
		}

		ListNode head = A;
		if (previous != null) {
			previous.next = null;
			head = current;
			while (current != null) {
				previous = current;
				current = current.next;
			}
			previous.next = A;
		}
		return head;
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
