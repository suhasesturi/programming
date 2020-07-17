package interviewbit.HeapsAndMaps;

import interviewbit.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
		priorityQueue.addAll(lists);

		ListNode head = new ListNode(0);
		ListNode current = head;
		while (!priorityQueue.isEmpty()) {
			ListNode smallest = priorityQueue.poll();
			current.next = smallest;
			current = current.next;

			if (smallest.next != null) {
				priorityQueue.add(smallest.next);
			}
		}
		return head.next;
	}
}

