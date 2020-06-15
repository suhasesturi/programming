package interviewbit.LinkedList;

public class SwapListNodesInPairs {
	public ListNode swapPairs(ListNode A) {
		ListNode next, previous = null, current = A;
		int n = 2;
		while (n-- > 0 && current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		if (current != null) {
			A.next = swapPairs(current);
		}

		return previous;
	}
}
