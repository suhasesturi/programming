package interviewbit.LinkedList;

public class ListCycle {
    public ListNode detectCycle(ListNode a) {
        if (a == null || a.next == null) return null;

        ListNode first = a;
        ListNode second = a.next.next;

        while (first != second && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        if (first != second) return null;
        int lengthOfCircle = 0;
        second = first.next;
        while (first != second) {
            lengthOfCircle++;
            second = second.next;
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




