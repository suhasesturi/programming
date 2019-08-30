package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public int wordBreak(String A, ArrayList<String> B) {
        int n = A.length();
        Set<String> set = new HashSet<>(B);
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && set.contains(A.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n] ? 1 : 0;
    }
}
