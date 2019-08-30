package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PRDRG {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int t = Integer.parseInt(s[0]);
        Rational[] rationals = new Rational[26];

        Rational right = new Rational(1, 1);
        Rational left = new Rational(0, 1);
        Rational current = new Rational(1, 1);

        boolean fromRight = true;
        for (int i = 1; i <= 25; i++) {
            current.denom *= 2;
            if (fromRight) {
                right = right.subtract(current);
                rationals[i] = right;
            } else {
                left = left.add(current);
                rationals[i] = left;
            }

            fromRight = !fromRight;
        }

        for (int i = 1; i <= t; i++) {
            int n = Integer.parseInt(s[i]);
            System.out.print(rationals[n].numer + " " + rationals[n].denom + " ");
        }
    }
}

class Rational {
    long numer, denom;

    private long gcd(long a, long b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public Rational(long n, long d) {
        long g = gcd(n, d);
        this.numer = n / g;
        this.denom = d / g;
    }

    public Rational add(Rational that) {
        long lcm = lcm(this.denom, that.denom);
        return new Rational(((lcm / this.denom) * this.numer) + ((lcm / that.denom) * that.numer), lcm);
    }

    public Rational subtract(Rational that) {
        long lcm = lcm(this.denom, that.denom);
        return new Rational(((lcm / this.denom) * this.numer) - ((lcm / that.denom) * that.numer), lcm);
    }
}
