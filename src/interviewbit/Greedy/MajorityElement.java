package interviewbit.Greedy;

import java.util.List;

public class MajorityElement {
    public int majorityElement(final List<Integer> A) {
        if (A.isEmpty()) return -1;

        int index = -1;
        int count = 0;
        for (int i = 0; i < A.size(); i++) {
            if (count == 0) {
                index = i;
                count++;
            } else if (A.get(i).equals(A.get(index))) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (Integer a : A) {
            if (a.equals(A.get(index))) count++;
        }

        if (count >= Math.floor(A.size() / 2)) return index;
        return -1;
    }
}
