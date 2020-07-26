package interviewbit.Greedy;

import java.util.ArrayList;
import java.util.Collections;

public class MeetingRooms {
	public int solve(ArrayList<ArrayList<Integer>> A) {
		int result = Integer.MIN_VALUE;
		int count = 0;
		ArrayList<Integer> start = new ArrayList<>();
		ArrayList<Integer> end = new ArrayList<>();
		for (ArrayList<Integer> timings : A) {
			start.add(timings.get(0));
			end.add(timings.get(1));
		}
		Collections.sort(start);
		Collections.sort(end);

		for (int i = 0, j = 0; i < start.size() && j < end.size(); ) {
			if (start.get(i) < end.get(j)) {
				count++;
				i++;
			} else if (end.get(j) < start.get(i)) {
				count--;
				j++;
			} else {
				if (count == 0) {
					count++;
					i++;
				} else {
					count--;
					j++;
				}
			}
			result = Math.max(result, count);
		}
		return result;
	}
}
