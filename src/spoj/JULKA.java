package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class JULKA {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = 10;
        while (t-- > 0) {
            BigInteger total = new BigInteger(in.readLine());
            BigInteger more = new BigInteger(in.readLine());

            BigInteger natalia = total.subtract(more).divide(BigInteger.valueOf(2));
            System.out.println(natalia.add(more));
            System.out.println(natalia);
        }
    }
}
