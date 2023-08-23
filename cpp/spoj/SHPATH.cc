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

// use pair<int, long long> if tle in spoj
struct edge {
    int vertex;
    long long weight;
};

class Graph {
   public:
    Graph(int n) { edges.resize(n, vector<edge>()); }

    void add_edge(int u, int v, long long weight) {
        edges[u].push_back({v, weight});
    }

    long long min_dist(int u, int v, vector<int>& visited) {
        priority_queue<edge, vector<edge>,
                       std::function<bool(const edge&, const edge&)>>
            pq([](const edge& a, const edge& b) {
                return a.weight > b.weight;
            });
        pq.push({u, 0LL});

        while (!pq.empty()) {
            edge from = pq.top();
            pq.pop();
            if (visited[from.vertex] == 1) continue;

            visited[from.vertex] = 1;
            if (from.vertex == v) {
                return from.weight;
            }
            for (edge to : edges[from.vertex]) {
                if (visited[to.vertex] == 0) {
                    pq.push({to.vertex, from.weight + to.weight});
                }
            }
        }

        return -1;
    }

   private:
    vector<vector<edge>> edges;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int n, m, v, queries;
        long long w;
        string city, city2;
        cin >> n;

        vector<int> visited(n);
        Graph graph(n);
        map<string, int> index_map;
        for (int i = 0; i < n; i++) {
            cin >> city;
            index_map[city] = i;
            cin >> m;
            for (int j = 0; j < m; j++) {
                cin >> v >> w;
                v--;
                graph.add_edge(i, v, w);
            }
        }

        cin >> queries;
        for (int i = 0; i < queries; i++) {
            cin >> city >> city2;
            fill(visited.begin(), visited.end(), 0);
            cout << graph.min_dist(index_map[city], index_map[city2], visited)
                 << "\n";
        }
    }
    return 0;
}
