package interviewbit.LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode A) {
        ListNode previous = null;
        ListNode next = null;
        ListNode current = A;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}