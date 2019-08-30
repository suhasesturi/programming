package interviewbit.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        boolean[][] board = new boolean[a][a];
        helper(board, 0, result);
        return result;
    }

    private void helper(boolean[][] board, int column, ArrayList<ArrayList<String>> result) {
        if (column == board.length) {
            StringBuilder builder = new StringBuilder();
            ArrayList<String> solution = new ArrayList<>();

            for (boolean[] row : board) {
                for (int j = 0; j < board.length; j++) {
                    builder.append(row[j] ? 'Q' : '.');
                }
                solution.add(builder.toString());
                builder = new StringBuilder();
            }

            result.add(solution);
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, column)) {
                board[i][column] = true;
                helper(board, column + 1, result);
                board[i][column] = false;
            }
        }
    }

    private boolean isSafe(boolean[][] board, int row, int column) {
        for (int i = 0; i < column; i++) {
            if (board[row][i]) return false;
        }

        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }

        for (int i = row, j = column; i < board.length && j >= 0; i++, j--) {
            if (board[i][j]) return false;
        }

        return true;
    }
}
