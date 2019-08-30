package lintcode;

public class LC2 {
    public long trailingZeros(long n) {
        long result = 0;
        while (n / 5 != 0) {
            result += n / 5;
            n /= 5;
        }
        return result;
    }
}
