package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class COINS {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        HashMap<Integer, Long> map = new HashMap<>();
        while ((s = in.readLine()) != null) {
            int value = Integer.parseInt(s);
            System.out.println(computeMaxValue(value, map));
        }
    }

    private static long computeMaxValue(int n, HashMap<Integer, Long> map) {
        if (n == 0) return 0;
        if (map.containsKey(n)) return map.get(n);
        long result = Math.max(n, computeMaxValue(n / 2, map) +
                computeMaxValue(n / 3, map) +
                computeMaxValue(n / 4, map));
        map.put(n, result);
        return result;
    }
}
