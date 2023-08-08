#include <math.h>

#include <algorithm>
#include <deque>
#include <iostream>
#include <map>
#include <set>
#include <stack>
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

    bool bfs(int start, vector<int>& color) {
        color[start] = 0;
        deque<int> nodes;
        nodes.push_back(start);

        while (!nodes.empty()) {
            int u = nodes.front();
            nodes.pop_front();

            for (int v : edges[u]) {
                if (color[v] == -1) {
                    nodes.push_back(v);
                    color[v] = 1 - color[u];
                } else if (color[u] == color[v]) {
                    return true;
                }
            }
        }
        return false;
    }

   private:
    vector<vector<int>> edges;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        int n, m, a, b;
        cin >> n >> m;
        Graph graph(n);
        for (int i = 0; i < m; i++) {
            cin >> a >> b;
            a--;
            b--;
            graph.add_edge(a, b);
        }
        vector<int> color(n, -1);

        cout << "Scenario #" << t << ":\n";
        bool suspicious = false;
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (graph.bfs(i, color)) {
                    suspicious = true;
                    break;
                }
            }
        }
        cout << (suspicious ? "Suspicious bugs found!"
                            : "No suspicious bugs found!")
             << "\n";
    }
    return 0;
}
