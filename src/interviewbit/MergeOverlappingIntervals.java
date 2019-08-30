package interviewbit;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals.isEmpty()) return intervals;

        intervals.sort(Comparator.comparingInt(a -> a.start));

        ArrayList<Interval> result = new ArrayList<>();
        Interval previous = intervals.get(0);
        for (Interval current : intervals) {
            if (previous.end < current.start) {
                result.add(previous);
                previous = current;
            } else if (previous.end <= current.end) {
                previous.end = current.end;
            }
        }
        result.add(previous);

        return result;
    }
}
