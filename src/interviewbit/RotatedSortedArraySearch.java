package interviewbit;

import java.util.ArrayList;
import java.util.List;

public class RotatedSortedArraySearch {
    public int search(final List<Integer> a, int b) {
        int start = 0, end = a.size() - 1;
        int pivot = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid > 0 && a.get(mid) < a.get(mid - 1)) {
                pivot = mid;
                break;
            }
            if (a.get(0) < a.get(mid)) start = mid + 1;
            else end = mid - 1;
        }

        int left = binarySearch(a, b, 0, pivot - 1);
        if (left != -1) return left;
        return binarySearch(a, b, pivot, a.size() - 1);
    }

    private int binarySearch(List<Integer> a, int b, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == b) return mid;
            else if (a.get(mid) < b) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(6);
        System.out.println(new RotatedSortedArraySearch().search(a, 6));
    }
}



