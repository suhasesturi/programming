package codeforces.Contest1399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E1_1399 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		while (t-- > 0) {
			String[] s = in.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			long max = Long.parseLong(s[1]);

			int[] parent = new int[n + 1];
			parent[1] = 1;
			boolean[] visited = new boolean[n + 1];
			Arrays.fill(visited, false);

			Node[] nodes = new Node[n + 1];
			for (int i = 1; i <= n; i++) {
				nodes[i].edges = new ArrayList<>();
			}

			for (int i = 0; i < n - 1; i++) {
				s = in.readLine().split(" ");
				int u = Integer.parseInt(s[0]);
				int v = Integer.parseInt(s[1]);
				int w = Integer.parseInt(s[2]);
				Edge edge = new Edge(u, v, w);
				nodes[u].edges.add(edge);
				nodes[v].edges.add(edge);
			}

			HashMap<Integer, ArrayList<Integer>> nodeToLeaves = new HashMap<>();
			PriorityQueue<ArrayList<Long>> pathSums = new PriorityQueue<>(Comparator.comparingLong(a -> a.get(1)));
			dfs(parent, nodes, 1, new ArrayList<>(Arrays.asList(1)), visited, nodeToLeaves, 0L, pathSums);

			while (!pathSums.isEmpty()) {
				ArrayList<Long> path = pathSums.poll();
				if (path.get(1) <= max) continue;
				int node = (int) ((long) path.get(0));
				while (parent[node] != node) {
					node = parent[node];
				}
			}
		}
	}

	private static void dfs(int[] parent, Node[] nodes, int root, ArrayList<Integer> path,
	                        boolean[] visited, HashMap<Integer, ArrayList<Integer>> nodeToLeaves, long sum,
	                        PriorityQueue<ArrayList<Long>> pathSums) {
		int count = 0;
		for (Edge edge : nodes[root].edges) {
			int child = edge.u == root ? edge.v : edge.u;
			if (!visited[child]) {
				count++;
				parent[child] = root;
				visited[child] = true;
				path.add(child);
				dfs(parent, nodes, child, path, visited, nodeToLeaves, sum + edge.w, pathSums);
				path.remove(path.size() - 1);
			}
		}
		// leaf
		if (count == 0) {
			pathSums.add(new ArrayList<>(Arrays.asList((long) root, sum)));
			for (Integer node : path) {
				if (!nodeToLeaves.containsKey(node)) {
					nodeToLeaves.put(node, new ArrayList<>());
				}
				nodeToLeaves.get(node).add(root);
			}
		}
	}

	static class Node {
		ArrayList<Edge> edges;
	}

	static class Edge {
		int u, v, w;

		Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
}
