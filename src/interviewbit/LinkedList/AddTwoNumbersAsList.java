package interviewbit.LinkedList;

import java.util.ArrayList;
import java.util.Arrays;

public class AddTwoNumbersAsList {
	public static void main(String[] args) {
		ListNode result = new AddTwoNumbersAsList().addTwoNumbers(
				ReorderList.createList(new ArrayList<>(Arrays.asList(1, 0))),
				ReorderList.createList(new ArrayList<>(Arrays.asList(9, 9, 9)))
		);
		System.out.println();
	}

	public ListNode addTwoNumbers(ListNode A, ListNode B) {
		int carry = 0, sum;
		ListNode previous = null, head = A;
		while (A != null && B != null) {
			sum = carry + A.val + B.val;
			A.val = sum % 10;
			carry = sum / 10;
			previous = A;
			A = A.next;
			B = B.next;
		}
		ListNode current = (A == null) ? B : A;
		if (previous != null) {
			previous.next = current;
		} else {
			head = current;
		}

		while (current != null) {
			previous = current;
			sum = carry + current.val;
			current.val = sum % 10;
			carry = sum / 10;
			current = current.next;
		}

		if (carry != 0) {
			previous.next = new ListNode(carry);
		}

		head = reverse(head);
		while (head != null && head.val == 0) {
			head = head.next;
		}

		return reverse(head);
	}

	private ListNode reverse(ListNode current) {
		ListNode next, previous = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
}
