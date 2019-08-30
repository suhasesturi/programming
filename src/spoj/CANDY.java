package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CANDY {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int n = Integer.parseInt(in.readLine());
            if (n == -1) break;

            int count = 0;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(in.readLine());
                count += value;
                arr[i] = value;
            }
            if (count % n != 0) System.out.println(-1);
            else {
                int result = 0;
                int avg = count / n;
                for (int i = 0; i < n; i++) {
                    result += Math.abs(avg - arr[i]);
                }
                System.out.println(result / 2);
            }
        }
    }
}
