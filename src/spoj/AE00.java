package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AE00 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        long count = 0;
        for (int i = 1; i <= n; i++) {
            if (n / i >= i) {
                count += (n / i) - (i - 1);
            } else break;
        }
        System.out.println(count);
    }
}
