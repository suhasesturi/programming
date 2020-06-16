package interviewbit.LinkedList;

public class PartitionList {
	public ListNode partition(ListNode A, int B) {
		ListNode head = new ListNode(0);
		ListNode head2 = new ListNode(0);

		ListNode current = A, smaller = head, greater = head2;
		while (current != null) {
			if (current.val < B) {
				smaller.next = current;
				smaller = current;
			} else {
				greater.next = current;
				greater = current;
			}
			current = current.next;
		}
		greater.next = null;
		smaller.next = head2.next;
		return head.next;
	}
}
