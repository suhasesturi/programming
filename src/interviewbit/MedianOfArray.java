package interviewbit;

import java.util.List;

public class MedianOfArray {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int n = a.size();
        int m = b.size();

        if (n > m) return findMedianSortedArrays(b, a);

        int start = 0, end = n;
        boolean even = (n + m) % 2 == 0;
        while (start <= end) {
            int i = (start + end) / 2;
            int j = (n + m + 1) / 2 - i;

            if (i > 0 && j < m && a.get(i - 1) > b.get(j)) end = i - 1;
            else if (j > 0 && i < n && b.get(j - 1) > a.get(i)) start = i + 1;
            else {
                int maxLeft = 0;
                if (i == 0) maxLeft = b.get(j - 1);
                else if (j == 0) maxLeft = a.get(i - 1);
                else maxLeft = Math.max(b.get(j - 1), a.get(i - 1));
                if (!even) return maxLeft;

                int minRight = 0;
                if (i == n) minRight = b.get(j);
                else if (j == m) minRight = a.get(i);
                else minRight = Math.min(b.get(j), a.get(i));
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0;
    }
}



