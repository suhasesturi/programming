package interviewbit.BinarySearch;

import java.util.ArrayList;

public class AllocateBooks {
    public int books(ArrayList<Integer> list, int B) {
        long low = 0, high = 0;
        if (B > list.size()) return -1;

        for (Integer integer : list) {
            low = Math.max(low, integer);
            high += integer;
        }

        while (low < high) {
            long mid = (low + high) / 2;
            int count = 1;
            long sum = 0;
            for (int i = 0; i < list.size() && count <= B; i++) {
                sum += list.get(i);
                if (sum > mid) {
                    sum = list.get(i);
                    count++;
                }
            }

            if (count <= B) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }
}
