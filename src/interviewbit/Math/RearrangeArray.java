package interviewbit.Math;

import java.util.ArrayList;

public class RearrangeArray {
    public void arrange(ArrayList<Integer> a) {
        int size = a.size();
        for (int i = 0; i < size; i++) {
            a.set(i, a.get(i) + (a.get(a.get(i)) % size) * size);
        }

        for (int i = 0; i < size; i++) {
            a.set(i, a.get(i) / size);
        }
    }
}
