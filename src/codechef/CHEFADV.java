package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CHEFADV {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] temp = in.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int x = Integer.parseInt(temp[2]);
            int y = Integer.parseInt(temp[3]);

            if (((n - 1) >= 0 && (m - 1) >= 0 && (n - 1) % x == 0 && (m - 1) % y == 0) ||
                    ((n - 2) >= 0 && (m - 2) >= 0 && (n - 2) % x == 0 && (m - 2) % y == 0)) {
                System.out.println("Chefirnemo");
            } else {
                System.out.println("Pofik");
            }
        }
    }
}
