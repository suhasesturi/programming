package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CaptureRegionsOnABoard {
	public static void main(String[] args) {
		ArrayList<ArrayList<Character>> matrix = new ArrayList<>(Arrays.asList(new ArrayList<>(Collections.singletonList('O'))));
		new CaptureRegionsOnABoard().solve(matrix);
		System.out.println();
	}

	public void solve(ArrayList<ArrayList<Character>> matrix) {
		if (matrix.isEmpty() || matrix.get(0).isEmpty()) return;
		int n = matrix.size(), m = matrix.get(0).size();
		for (int i = 0; i < n; i++) {
			flip(matrix, i, 0);
			flip(matrix, i, m - 1);
		}

		for (int j = 0; j < m; j++) {
			flip(matrix, 0, j);
			flip(matrix, n - 1, j);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix.get(i).get(j) == 'O') {
					matrix.get(i).set(j, 'X');
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix.get(i).get(j) == '*') {
					matrix.get(i).set(j, 'O');
				}
			}
		}
	}

	private void flip(ArrayList<ArrayList<Character>> matrix, int x, int y) {
		int n = matrix.size(), m = matrix.get(0).size();
		if (x >= n || y >= m || x < 0 || y < 0) return;
		if (matrix.get(x).get(y) == 'X' || matrix.get(x).get(y) == '*') return;
		matrix.get(x).set(y, '*');
		flip(matrix, x + 1, y);
		flip(matrix, x - 1, y);
		flip(matrix, x, y + 1);
		flip(matrix, x, y - 1);
	}

}
