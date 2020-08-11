package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LargestDistanceBetweenNodesOfATree {
	public int solve(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int n = A.size();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
			;
		}

		for (int i = 0; i < n; i++) {
			if (A.get(i) != -1) {
				graph.get(i).add(A.get(i));
				graph.get(A.get(i)).add(i);
			}
		}

		boolean[] visited = new boolean[n];
		int[] distance = new int[n];

		int farthest = bfs(graph, visited, distance, 0);
		Arrays.fill(visited, false);
		Arrays.fill(distance, 0);
		return distance[bfs(graph, visited, distance, farthest)];
	}

	private int bfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int[] distance, int u) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(u);
		distance[u] = 0;
		while (!queue.isEmpty()) {
			u = queue.poll();
			visited[u] = true;
			for (Integer v : graph.get(u)) {
				if (!visited[v]) {
					visited[v] = true;
					distance[v] = distance[u] + 1;
					queue.add(v);
				}
			}
		}
		return u;
	}
}
