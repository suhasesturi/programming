package interviewbit.Backtracking;

import java.util.ArrayList;

public class Sudoku {
	public void solveSudoku(ArrayList<ArrayList<Character>> matrix) {
		helper(matrix);
	}

	public boolean helper(ArrayList<ArrayList<Character>> matrix) {
		int n = matrix.size();
		boolean isComplete = true;
		int row = -1, column = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix.get(i).get(j) == '.') {
					row = i;
					column = j;
					isComplete = false;
					break;
				}
			}
			if (!isComplete) break;
		}

		if (isComplete) return true;

		for (int number = 1; number <= n; number++) {
			if (isSafe(matrix, row, column, number)) {
				matrix.get(row).set(column, (char) (number + '0'));
				if (helper(matrix)) {
					return true;
				} else {
					matrix.get(row).set(column, '.');
				}
			}
		}
		return false;
	}

	private boolean isSafe(ArrayList<ArrayList<Character>> matrix, int row, int column, int number) {
		int n = matrix.size();
		int sqrt = (int) Math.sqrt(n);

		for (ArrayList<Character> chars : matrix) {
			if ((chars.get(column) - '0') == number) return false;
		}

		for (int j = 0; j < n; j++) {
			if ((matrix.get(row).get(j) - '0') == number) return false;
		}

		int startRow = row - row % sqrt;
		int startColumn = column - column % sqrt;
		for (int i = startRow; i < startRow + sqrt; i++) {
			for (int j = startColumn; j < startColumn + sqrt; j++) {
				if ((matrix.get(i).get(j) - '0') == number) return false;
			}
		}
		return true;
	}
}
