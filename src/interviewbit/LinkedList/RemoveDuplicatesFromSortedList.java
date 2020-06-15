package interviewbit.LinkedList;

public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode A) {
		if (A == null) return A;
		ListNode previous = A, current = A.next;

		while (current != null) {
			if (current.val != previous.val) {
				previous.next = current;
				previous = current;
			}
			current = current.next;
		}
		previous.next = null;
		return A;
	}
}
