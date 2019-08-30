package interviewbit.LinkedList;

public class InsertionSortList {
    private ListNode sorted;

    public ListNode insertionSortList(ListNode A) {
        ListNode current = A;
        sorted = null;
        while (current != null) {
            ListNode next = current.next;
            insertNode(current);
            current = next;
        }
        return sorted;
    }

    private void insertNode(ListNode newNode) {
        if (sorted == null || sorted.val >= newNode.val) {
            newNode.next = sorted;
            sorted = newNode;
        } else {
            ListNode current = sorted;
            while (current.next != null && current.next.val < newNode.val) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
}
