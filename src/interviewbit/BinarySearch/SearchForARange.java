package interviewbit.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForARange {
    public ArrayList<Integer> searchRange(final List<Integer> list, int x) {
        return new ArrayList<>(Arrays.asList(
                startIndex(list, x),
                endIndex(list, x)
        ));
    }

    private int endIndex(List<Integer> list, int x) {
        int a = 0, b = list.size() - 1;
        while (a < b) {
            int mid = (a + b + 1) / 2;
            if (list.get(mid) <= x) a = mid;
            else b = mid - 1;
        }
        return list.get(a) == x ? a : -1;
    }

    private int startIndex(List<Integer> list, int x) {
        int a = 0, b = list.size() - 1;
        while (a < b) {
            int mid = (a + b) / 2;
            if (list.get(mid) >= x) b = mid;
            else a = mid + 1;
        }
        return list.get(b) == x ? b : -1;
    }
}
