package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CANDY3 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            in.readLine();
            long sum = 0;
            int n = Integer.parseInt(in.readLine());
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(in.readLine());
            }

            if (sum % n == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
