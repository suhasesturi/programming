package interviewbit.Arrays;

import java.util.ArrayList;

public class SetMatrixZero {
	public void setZeroes(ArrayList<ArrayList<Integer>> matrix) {
		if (matrix.isEmpty()) return;

		boolean firstRow = false, firstColumn = false;
		int n = matrix.size(), m = matrix.get(0).size();
		for (ArrayList<Integer> list : matrix) {
			if (list.get(0) == 0) {
				firstColumn = true;
				break;
			}
		}

		for (int j = 0; j < m; j++) {
			if (matrix.get(0).get(j) == 0) {
				firstRow = true;
				break;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix.get(i).get(j) == 0) {
					matrix.get(i).set(0, 0);
					matrix.get(0).set(j, 0);
				}
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
					matrix.get(i).set(j, 0);
				}
			}
		}

		if (firstRow) {
			for (int j = 0; j < m; j++) {
				matrix.get(0).set(j, 0);
			}
		}

		if (firstColumn) {
			for (ArrayList<Integer> list : matrix) {
				list.set(0, 0);
			}
		}
	}
}
