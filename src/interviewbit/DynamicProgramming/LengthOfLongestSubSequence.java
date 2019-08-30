package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubSequence {
    public int longestSubsequenceLength(final List<Integer> A) {
        int[] up = subsequence(A);
        ArrayList<Integer> reverse = new ArrayList<>();
        for (int i = A.size() - 1; i >= 0; i--) reverse.add(A.get(i));

        int[] down = subsequence(reverse);
        for (int i = 0, j = down.length - 1; i < j; i++, j--) {
            int temp = down[i];
            down[i] = down[j];
            down[j] = temp;
        }
        int result = 0;
        for (int i = 0; i < A.size(); i++) {
            result = Math.max(result, up[i] + down[i] - 1);
        }
        return result;
    }

    private int[] subsequence(List<Integer> A) {
        int[] list = new int[A.size()];
        Arrays.fill(list, 1);
        for (int i = 1; i < A.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (A.get(i) > A.get(j) && list[i] < list[j] + 1)
                    list[i] = list[j] + 1;
            }
        }
        return list;
    }
}
