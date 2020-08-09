package interviewbit.DynamicProgramming;

import java.util.ArrayList;

public class LargestAreaOfRectangleWithPermutations {
	public int solve(ArrayList<ArrayList<Integer>> matrix) {
		if (matrix.isEmpty() || matrix.get(0).isEmpty()) return 0;
		int r = matrix.size(), c = matrix.get(0).size();
		int[][] histogram = new int[r][c];

		for (int j = 0; j < c; j++) {
			histogram[0][j] = matrix.get(0).get(j);
			for (int i = 1; i < r; i++) {
				histogram[i][j] = matrix.get(i).get(j) == 0 ? 0 : histogram[i - 1][j] + 1;
			}
		}

		for (int i = 0; i < r; i++) {
			int[] count = new int[r + 1];
			for (int j = 0; j < c; j++) {
				count[histogram[i][j]]++;
			}

			int column = 0;
			for (int j = r; j >= 0; j--) {
				for (int k = 0; k < count[j]; k++) {
					histogram[i][column++] = j;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				result = Math.max(result, (j + 1) * histogram[i][j]);
			}
		}

		return result;
	}
}
