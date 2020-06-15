package interviewbit.LinkedList;

public class ListCycle {
	public ListNode detectCycle(ListNode a) {
		if (a == null || a.next == null) return null;
		ListNode first = a, second = a;
		while (second != null && second.next != null) {
			first = first.next;
			second = second.next.next;
			if (first == second) {
				int lengthOfCircle = 1;
				first = first.next;
				while (first != second) {
					lengthOfCircle++;
					first = first.next;
				}

				first = a;
				while (lengthOfCircle-- > 0) {
					first = first.next;
				}

				second = a;
				while (first != second) {
					first = first.next;
					second = second.next;
				}

				return first;
			}
		}
		return null;
	}
}
