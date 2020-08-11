package interviewbit.Graphs;

import java.util.ArrayList;

public class BlackShapes {
	public int black(ArrayList<String> A) {
		if (A == null || A.isEmpty() || A.get(0).length() == 0) return 0;
		boolean[][] visited = new boolean[A.size()][A.get(0).length()];

		int count = 0;
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).length(); j++) {
				if (A.get(i).charAt(j) == 'X' && !visited[i][j]) {
					traverse(A, visited, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void traverse(ArrayList<String> matrix, boolean[][] visited, int x, int y) {
		if (x < 0 || y < 0 || x >= matrix.size() || y >= matrix.get(0).length()) return;
		if (visited[x][y] || matrix.get(x).charAt(y) == 'O') return;
		visited[x][y] = true;
		traverse(matrix, visited, x + 1, y);
		traverse(matrix, visited, x - 1, y);
		traverse(matrix, visited, x, y - 1);
		traverse(matrix, visited, x, y + 1);
	}
}
