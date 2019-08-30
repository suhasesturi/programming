package interviewbit.Heaps;

import interviewbit.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        PriorityQueue<ListNode> topValues = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        topValues.addAll(lists);
        ListNode temp = new ListNode(0);
        ListNode current = temp;

        while (!topValues.isEmpty()) {
            current.next = topValues.poll();
            if (current.next.next != null) {
                topValues.add(current.next.next);
            }
            current = current.next;
        }

        return temp.next;
    }
}
