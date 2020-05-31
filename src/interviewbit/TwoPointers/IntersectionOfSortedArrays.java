package interviewbit.TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
    public ArrayList<Integer> intersect(final List<Integer> A, final List<Integer> B) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0, j = 0; i < A.size() && j < B.size(); ) {
            if (A.get(i).equals(B.get(j))) {
                result.add(A.get(i));
                i++; j++;
            } else if (A.get(i) < B.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
