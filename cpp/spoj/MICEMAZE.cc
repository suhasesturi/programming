#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

struct Edge {
    long long v, w;
};

class Graph {
   public:
    Graph(int n) { edges.resize(n, vector<Edge>()); }

    void add_edge(int u, int v, long long w) { edges[u].push_back({v, w}); }

    void smallest_path(int start, vector<long long>& distance) {
        priority_queue<Edge, vector<Edge>,
                       function<bool(const Edge&, const Edge&)>>
            pq([](const Edge& a, const Edge& b) { return a.w > b.w; });
        pq.push({start, 0});
        vector<bool> visited(distance.size(), false);

        while (!pq.empty()) {
            Edge from = pq.top();
            pq.pop();
            if (visited[from.v]) continue;

            visited[from.v] = true;
            distance[from.v] = from.w;

            for (Edge to : edges[from.v]) {
                if (!visited[to.v]) {
                    pq.push({to.v, to.w + from.w});
                }
            }
        }
    }

   private:
    vector<vector<Edge>> edges;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, E, M, u, v;
    long long T, w;
    cin >> n >> E >> T >> M;
    Graph graph(n);
    while (M-- > 0) {
        cin >> u >> v >> w;
        u--;
        v--;
        graph.add_edge(v, u, w);
    }

    vector<long long> distance(n, INT64_MAX);
    graph.smallest_path(E - 1, distance);
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (distance[i] <= T) count++;
    }
    cout << count << "\n";

    return 0;
}
