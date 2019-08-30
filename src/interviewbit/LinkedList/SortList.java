package interviewbit.LinkedList;

public class SortList {
    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) return A;

        ListNode middle = getMiddle(A);
        ListNode nextToMiddle = middle.next;
        middle.next = null;

        ListNode left = sortList(A);
        ListNode right = sortList(nextToMiddle);

        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode result = new ListNode(0);

        ListNode current = result;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        if (a == null) current.next = b;
        else current.next = a;

        return result.next;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }

        return slow;
    }
}



