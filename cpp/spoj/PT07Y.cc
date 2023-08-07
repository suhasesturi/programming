#include <math.h>

#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

class Graph {
   public:
    Graph(int n) {
        for (int i = 0; i < n; i++) {
            edge_list.push_back(vector<int>());
        }
    }

    void add_edge(int u, int v) {
        edge_list[u].push_back(v);
        edge_list[v].push_back(u);
    }

    bool dfs(int current, vector<bool>& visited) {
        return dfs_internal(current, -1, visited);
    }

   private:
    bool dfs_internal(int current, int from, vector<bool>& visited) {
        if (visited[current]) {
            return false;
        }
        visited[current] = true;
        for (int v : edge_list[current]) {
            if (v != from && !dfs_internal(v, current, visited)) {
                return false;
            }
        }
        return true;
    }

    vector<vector<int>> edge_list;
};

int main() {
    int n, m, a, b;
    cin >> n >> m;
    Graph graph(n);
    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        a--;
        b--;
        graph.add_edge(a, b);
    }

    vector<bool> visited(n, false);
    if (!graph.dfs(0, visited)) {
        cout << "NO";
    } else {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cout << "NO";
                return 0;
            }
        }
        cout << "YES";
    }
    return 0;
}
