package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeTwoSortedListsII {
	public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(b);
		for (int i = 0; i < a.size(); i++) {
			pq.add(a.get(i));
			a.set(i, pq.poll());
		}
		while (!pq.isEmpty()) {
			a.add(pq.poll());
		}
	}
}
