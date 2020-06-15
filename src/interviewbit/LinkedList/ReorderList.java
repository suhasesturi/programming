package interviewbit.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class ReorderList {
	public static void main(String[] args) {
		ListNode listNode = new ReorderList().reorderList(createList(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
		System.out.println();
	}

	public static ListNode createList(ArrayList<Integer> list) {
		ListNode current = new ListNode(0);
		ListNode head = current;
		for (Integer integer : list) {
			current.next = new ListNode(integer);
			current = current.next;
		}
		return head.next;
	}

	public ListNode reorderList(ListNode A) {
		ListNode slow = A, fast = A;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode mid = reverse(slow), head = A, current = null;
		boolean flag = true;
		while (head != null && mid != null) {
			if (flag) {
				slow = head.next;
				head.next = mid;
				current = mid;
				head = slow;
			} else {
				slow = mid.next;
				mid.next = head;
				current = head;
				mid = slow;
			}
			flag = !flag;
		}
		if (current != null) {
			current.next = null;
		}
		return A;
	}

	private ListNode reverse(ListNode a) {
		ListNode next, previous = null;
		while (a != null) {
			next = a.next;
			a.next = previous;
			previous = a;
			a = next;
		}
		return previous;
	}
}
