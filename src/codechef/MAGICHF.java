package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MAGICHF {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            String[] temp = in.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int x = Integer.parseInt(temp[1]);
            int s = Integer.parseInt(temp[2]);

            while (s-- > 0) {
                temp = in.readLine().split(" ");
                int first = Integer.parseInt(temp[0]);
                int second = Integer.parseInt(temp[1]);

                if (first == x) {
                    x = second;
                } else if (second == x) {
                    x = first;
                }
            }

            System.out.println(x);
        }

    }
}
