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

class Graph {
   public:
    Graph(int n) { edges.resize(n, vector<int>()); }

    void add_edges(int u, int v) {
        edges[u].push_back(v);
        edges[v].push_back(u);
    }

    void dfs(int start, vector<bool>& visited) {
        deque<int> dq;
        dq.push_back(start);
        visited[start] = true;

        while (!dq.empty()) {
            int u = dq.front();
            dq.pop_front();

            for (int v : edges[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    dq.push_back(v);
                }
            }
        }
    }

   private:
    vector<vector<int>> edges;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int n, m, a, b;
        cin >> n >> m;
        Graph graph(n);
        while (m-- > 0) {
            cin >> a >> b;
            graph.add_edges(a, b);
        }

        int count = 0;
        vector<bool> visited(n, false);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                graph.dfs(i, visited);
            }
        }
        cout << count << "\n";
    }
    return 0;
}
