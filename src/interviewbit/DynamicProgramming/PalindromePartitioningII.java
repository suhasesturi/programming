package interviewbit.DynamicProgramming;

public class PalindromePartitioningII {
    public int minCut(String str) {
        int n = str.length();
        boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - l; i++) {
                int j = i + l - 1;

                boolean common = str.charAt(i) == str.charAt(j);
                if (l == 2) {
                    palindrome[i][j] = common;
                } else {
                    palindrome[i][j] = common && palindrome[i + 1][j - 1];
                }
            }
        }

        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            if (palindrome[0][i]) {
                cuts[i] = 0;
            } else {
                cuts[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (palindrome[j + 1][i] && cuts[j] + 1 < cuts[i]) {
                        cuts[i] = cuts[j] + 1;
                    }
                }
            }
        }

        return cuts[n - 1];
    }
}
