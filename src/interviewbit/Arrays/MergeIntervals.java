package interviewbit.Arrays;

import java.util.ArrayList;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class MergeIntervals {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<>();
		boolean flag = false;
		for (Interval current : intervals) {
			if (newInterval.end >= current.start && newInterval.start <= current.end) {
				newInterval.start = Math.min(current.start, newInterval.start);
				newInterval.end = Math.max(current.end, newInterval.end);
			} else if (newInterval.end < current.start) {
				if (!flag) {
					result.add(newInterval);
					flag = true;
				}
				result.add(current);
			} else {
				result.add(current);
			}
		}
		if (!flag) {
			result.add(newInterval);
		}

		return result;
	}
}
