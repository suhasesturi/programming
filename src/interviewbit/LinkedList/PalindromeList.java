package interviewbit.LinkedList;

public class PalindromeList {
	public static void main(String[] args) {

		System.out.println(new PalindromeList().lPalin(new ListNode(1, new ListNode(2, new ListNode(3)))));
	}

	public int lPalin(ListNode A) {
		int count = 0;
		ListNode current = A;
		while (current != null) {
			count++;
			current = current.next;
		}
		int nextMid = (count + 1) / 2 + 1;

		current = A;
		for (int i = 1; i < nextMid; i++) {
			current = current.next;
		}

		ListNode next;
		ListNode previous = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		current = A;
		while (current != null && previous != null) {
			if (current.val != previous.val) return 0;
			current = current.next;
			previous = previous.next;
		}
		return 1;
	}
}
