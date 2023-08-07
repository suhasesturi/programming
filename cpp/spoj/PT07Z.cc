#include <math.h>

#include <algorithm>
#include <deque>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

class Graph {
   public:
    Graph(int n) {
        for (int i = 0; i < n; i++) {
            edges.push_back(vector<int>());
        }
    }

    void add_edge(int a, int b) {
        edges[a].push_back(b);
        edges[b].push_back(a);
    }

    int bfs(int u, vector<bool>& visited, vector<int>& distance) {
        deque<int> nodes;
        visited[u] = true;
        distance[u] = 0;
        nodes.push_back(u);
        int max_dist_node = u;

        while (!nodes.empty()) {
            int current = nodes.front();
            nodes.pop_front();

            for (int v : edges[current]) {
                if (!visited[v]) {
                    visited[v] = true;
                    nodes.push_back(v);
                    distance[v] = distance[current] + 1;
                    max_dist_node = v;
                }
            }
        }
        return max_dist_node;
    }

   private:
    vector<vector<int>> edges;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, a, b;
    cin >> n;
    Graph graph(n);
    for (int i = 0; i < n - 1; i++) {
        cin >> a >> b;
        a--;
        b--;
        graph.add_edge(a, b);
    }

    vector<bool> visited(n, false);
    vector<int> distance(n, 0);
    int farthest_node = graph.bfs(0, visited, distance);

    fill(visited.begin(), visited.end(), false);
    fill(distance.begin(), distance.end(), 0);
    cout << distance[graph.bfs(farthest_node, visited, distance)] << "\n";
    return 0;
}
