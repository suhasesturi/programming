package interviewbit.Graphs;

import java.util.ArrayList;

public class CaptureRegionsOnABoard {
    public void solve(ArrayList<ArrayList<Character>> matrix) {
        util(matrix);

        int rows = matrix.size();
        int columns = matrix.get(0).size();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix.get(i).get(j) == '*') {
                    matrix.get(i).set(j, 'O');
                } else {
                    matrix.get(i).set(j, 'X');
                }
            }
        }
    }

    private void util(ArrayList<ArrayList<Character>> matrix) {
        int rows = matrix.size();
        int columns = matrix.get(0).size();

        for (int i = 0; i < rows; i++) {
            mark(matrix, i, 0);
            mark(matrix, i, columns - 1);
        }

        for (int j = 0; j < columns; j++) {
            mark(matrix, 0, j);
            mark(matrix, rows - 1, j);
        }
    }

    private void mark(ArrayList<ArrayList<Character>> matrix, int i, int j) {
        int rows = matrix.size();
        int columns = matrix.get(0).size();

        if (i >= 0 && i < rows && j >= 0 && j < columns && matrix.get(i).get(j) == 'O') {
            matrix.get(i).set(j, '*');

            mark(matrix, i - 1, j);
            mark(matrix, i + 1, j);
            mark(matrix, i, j - 1);
            mark(matrix, i, j + 1);
        }
    }
}
