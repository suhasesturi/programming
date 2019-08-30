package lintcode;

import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        LinkedList<Interval> mergedIntervals = new LinkedList<>();

        for (Interval interval : intervals) {
            Interval lastInterval = mergedIntervals.isEmpty() ? null : mergedIntervals.getLast();
            if (mergedIntervals.isEmpty() || lastInterval.end < interval.start) {
                mergedIntervals.addLast(interval);
            } else {
                lastInterval.end = Math.max(lastInterval.end, interval.end);
            }
        }
        return mergedIntervals;
    }
}
