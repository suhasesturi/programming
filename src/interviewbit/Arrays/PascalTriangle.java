package interviewbit.Arrays;

import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> solve(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            ArrayList<Integer> current = new ArrayList<>();
            for (int column = 0; column <= row; column++) {
                if (column == 0 || column == row) {
                    current.add(1);
                } else {
                    current.add(result.get(row - 1).get(column) + result.get(row - 1).get(column - 1));
                }
            }
            result.add(current);
        }
        return result;
    }
}
