package topcoder;

public class SortEstimate {

    public double howMany(int c, int time) {
        double low = 0, high = 2e9;
        int iterations = 200;
        while (high - low > 1e-9 && iterations-- > 0) {
            double mid = low + (high - low) / 2;
            if (mid * (Math.log10(mid) / Math.log10(2)) <= ((time * 1.0) / c))
                low = mid;
            else
                high = mid;
        }
        return low;
    }
}
