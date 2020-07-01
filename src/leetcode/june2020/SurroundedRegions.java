package leetcode.june2020;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) return;
		int n = board.length;
		int m = board[0].length;

		for (int i = 0; i < n; i++) {
			flip(board, i, 0);
			flip(board, i, m - 1);
		}
		for (int j = 0; j < m; j++) {
			flip(board, 0, j);
			flip(board, n - 1, j);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'O') board[i][j] = 'X';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == '1') board[i][j] = 'O';
			}
		}
	}

	private void flip(char[][] board, int i, int j) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
			if (board[i][j] == 'O') {
				board[i][j] = '1';
				flip(board, i - 1, j);
				flip(board, i + 1, j);
				flip(board, i, j - 1);
				flip(board, i, j + 1);
			}
		}
	}
}
