package interviewbit;

import java.util.ArrayList;

public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        for (int top = 0, bottom = n - 1; top < bottom; top++, bottom--) {
            for (int i = top, j = top, k = bottom, l = bottom; i < bottom; i++, j++, k--, l--) {
                int a = A.get(top).get(i);
                int b = A.get(j).get(bottom);
                int c = A.get(bottom).get(k);
                int d = A.get(l).get(top);

                A.get(j).set(bottom, a);
                A.get(bottom).set(k, b);
                A.get(l).set(top, c);
                A.get(top).set(i, d);
            }
        }
    }
}

