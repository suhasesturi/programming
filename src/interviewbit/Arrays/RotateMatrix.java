package interviewbit.Arrays;

import java.util.ArrayList;

public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> matrix) {
        int n = matrix.size();
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left, j = right; i < right; i++, j--) {
                int topLeft = matrix.get(top).get(i);
                int topRight = matrix.get(i).get(right);
                int bottomRight = matrix.get(bottom).get(j);
                int bottomLeft = matrix.get(j).get(left);

                matrix.get(top).set(i, bottomLeft);
                matrix.get(i).set(right, topLeft);
                matrix.get(bottom).set(j, topRight);
                matrix.get(j).set(left, bottomRight);
            }
            top++;
            bottom--;
            left++;
            right--;
        }
    }
}
