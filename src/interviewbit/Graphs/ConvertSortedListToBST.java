package interviewbit.Graphs;

import interviewbit.LinkedList.ListNode;
import interviewbit.Trees.TreeNode;

public class ConvertSortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        ListNode middle = getMiddle(head);
        ListNode nextToMiddle = middle.next;

        if (nextToMiddle == null) {
            return new TreeNode(middle.val);
        }
        middle.next = null;

        TreeNode root = new TreeNode(nextToMiddle.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(nextToMiddle.next);
        return root;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode previous = head;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                previous = slow;
                slow = slow.next;
            }
        }

        return previous;
    }
}
