package interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeOverlappingIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> result = new ArrayList<>();
		intervals.sort(Comparator.comparingInt(a -> a.start));

		Interval current = null;
		for (Interval interval : intervals) {
			if (current == null) {
				current = interval;
			}
			if (current.end < interval.start) {
				result.add(current);
				current = interval;
			} else if (current.start > interval.end) {
				result.add(interval);
			} else {
				current.start = Math.min(current.start, interval.start);
				current.end = Math.max(current.end, interval.end);
			}
		}
		if (current != null) {
			result.add(current);
		}

		return result;
	}
}
