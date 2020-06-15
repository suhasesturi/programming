package interviewbit.LinkedList;

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode A) {
		if (A == null) return A;
		ListNode previous = A, current = A, oneBefore = null;
		int count = 0;
		while (current != null) {
			if (current.val != previous.val) {
				if (count == 1) {
					if (oneBefore == null) {
						A = previous;
					} else {
						oneBefore.next = previous;
					}
					oneBefore = previous;
				}
				count = 1;
				previous = current;
			} else {
				count++;
			}
			current = current.next;
		}

		if (count == 1) {
			if (oneBefore == null) {
				A = previous;
			} else {
				oneBefore.next = previous;
			}
			previous.next = null;
		} else {
			if (oneBefore == null) {
				A = null;
			} else {
				oneBefore.next = null;
			}
		}

		return A;
	}
}
