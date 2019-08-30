package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NSTEPS {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        while (n-- > 0) {
            String[] s = in.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            if (y != x && y + 2 != x) System.out.println("No Number");
            else {
                if (x % 2 == 0) System.out.println(x + y);
                else System.out.println(x + y - 1);
            }
        }
    }
}
