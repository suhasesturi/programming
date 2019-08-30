package interviewbit.LinkedList;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode A) {
        if (A == null) return A;
        ListNode head = A;
        ListNode pointer = A;
        while (A.next != null) {
            if (A.next.val != pointer.val) {
                pointer.next = A.next;
                pointer = pointer.next;
            }
            A = A.next;
        }
        pointer.next = null;

        return head;
    }
}