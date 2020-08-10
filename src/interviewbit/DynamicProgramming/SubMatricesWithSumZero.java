package interviewbit.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class SubMatricesWithSumZero {
	public int solve(ArrayList<ArrayList<Integer>> A) {
		if (A.isEmpty() || A.get(0).isEmpty()) return 0;
		int n = A.size(), m = A.get(0).size();
		int[][] ps = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + A.get(i - 1).get(j - 1);
			}
		}

		int count = 0;
		for (int row1 = 1; row1 <= n; row1++) {
			for (int row2 = row1; row2 <= n; row2++) {
				HashMap<Integer, Integer> map = new HashMap<>();
				map.put(0, 1);
				for (int col = 1; col <= m; col++) {
					int sum = ps[row2][col] - ps[row1 - 1][col];
					count += map.getOrDefault(sum, 0);
					map.put(sum, map.getOrDefault(sum, 0) + 1);
				}
			}
		}

		return count;
	}
}
