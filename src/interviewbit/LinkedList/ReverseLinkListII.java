package interviewbit.LinkedList;

public class ReverseLinkListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode beforeM = null;

        ListNode prev = null;
        ListNode next = null;
        ListNode current = head;

        for (int i = 1; i < m; i++) {
            beforeM = current;
            current = current.next;
        }

        int i = m;
        ListNode atM = current;
        while (current != null && i <= n) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }

        atM.next = current;

        if (beforeM == null && prev == null) return head;
        else if (beforeM == null) return prev;
        else beforeM.next = prev;

        return head;
    }
}
