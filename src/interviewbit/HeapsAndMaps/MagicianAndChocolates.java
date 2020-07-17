package interviewbit.HeapsAndMaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MagicianAndChocolates {
	public int nchoc(int A, ArrayList<Integer> B) {
		if (B.isEmpty()) return 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		queue.addAll(B);

		long result = 0;
		while (A-- > 0) {
			int current = queue.poll();
			result = (result + current) % ((int) 1e9 + 7);
			queue.add(current / 2);
		}
		return (int) result;
	}
}
