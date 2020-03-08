package interviewbit.Arrays;

import java.util.ArrayList;

public class AntiDiagonals {
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> matrix) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int n = matrix.size();

		for (int column = 0; column < n; column++) {
			ArrayList<Integer> currentDiagonal = new ArrayList<>();
			for (int j = column, i = 0; j >= 0 && i < n; j--, i++) {
				currentDiagonal.add(matrix.get(i).get(j));
			}
			result.add(currentDiagonal);
		}

		for (int row = 1; row < n; row++) {
			ArrayList<Integer> currentDiagonal = new ArrayList<>();
			for (int i = row, j = n - 1; i < n && j >= 0; i++, j--) {
				currentDiagonal.add(matrix.get(i).get(j));
			}
			result.add(currentDiagonal);
		}
		return result;
	}
}
