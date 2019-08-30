package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SHKNUM {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        long[] powers = new long[32];
        powers[0] = 1;
        for (int i = 1; i < 32; i++) {
            powers[i] = powers[i - 1] * 2;
        }

        ArrayList<Long> possibleValues = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            for (int j = i + 1; j < 32; j++) {
                possibleValues.add(powers[i] + powers[j]);
            }
        }

        possibleValues.sort((a, b) -> (int) (a - b));

        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            int index = closest(possibleValues, n);
            System.out.println(Math.min(Math.abs(n - possibleValues.get(index)), Math.abs(possibleValues.get(index + 1) - n)));
        }
    }

    private static int closest(ArrayList<Long> possibleValues, long n) {
        int a = 0, b = possibleValues.size();
        while (a <= b) {
            int mid = (a + b) / 2;
            if (possibleValues.get(mid) <= n && possibleValues.get(mid + 1) > n) return mid;
            else if (possibleValues.get(mid) > n) b = mid - 1;
            else a = mid + 1;
        }
        return a;
    }
}
