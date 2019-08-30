package lintcode;


import java.util.ArrayList;
import java.util.List;

public class LC30 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if (intervals.isEmpty()) {
            result.add(newInterval);
            return result;
        }

        if (intervals.get(0).start > newInterval.end) {
            result.add(newInterval);
            result.addAll(intervals);
            return result;
        }

        int n = intervals.size();
        if (intervals.get(n - 1).end < newInterval.start) {
            result.addAll(intervals);
            result.add(newInterval);
            return result;
        }

        if (newInterval.start <= intervals.get(0).start && newInterval.end >= intervals.get(n - 1).end) {
            result.add(newInterval);
            return result;
        }

        boolean overlap;
        for (int i = 0; i < n; i++) {
            overlap = doesOverlap(intervals.get(i), newInterval);
            if (!overlap) {
                result.add(intervals.get(i));
                if (i < n - 1 &&
                        intervals.get(i).end < newInterval.start &&
                        intervals.get(i + 1).start > newInterval.end) {
                    result.add(newInterval);
                }
                continue;
            }
            int start = Math.min(intervals.get(i).start, newInterval.start);
            int end = 0;
            while (i < n && overlap) {
                end = Math.max(intervals.get(i).end, newInterval.end);
                if (i == n - 1)
                    overlap = false;
                else
                    overlap = doesOverlap(intervals.get(i + 1), newInterval);
                i++;
            }
            i--;
            result.add(new Interval(start, end));
        }
        return result;
    }

    private boolean doesOverlap(Interval first, Interval second) {
        return Math.min(first.end, second.end) >= Math.max(first.start, second.start);
    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
