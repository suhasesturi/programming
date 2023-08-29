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
    int u, v, w;
};

int find(int x, vector<int>& parent) {
    if (x != parent[x]) {
        parent[x] = find(parent[x], parent);
    }
    return parent[x];
}

void perform_union(int x, int y, vector<int>& parent, vector<int>& rank) {
    int root_x = find(x, parent);
    int root_y = find(y, parent);
    if (root_x != root_y) {
        if (rank[x] >= rank[y]) {
            parent[root_y] = root_x;
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
        } else {
            parent[root_x] = root_y;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int p, n, m;
        cin >> p >> n >> m;
        vector<int> rank(n + 1);
        vector<int> parent(n + 1);
        for (int i = 1; i <= n; i++) {
            rank[i] = 1;
            parent[i] = i;
        }

        vector<Edge> edges(m, {0, 0, 0});
        for (int i = 0; i < m; i++) {
            cin >> edges[i].u >> edges[i].v >> edges[i].w;
        }
        sort(edges.begin(), edges.end(),
             [](const Edge& a, const Edge& b) { return a.w < b.w; });

        int result = 0;
        for (Edge& e : edges) {
            if (find(e.u, parent) == find(e.v, parent)) continue;
            perform_union(e.u, e.v, parent, rank);
            result += e.w;
        }
        cout << result * p << "\n";
    }
    return 0;
}
