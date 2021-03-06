package interviewbit.LinkedList;

public class KReverseLinkedList {
	public ListNode reverseList(ListNode A, int B) {
		ListNode next, previous = null, current = A;
		int n = B;
		while (n-- > 0 && current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		if (current != null) {
			A.next = reverseList(current, B);
		}

		return previous;
	}
}
