package interviewbit.Graphs;

import java.util.*;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		HashSet<UndirectedGraphNode> visited = new HashSet<>();
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		map.put(node, clone);

		bfs(node, visited, map);
		return clone;
	}

	private void bfs(UndirectedGraphNode u, HashSet<UndirectedGraphNode> visited,
	                 HashMap<UndirectedGraphNode, UndirectedGraphNode> map) {
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(u);
		while (!queue.isEmpty()) {
			u = queue.poll();
			visited.add(u);
			for (UndirectedGraphNode v : u.neighbors) {
				if (!visited.contains(v)) {
					UndirectedGraphNode clonedV = new UndirectedGraphNode(v.label);
					map.put(v, clonedV);
					visited.add(v);
					queue.add(v);
				}
				map.get(u).neighbors.add(map.get(v));
			}
		}
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<>();
	}
}
