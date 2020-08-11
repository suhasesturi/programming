package interviewbit.Graphs;

import java.util.ArrayList;

public class WordSearchBoard {
	public int exist(ArrayList<String> matrix, String word) {
		int n = matrix.size(), m = matrix.get(0).length();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (backtrack(matrix, word, i, j, 0)) return 1;
			}
		}
		return 0;
	}

	private boolean backtrack(ArrayList<String> matrix, String word, int x, int y, int index) {
		int n = matrix.size(), m = matrix.get(0).length();
		if (x >= n || y >= m || x < 0 || y < 0) return false;
		if (index == word.length()) return true;
		if (word.charAt(index) != matrix.get(x).charAt(y)) return false;
		int[] rowOffset = {-1, 1, 0, 0};
		int[] columnOffset = {0, 0, 1, -1};
		for (int i = 0; i < rowOffset.length; i++) {
			if (backtrack(matrix, word, x + rowOffset[i], y + columnOffset[i], index + 1))
				return true;
		}
		return false;
	}
}
