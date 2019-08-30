package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MAGICHF2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] temp = in.readLine().split(" ");
            long n = Long.parseLong(temp[0]);
            long k = Long.parseLong(temp[1]);

            if (k == 0 || n <= 2) {
                System.out.printf("%6f\n", 1.0 / n);
                continue;
            }
        }
    }
}
