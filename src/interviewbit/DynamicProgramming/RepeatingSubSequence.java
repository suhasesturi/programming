package interviewbit.DynamicProgramming;

public class RepeatingSubSequence {
    public int anytwo(String A) {
        int n = A.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == A.charAt(j - 1) && i != j)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][n] >= 2 ? 1 : 0;
    }
}

/*

an instance of disagreement with a colleague
why google?
strengths and weaknesses
often we have to work for people for work styles differ from my own
    were you able to learn anything from this person's work style
    prototype, design before implementation

two different teams having

end of user testing sprint
    privacy concern - work on it
        isolate the groups - not release to these groups
        make it clear release coordinator and mangers

*/
