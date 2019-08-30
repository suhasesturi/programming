package interviewbit.LinkedList;

public class KReverseLinkedList {
    public ListNode reverseList(ListNode A, int k) {
        ListNode previous = null;
        ListNode next = null;

        int tempK = k;
        ListNode current = A;
        while (tempK-- > 0 && current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (current != null) {
            A.next = reverseList(current, k);
        }

        return previous;
    }
}
