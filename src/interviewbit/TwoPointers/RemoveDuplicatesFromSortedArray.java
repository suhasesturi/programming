package interviewbit.TwoPointers;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(ArrayList<Integer> a) {
        int position = 0;
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(position).equals(a.get(i))) {
                a.set(++position, a.get(i));
            }
        }
        return position + 1;
    }
}
