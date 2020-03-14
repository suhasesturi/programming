package interviewbit.Arrays;

import java.util.List;

public class MaxDistance {
    public int maximumGap(final List<Integer> list) {
        int n = list.size();
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = list.get(0);
        for (int i = 1; i < n; i++) {
            left[i] = Math.min(left[i - 1], list.get(i));
        }

        right[n - 1] = list.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], list.get(i));
        }

        int max = 0;
        for (int i = 0, j = 0; i < n && j < n; ) {
            if (left[i] <= right[j]) {
                max = Math.max(max, j - i);
                j++;
            } else {
                i++;
            }
        }

        return max;
    }
}
