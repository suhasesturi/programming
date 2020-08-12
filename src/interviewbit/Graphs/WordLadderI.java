package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadderI {
	public int solve(String start, String end, ArrayList<String> dict) {
		if (start.equals(end)) return 1;
		dict.add(start);
		dict.add(end);

		int n = dict.size();
		boolean[] visited = new boolean[n];
		int[] distance = new int[n];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
			distance[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (dist(dict.get(i), dict.get(j)) == 1) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
		}

		distance[n - 2] = 0;
		bfs(graph, n - 2, visited, distance);
		return distance[n - 1] + 1;
	}

	private void bfs(ArrayList<ArrayList<Integer>> graph, int u, boolean[] visited, int[] distance) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(u);
		while (!queue.isEmpty()) {
			u = queue.poll();
			visited[u] = true;
			for (Integer v : graph.get(u)) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
					distance[v] = distance[u] + 1;
				}
			}
		}
	}

	private int dist(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) count++;
		}
		return count;
	}
}
