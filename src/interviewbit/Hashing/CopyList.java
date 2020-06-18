package interviewbit.Hashing;

import java.util.HashMap;

public class CopyList {
	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode current = head;
		RandomListNode newHead = new RandomListNode(0);
		RandomListNode result = newHead;

		while (current != null) {
			newHead.next = new RandomListNode(current.label);
			map.put(current, newHead.next);
			current = current.next;
			newHead = newHead.next;
		}

		current = head;
		while (current != null) {
			map.get(current).random = map.get(current.random);
			current = current.next;
		}
		return result.next;
	}

	static class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	}
}
