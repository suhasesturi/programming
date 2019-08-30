package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class SearchForARange {
    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(leftMost(a, b));
        result.add(rightMost(a, b));
        return result;
    }

    private int leftMost(List<Integer> a, int b) {
        int start = 0, end = a.size() - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (a.get(mid) < b) start = mid + 1;
            else if (a.get(mid) > b) end = mid - 1;
            else end = mid;
        }
        return start < a.size() && a.get(start) == b ? start : -1;
    }

    private int rightMost(List<Integer> a, int b) {
        int start = 0, end = a.size() - 1;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (a.get(mid) < b) start = mid + 1;
            else if (a.get(mid) > b) end = mid - 1;
            else start = mid;
        }
        return start < a.size() && a.get(start) == b ? start : -1;
    }
}
