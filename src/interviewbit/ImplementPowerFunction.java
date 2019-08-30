package interviewbit;

public class ImplementPowerFunction {
    public int pow(int x, int n, int d) {
        long result = 1;
        if (x == 0) return 0;
        if (n == 0) return 1;

        boolean flag = false;
        if (x < 0) {
            x = -x;
            if (n % 2 == 1) flag = true;
        }

        long temp = x % d;
        while (n != 0) {
            if ((n & 1) == 1) {
                result = (result * temp) % d;
            }

            temp = (temp * temp) % d;

            n = n >> 1;
        }

        return flag ? d - (int) result : (int) result;
    }
}
