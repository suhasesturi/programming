package interviewbit.Arrays;

import java.util.ArrayList;

public class KthRowPascalsTriangle {
    public ArrayList<Integer> getRow(int k) {
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        for (int row = 0; row <= k; row++) {
            for (int column = 0; column <= row; column++) {
                if (column == 0 || column == row) {
                    second.add(1);
                } else {
                    second.add(first.get(column - 1) + first.get(column));
                }
            }
            first = second;
            second = new ArrayList<>();
        }
        return first;
    }
}
