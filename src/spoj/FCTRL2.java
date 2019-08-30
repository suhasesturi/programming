package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FCTRL2 {
    private static int[] result = new int[160];

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            Arrays.fill(result, 0);
            result[0] = 1;
            for (int i = 1; i <= n; i++) {
                int carry = 0;
                for (int j = 0; j < result.length; j++) {
                    carry += i * result[j];
                    result[j] = carry % 10;
                    carry /= 10;
                }
            }
            int index = 0;
            for (int i = result.length - 1; i >= 0; i--) {
                if (result[i] != 0) {
                    index = i;
                    break;
                }
            }

            for (int i = index; i >= 0; i--) {
                System.out.print(result[i]);
            }
            System.out.println();
        }
    }
}
