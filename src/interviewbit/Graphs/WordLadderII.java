package interviewbit.Graphs;

import java.util.*;

import static java.util.Collections.swap;

public class WordLadderII {
	public static void main(String[] args) {
		System.out.println(new WordLadderII().findLadders("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"))));
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end, ArrayList<String> dict) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if (start.equals(end)) {
			result.add(new ArrayList<>(Collections.singletonList(start)));
			return result;
		}
		dict = new ArrayList<>(new HashSet<>(dict));

		dict.add(start);
		dict.add(end);
		int n = dict.size();
		int[] distance = new int[n];
		int[] visited = new int[n];
		ArrayList<ArrayList<Integer>> parent = new ArrayList<>();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			parent.add(new ArrayList<>());
			graph.add(new ArrayList<>());
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (dist(dict.get(i), dict.get(j)) == 1) {
					graph.get(i).add(j);
					graph.get(j).add(i);
				}
			}
		}

		bfs(graph, n - 2, end, distance, parent, visited);

		populatePaths(dict, parent, n - 1, new ArrayList<>(Collections.singletonList(end)), result);
		for (ArrayList<String> path : result) {
			for (int i = 0, j = path.size() - 1; i < j; i++, j--) {
				swap(path, i, j);
			}
		}
		return result;
	}

	private void populatePaths(ArrayList<String> dict, ArrayList<ArrayList<Integer>> parent,
	                           int u, ArrayList<String> current, ArrayList<ArrayList<String>> result) {
		if (u == dict.size() - 2) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (Integer node : parent.get(u)) {
			current.add(dict.get(node));
			populatePaths(dict, parent, node, current, result);
			current.remove(current.size() - 1);
		}
	}

	private void bfs(ArrayList<ArrayList<Integer>> graph, int u, String end, int[] distance,
	                 ArrayList<ArrayList<Integer>> parent, int[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		distance[u] = 0;
		queue.add(u);
		while (!queue.isEmpty()) {
			u = queue.poll();
			visited[u] = 2;
			for (int v : graph.get(u)) {
				if (visited[v] != 2) {
					if (visited[v] == 0) queue.add(v);
					visited[v] = 1;
					if (distance[u] + 1 <= distance[v]) {
						if (distance[u] + 1 < distance[v]) {
							parent.get(v).clear();
						}
						distance[v] = distance[u] + 1;
						parent.get(v).add(u);
					}
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
