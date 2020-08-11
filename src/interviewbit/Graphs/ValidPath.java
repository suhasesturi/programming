package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidPath {
	public String solve(int x, int y, int N, int R, ArrayList<Integer> xCor, ArrayList<Integer> yCor) {
		if ((x == 0 && y == 0) || xCor.isEmpty()) return "YES";

		int[][] matrix = new int[x + 1][y + 1];
		for (int[] row : matrix) {
			Arrays.fill(row, -1);
		}

		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				for (int k = 0; k < N; k++) {
					if (Math.pow(i - xCor.get(k), 2) + Math.pow(j - yCor.get(k), 2) <= R * R) {
						matrix[i][j] = 0;
						break;
					}
				}
			}
		}

		if (matrix[0][0] == 0 || matrix[x][y] == 0) return "NO";
		matrix[x][y] = 1;
		return pathExists(matrix, 0, 0) == 1 ? "YES" : "NO";
	}

	private int pathExists(int[][] matrix, int x, int y) {
		if (x >= matrix.length || y >= matrix[0].length || x < 0 || y < 0) return 0;
		if (matrix[x][y] != -1) return matrix[x][y];
		matrix[x][y] = 0;
		if (pathExists(matrix, x + 1, y - 1) == 1 || pathExists(matrix, x + 1, y) == 1 ||
				pathExists(matrix, x + 1, y + 1) == 1 || pathExists(matrix, x, y - 1) == 1 ||
				pathExists(matrix, x, y + 1) == 1 || pathExists(matrix, x - 1, y - 1) == 1 ||
				pathExists(matrix, x - 1, y) == 1 || pathExists(matrix, x - 1, y + 1) == 1) {
			matrix[x][y] = 1;
		}
		return matrix[x][y];
	}
}
