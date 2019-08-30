package interviewbit;

import java.util.ArrayList;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(ArrayList<Integer> a) {
        int i = 0;
        for (int j = 0; i < a.size() && j < a.size(); ) {
            if (a.get(i).equals(a.get(j))) {
                j++;
            } else {
                i++;
                int temp = a.get(i);
                a.set(i, a.get(j));
                a.set(j, temp);
                j++;
            }
        }
        return i + 1;
    }
}




