package interviewbit;

import java.util.ArrayList;

public class KthRowPascalsTriangle {
    public ArrayList<Integer> getRow(int row) {
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        ArrayList<Integer> second = new ArrayList<>();
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    second.add(1);
                } else {
                    second.add(first.get(j) + first.get(j - 1));
                }
            }
            first = second;
            second = new ArrayList<>();
        }
        return first;
    }
}
