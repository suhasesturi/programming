package interviewbit.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode A, int B, int C) {
		ListNode previous = null, current = A;
		for (int i = 1; i < B; i++) {
			previous = current;
			current = current.next;
		}

		ListNode last = current;
		ArrayList<ListNode> nodes = reverse(current, C - B + 1);
		last.next = nodes.get(1);
		if (previous == null) {
			return nodes.get(0);
		}
		previous.next = nodes.get(0);
		return A;
	}

	private ArrayList<ListNode> reverse(ListNode a, int n) {
		ListNode next, previous = null, current = a;
		while (n-- > 0) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return new ArrayList<>(Arrays.asList(previous, current));
	}
}
