package interviewbit.Hashing;

import java.util.*;

public class TwoSum {
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.size(); i++) {
            int required = B - A.get(i);
            if (map.containsKey(required)) {
                int max = Math.max(map.get(required), i);
                int min = Math.min(map.get(required), i);

                if (result.isEmpty()) {
                    result.add(min);
                    result.add(max);
                } else {
                    if (max < result.get(1) || (max == result.get(1) && min < result.get(0))) {
                        result.set(0, min);
                        result.set(1, max);
                    }
                }
            } else {
                if (!map.containsKey(A.get(i))) {
                    map.put(A.get(i), i);
                }
            }
        }

        if (!result.isEmpty()) {
            result.set(0, result.get(0) + 1);
            result.set(1, result.get(1) + 1);
        }
        return result;
    }
}
