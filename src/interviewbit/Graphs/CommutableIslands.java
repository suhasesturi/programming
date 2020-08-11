package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Comparator;

public class CommutableIslands {
	public int solve(int n, ArrayList<ArrayList<Integer>> edges) {
		edges.sort(Comparator.comparingInt(a -> a.get(2)));
		int[][] islands = new int[n + 1][2];
		for (int i = 0; i <= n; i++) islands[i][0] = i;

		int sum = 0;
		for (ArrayList<Integer> edge : edges) {
			int u = edge.get(0) - 1;
			int v = edge.get(1) - 1;
			int w = edge.get(2);

			if (findSet(islands, u) != findSet(islands, v)) {
				sum += w;
				union(u, v, islands);
			}
		}
		return sum;
	}

	private void union(int x, int y, int[][] islands) {
		link(findSet(islands, x), findSet(islands, y), islands);
	}

	private void link(int x, int y, int[][] islands) {
		if (islands[x][1] > islands[y][1]) {
			islands[y][0] = x;
		} else {
			islands[x][0] = y;
			if (islands[x][1] == islands[y][1]) {
				islands[y][1]++;
			}
		}
	}

	private int findSet(int[][] islands, int i) {
		if (islands[i][0] != i) {
			islands[i][0] = findSet(islands, islands[i][0]);
		}
		return islands[i][0];
	}
}
