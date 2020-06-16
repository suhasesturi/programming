package interviewbit.LinkedList;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode A) {
		ListNode current = A, next, head = A;
		while (current != null) {
			next = current.next;
			head = insert(head, current);
			current = next;
		}
		return head;
	}

	public ListNode insert(ListNode root, ListNode node) {
		ListNode head = new ListNode(0);
		ListNode head2 = new ListNode(0);

		ListNode current = root, smaller = head, greater = head2;
		while (current != node) {
			if (current.val < node.val) {
				smaller.next = current;
				smaller = current;
			} else if (current.val > node.val){
				greater.next = current;
				greater = current;
			}
			current = current.next;
		}
		greater.next = node.next;
		smaller.next = node;
		node.next = head2.next;
		return head.next;
	}
}
