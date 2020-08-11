package interviewbit.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class PossibilityOfFinishingAllCoursesGivenPreRequisites {
	public static void main(String[] args) {
		System.out.println(new PossibilityOfFinishingAllCoursesGivenPreRequisites().solve(3,
				new ArrayList<>(Arrays.asList(1, 1, 2)),
				new ArrayList<>(Arrays.asList(2, 3, 3))));
	}

	public int solve(int n, ArrayList<Integer> u, ArrayList<Integer> v) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < u.size(); i++) {
			graph.get(u.get(i) - 1).add(v.get(i) - 1);
		}

		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i] && dfsCycle(graph, visited, new boolean[n], i)) {
				return 0;
			}
		}
		return 1;
	}

	private boolean dfsCycle(ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] onPath, int u) {
		if (visited[u]) return false;
		onPath[u] = visited[u] = true;
		for (Integer v : graph.get(u)) {
			if (onPath[v] || dfsCycle(graph, visited, onPath, v)) {
				return true;
			}
		}
		return onPath[u] = false;
	}
}
