package interviewbit.Hashing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestConsecutiveSequence {
    public int longestConsecutive(final List<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer a : A) {
            map.put(a, 1);
        }

        int result = Integer.MIN_VALUE;
        for (Integer a: A) {
            if (!map.containsKey(a)) continue;

            int count = 1;
            map.remove(a);
            for (int i = a - 1; ; i--) {
                if (map.containsKey(i)) {
                    map.remove(i);
                    count++;
                } else break;
            }

            for (int i = a + 1; ; i++) {
                if (map.containsKey(i)) {
                    map.remove(i);
                    count++;
                } else break;
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
