package interviewbit;

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
        Interval prev = newInterval;
        Interval current;

        for (Interval interval : intervals) {
            current = interval;
            if (prev.start < current.start) {
                if (prev.end < current.start) {
                    result.add(prev);
                    prev = current;
                } else {
                    prev.end = Math.max(prev.end, current.end);
                }
            } else if (prev.start <= current.end) {
                prev.start = current.start;
                prev.end = Math.max(prev.end, current.end);
            } else {
                result.add(current);
            }
        }

        result.add(prev);
        return result;
    }
}
