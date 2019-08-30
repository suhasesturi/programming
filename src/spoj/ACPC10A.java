package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACPC10A {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();

        while (!input.trim().equals("0 0 0")) {
            String[] s = input.split(" ");
            int first = Integer.parseInt(s[0]);
            int second = Integer.parseInt(s[1]);
            int third = Integer.parseInt(s[2]);

            if (third - second == second - first) {
                System.out.println("AP " + (third + (third - second)));
            } else {
                System.out.println("GP " + (third * (third / second)));
            }

            input = in.readLine();
        }
    }
}
