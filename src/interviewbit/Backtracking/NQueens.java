package interviewbit.Backtracking;

import java.util.ArrayList;

public class NQueens {
	public static void main(String[] args) {
		System.out.println(new NQueens().solveNQueens(4));
	}

	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		boolean[][] board = new boolean[n][n];
		generate(board, result, 0);
		return result;
	}

	private void generate(boolean[][] board, ArrayList<ArrayList<String>> result, int column) {
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
			if (isValid(i, column, board)) {
				board[i][column] = true;
				generate(board, result, column + 1);
				board[i][column] = false;
			}
		}
	}

	private boolean isValid(int row, int column, boolean[][] board) {
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
