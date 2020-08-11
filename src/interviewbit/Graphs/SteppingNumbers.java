package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SteppingNumbers {
	public ArrayList<Integer> stepnum(int low, int high) {
		ArrayList<Integer> result = new ArrayList<>();
		if (low > high) return result;

		if (low == 0) result.add(0);
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < 10; i++) queue.add(i);
		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current < high) {
				int last = current % 10;
				if (last > 0) queue.add(current * 10 + last - 1);
				if (last < 9) queue.add(current * 10 + last + 1);
			}
			if (current >= low && current <= high) {
				result.add(current);
			}
		}
		return result;
	}
}
