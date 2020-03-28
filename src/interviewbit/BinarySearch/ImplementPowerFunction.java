package interviewbit.BinarySearch;

public class ImplementPowerFunction {
    public int pow(int x, int n, int d) {
        return (((x >= 0 || n % 2 == 0) ? 1 : -1) * power(Math.abs(x), n, d) + d) % d;
    }

    public int power(int x, int n, int d) {
        if (x == 0) return 0;
        if (n == 0) return 1;

        long p = power(x, n / 2, d);
        p = (p * p) % d;
        return n % 2 == 0 ? (int) p : (int) ((p * x) % d);
    }
}
