package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GMEDIAN {
    private static final int mod = 1000000007;
    private static int[][] combinations = new int[1010][1010];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        computeCombinations();

        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] temp = in.readLine().split(" ");

            int[] count = new int[2 * n + 1];
            int[] left = new int[2 * n + 2];
            int[] right = new int[2 * n + 2];
            for (int i = 0; i < n; i++) count[Integer.parseInt(temp[i])]++;
            for (int i = 1; i <= 2 * n; i++) left[i] = left[i - 1] + count[i];
            for (int i = 2 * n; i > 0; i--) right[i] = right[i + 1] + count[i];

            long result = 0;

            // odd sub sequences
            for (int i = 1; i <= n; i += 2) result = (result + combinations[n][i]) % mod;

            // even sub sequences
            for (int i = 2; i <= n; i += 2) {
                for (int j = 1; j <= 2 * n; j++) {
                    if (count[j] >= 2) {
                        int before = left[j] - count[j];
                        int after = right[j] - count[j];
                        int r = (i - 2) / 2;
                        for (int k = 0; k <= count[j] - 2; k++) {
                            result = (result + ((long) combinations[before + k][r] *
                                    (combinations[after + count[j] - 1 - k][r + 1] - combinations[after][r + 1])) % mod) % mod;
                        }
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void computeCombinations() {
        combinations[0][0] = 1;
        for (int i = 1; i <= 1005; i++) {
            for (int j = 0; j <= 1005; j++) {
                if (j == 0) {
                    combinations[i][0] = 1;
                } else {
                    combinations[i][j] = (int) ((combinations[i - 1][j] + (long) combinations[i - 1][j - 1]) % mod);
                }
            }
        }
    }
}
